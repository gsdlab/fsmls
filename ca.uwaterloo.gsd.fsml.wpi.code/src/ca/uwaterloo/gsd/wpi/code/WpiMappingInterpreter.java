/*******************************************************************************
 * Copyright (c) 2010 Michal Antkiewicz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Michal Antkiewicz - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.wpi.code;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JarEntryFile;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.core.ischema.ISchema;
import org.eclipse.pde.internal.core.ischema.ISchemaElement;
import org.eclipse.pde.internal.core.plugin.PluginElement;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingInterpreter;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.stats.Stats;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class WpiMappingInterpreter extends FSMLMappingInterpreter {
	public static final String QUERY_EDITOR_CONTRIBUTOR = "editorContributor";
	public static final String QUERY_EDITOR_PART_ID = "editorPartId";
	public static final String QUERY_VIEW_PART_ID = "viewPartId";
	
	public String getDescription() {
		return "Workbench Part Interaction FSML Annotation Interpreter";
	}

	@Override
	public String[] getContextAnnotations() {
		return new String[] {};
	}
	@Override
	public String[] getQueryAnnotations() {
		return new String[] { QUERY_VIEW_PART_ID, QUERY_EDITOR_PART_ID, QUERY_EDITOR_CONTRIBUTOR };
	}
	
	public boolean reverseFeatureRepresentedAsAttribute(EObject element, EAttribute feature, IProgressMonitor progressMonitor) {
		IType type = (IType) Queries.INSTANCE.getContext(element, IType.class, true);
		IJavaProject project = (IJavaProject) Queries.INSTANCE.getContext(element, IJavaProject.class, true);
		
		EAnnotation annotation = feature.getEAnnotation(QUERY_VIEW_PART_ID);
		if (annotation != null) {
			PluginXmlQueryResult result = retrievePluginElement("org.eclipse.ui.views", "view", project, type, false);
			if (result != null) {
				IPluginElement pluginElement = result.getElement();
				IPluginAttribute attr = pluginElement.getAttribute("id");
				if (attr != null) {
					String value = attr.getValue();
					if (!feature.isMany()) {
						element.eSet(feature, value);
					
						Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
						Stats.INSTANCE.logScatteringAndTangling(element, feature, value, "plugin.xml");
						Stats.INSTANCE.logScatteringAndTangling(element, feature, value, "<view>()");
						return true;
					}
				}
			}
			return false;
		}
		annotation = feature.getEAnnotation(QUERY_EDITOR_PART_ID);
		if (annotation != null) {
			PluginXmlQueryResult result = retrievePluginElement("org.eclipse.ui.editors", "editor", project, type, false);
			if (result != null) {
				IPluginElement pluginElement = result.getElement();
				IPluginAttribute attr = pluginElement.getAttribute("id");
				if (attr != null) {
					String value = attr.getValue();
					if (!feature.isMany()) {
						element.eSet(feature, value);
						
						Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
						Stats.INSTANCE.logScatteringAndTangling(element, feature, value, "plugin.xml");
						Stats.INSTANCE.logScatteringAndTangling(element, feature, value, "<editor>()");
						return true;
					}
				}
			}
			return false;
		}
		annotation = feature.getEAnnotation(QUERY_EDITOR_CONTRIBUTOR);
		if (annotation != null) {
			// features value has been already set in createChildrenForQueryFeature()
			return true;
		}
		return false;
	}
	public boolean forwardFeatureRepresentedAsAttribute(EObject element, EAttribute feature, IProgressMonitor progressMonitor) throws JavaModelException {
		return false;
	}
	public boolean forwardFeatureRepresentedAsClass(EObject element, int action, IProgressMonitor progressMonitor) throws JavaModelException {
		return false;
	}
	public boolean reverseFeatureRepresentedAsReference(EObject element, EReference feature, IProgressMonitor progressMonitor) {
		return false;
	}
	public boolean forwardFeatureRepresentedAsReference(EObject element, EReference feature, IProgressMonitor progressMonitor) throws JavaModelException {
		return false;
	}
	
	private class PluginXmlQueryResult {
		WorkspacePluginModel pluginModel;
		IPluginExtension extension;
		IPluginElement element;
		public PluginXmlQueryResult(WorkspacePluginModel pluginModel, IPluginExtension extension, IPluginElement element) {
			this.pluginModel = pluginModel;
			this.extension = extension;
			this.element = element;
		}
		public IPluginElement getElement() {
			return element;
		}
		public IPluginExtension getExtension() {
			return extension;
		}
		public WorkspacePluginModel getPluginModel() {
			return pluginModel;
		}
	}
	public PluginXmlQueryResult retrievePluginElement(String extensionId, String elementName, IJavaProject project, IType type, boolean createIfNeeded) {
		WorkspacePluginModel pluginModel = getWorkspacePluginModel(project, type);
		if (pluginModel != null) {
			IPluginExtension foundExtension = null;
			IPluginElement foundElement = null;
			String fullyQualifiedName = type.getFullyQualifiedName();
			for (IPluginExtension extension : pluginModel.getExtensions().getExtensions()) {
				String point = extension.getPoint();
				if (point.equals(extensionId)) {
					for (IPluginObject child : extension.getChildren())
						if (child.getName().equals(elementName) && child instanceof IPluginElement) {
							IPluginElement element = (IPluginElement) child;
							IPluginAttribute attribute = element.getAttribute("class");
							if (attribute != null) {
								String className = attribute.getValue();
								if (className.equals(fullyQualifiedName))
									return new PluginXmlQueryResult(pluginModel, extension, element);
							}
						}
				}
			}
			// did not find a match
			if (createIfNeeded) {
				// if there was no extension or no element create them
				if (foundExtension == null) {
					foundExtension = pluginModel.getFactory().createExtension();
					try {
						pluginModel.getExtensions().add(foundExtension);
						foundExtension.setPoint(extensionId);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				if (foundElement == null) {
					foundElement = pluginModel.getFactory().createElement(foundExtension);
					try {
						foundExtension.add(foundElement);
						foundElement.setName(elementName);
						foundElement.setInTheModel(true);
						ISchema schema = (ISchema) foundExtension.getSchema();
						if (schema != null) {
							ISchemaElement schemaElement = schema.findElement(elementName);
							((PluginElement) foundElement).setElementInfo(schemaElement);
						}
						foundElement.setAttribute("name", type.getElementName());
						foundElement.setAttribute("class", fullyQualifiedName);
						return new PluginXmlQueryResult(pluginModel, foundExtension, foundElement);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
	public WorkspacePluginModel getWorkspacePluginModel(IJavaProject project, IType type) {
		IFile pluginXml = null;
		InputStream pluginXmlInputStream = null;
		
		if (!type.isBinary() && type.getJavaProject().equals(project))
			pluginXml = project.getProject().getFile("plugin.xml");
		else {
			IJavaElement parent = type.getPackageFragment().getParent();
			if (parent instanceof IPackageFragmentRoot) {
				IPackageFragmentRoot root = (IPackageFragmentRoot) parent;
				Object[] resources;
				try {
					resources = root.getNonJavaResources();
					for (int i = 0; i < resources.length; i++) {
						if (resources[i] instanceof IFile) {
							IFile file = (IFile) resources[i];
							if (file.getName().equals("plugin.xml")) {
								pluginXml = file;
								break;
							}
						}
						else if (resources[i] instanceof JarEntryFile) {
							JarEntryFile file = (JarEntryFile) resources[i];
							if (file.getName().equals("plugin.xml")) {
								pluginXmlInputStream = file.getContents();
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		}
		if (pluginXml != null && pluginXml.exists() || pluginXmlInputStream != null) {
			WorkspacePluginModel pluginModel = new WorkspacePluginModel(pluginXml, false);
			if (pluginModel != null) {
				if (pluginXmlInputStream != null) {
					try {
						pluginModel.reload(pluginXmlInputStream, false);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				else 
					pluginModel.load();
			}
			return pluginModel;
		}
		return null;
	}
	
	public boolean createChildrenForQueryFeature(EObject element, EReference feature, EClass concreteChildType, EStructuralFeature queryFeature, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject classElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_CLASS);
		IType type = (IType) getContext(classElement, IType.class, true); 
		
		EObject projectElement = FSMLEcoreUtil.retrieveContextElement(classElement, JavaMappingInterpreter.CONTEXT_PROJECT);
		IJavaProject project = (IJavaProject) getContext(projectElement, IJavaProject.class, true);
		
		EAnnotation annotation = queryFeature.getEAnnotation(QUERY_EDITOR_CONTRIBUTOR);
		if (annotation != null) {
			PluginXmlQueryResult result = retrievePluginElement("org.eclipse.ui.editors", "editor", project, type, false);
			if (result != null) {
				IPluginElement pluginElement = result.getElement();
				IPluginAttribute attr = pluginElement.getAttribute("contributorClass");
				if (attr != null) {
					String contributorName = attr.getValue();
					
					IType contributorType;
					try {
						contributorType = project.findType(contributorName);
					} catch (JavaModelException e) {
						e.printStackTrace();
						return false;
					}
					
					if (contributorType != null && contributorType.exists()) {
						if (!feature.isMany()) {
							EObject child = EcoreUtil.create(concreteChildType);
							
							associateContext(child, contributorType);
							
							element.eSet(feature, child);
							child.eSet(queryFeature, contributorName);
							
							if (Queries.INSTANCE.reverseFeatureRepresentedAsClass(child, progressMonitor)) {
								Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
								Stats.INSTANCE.logScatteringAndTangling(element, feature, null, "plugin.xml");
								Stats.INSTANCE.logScatteringAndTangling(element, feature, null, "<editor>()");
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	public EStructuralFeature findQueryFeature(EClass concreteChildType) {
		if (concreteChildType.getEAnnotation("class") != null)
			return FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(concreteChildType, new String[] { "essential", QUERY_EDITOR_CONTRIBUTOR } );
		return null;
	}
}
