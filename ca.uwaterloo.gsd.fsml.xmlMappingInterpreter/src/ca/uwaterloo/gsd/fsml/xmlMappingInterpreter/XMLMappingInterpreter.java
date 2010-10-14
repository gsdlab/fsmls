/*******************************************************************************
 * Copyright (c) 2010 Herman Lee.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Herman Lee - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.xmlMappingInterpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IndexedRegion;
import org.eclipse.wst.xml.core.internal.document.AttrImpl;
import org.eclipse.wst.xml.core.internal.document.DocumentImpl;
import org.eclipse.wst.xml.core.internal.document.ElementImpl;
import org.eclipse.wst.xml.core.internal.document.TextImpl;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMDocument;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.eclipse.wst.xml.core.internal.provisional.format.FormatProcessorXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingInterpreter;
import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;

public class XMLMappingInterpreter extends FSMLMappingInterpreter {

	private static final String QUERY_XML_ELEMENTS = "xmlElements";

	public static final String QUERY_XML_DOCUMENT = "xmlDocument";

	public static final String QUERY_XML_ELEMENT = "xmlElement";

	public static final String QUERY_XML_ATTRIBUTE = "xmlAttribute";

	@Override
	public String getDescription() {
		return "XML Annotation Interpreter";
	}

	public String[] getContextAnnotations() {
		return new String[] { QUERY_XML_ELEMENT, QUERY_XML_DOCUMENT, "project" };
	}

	@Override
	public String[] getQueryAnnotations() {
		return new String[] { QUERY_XML_ELEMENTS, QUERY_XML_ATTRIBUTE,
				"valueEqualsTo", "xmlElementValue",
				"xmlElementValueEqualsString", "noXMLElement","documentPath" };
	}

	public static final String id = "xml";

	public HashMap<EObject, Node> feature2Node = new HashMap<EObject, Node>();
	public HashMap<String, Node> feature2Node4Forward = new HashMap<String, Node>();
	public HashMap<EObject, IResource> feature2IResource = new HashMap<EObject, IResource>();
	public HashMap<String, IResource> feature2IResource4Forward = new HashMap<String, IResource>();
	public HashMap<EObject, Document> feature2IDOMDocument = new HashMap<EObject, Document>();
	public HashMap<String, Document> feature2IDOMDocument4Forward = new HashMap<String, Document>();

	@Override
	public boolean canForwardObjectUsingQueryMapping(EReference reference) {
		//TODO: support other mapping types
		if (reference.getEAnnotation(QUERY_XML_ELEMENTS) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean canHandleContext(Class contextClass) {
		return 	contextClass != null && (
				Node.class.isAssignableFrom(contextClass));
	}
	
	@Override
	public void associateContext(EObject object, Object context) {
		if (context instanceof Node){
			feature2Node.put(object, (Node)context);
			feature2Node4Forward.put(FSMLEcoreUtil.getFSMLId(object, null), (Node)context);
		}
	}
	
	@Override
	public boolean canAssociateContext(EObject eObject) {
		if (eObject.eClass().getEAnnotation(QUERY_XML_ELEMENT) != null||
				eObject.eClass().getEAnnotation(QUERY_XML_DOCUMENT) != null	) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void associateContext(int start, int end, EObject eObject) {
		EObject contextDocument= FSMLEcoreUtil.retrieveContextElement(eObject,QUERY_XML_DOCUMENT);
		
		IResource resource = feature2IResource.get(contextDocument);
		if (resource==null){
				EObject projectElement = FSMLEcoreUtil.retrieveContextElement(
						eObject, "project");
				IProject project = (IProject) Queries.INSTANCE.getContext(
					projectElement, IProject.class, true);


				String xmlDocPath = contextDocument.eClass().getEAnnotation(QUERY_XML_DOCUMENT).getDetails().get("path");
				IDOMModel xmlModel;
				try {
					xmlModel = (IDOMModel) StructuredModelManager.getModelManager()
					.getModelForEdit(project.getFile(xmlDocPath));
					feature2IDOMDocument.put(contextDocument, xmlModel.getDocument());
					feature2IDOMDocument4Forward.put(FSMLEcoreUtil.getFSMLId(contextDocument,
							null), xmlModel.getDocument());
					resource =  project.getFile(xmlDocPath);
					feature2IResource.put(contextDocument, project.getFile(xmlDocPath));
					feature2IResource4Forward.put(FSMLEcoreUtil.getFSMLId(contextDocument,
							null), project.getFile(xmlDocPath));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (CoreException e) {
					e.printStackTrace();
				}
		}
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(resource.getRawLocation());
		IDOMModel modelForEdit;
			try {
				modelForEdit = (IDOMModel) StructuredModelManager.getModelManager()
						.getModelForEdit(file);
				IndexedRegion indexedRegion = modelForEdit.getIndexedRegion(start);
				if (indexedRegion instanceof Node){
					feature2Node.put(eObject, (Node)indexedRegion);
					feature2Node4Forward.put(FSMLEcoreUtil.getFSMLId(eObject, null), (Node)indexedRegion);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}
	
	@Override
	public boolean forwardFeatureRepresentedAsClass(
			ClassSyncItem classSyncItem, IProgressMonitor progressMonitor)
			throws FSMLMappingException {
		// TODO Auto-generated method stub
		return super.forwardFeatureRepresentedAsClass(classSyncItem, progressMonitor);
	}
	
	@Override
	public boolean forwardFeatureRepresentedAsAttribute(
			StructuralFeatureSyncItem featureSyncItem,
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		
		EStructuralFeature feature = featureSyncItem.getStructuralFeature();
		EObject container = ((ClassSyncItem) featureSyncItem.eContainer()).getModel() != null ? ((ClassSyncItem) featureSyncItem.eContainer()).getModel(): ((ClassSyncItem) featureSyncItem.eContainer()).getCode();
 
		Element containerNode = (Element) feature2Node4Forward
				.get(FSMLEcoreUtil.getFSMLId(container, null));

		EObject contextDocument = FSMLEcoreUtil.retrieveContextElement(
				container, QUERY_XML_DOCUMENT);
		IResource resource = feature2IResource4Forward.get(FSMLEcoreUtil
				.getFSMLId(contextDocument, null));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(resource.getRawLocation());
		IDOMModel modelForEdit;
		Document contextDocumentNode = feature2IDOMDocument4Forward
				.get(FSMLEcoreUtil.getFSMLId(contextDocument, null));
		try {
			modelForEdit = (IDOMModel) StructuredModelManager.getModelManager()
					.getModelForEdit(file);
			modelForEdit.aboutToChangeModel();

			DocumentImpl document = (DocumentImpl) modelForEdit.getDocument();
			AttrImpl newAttributeNode = null;
			EAnnotation annotation = feature
					.getEAnnotation(QUERY_XML_ATTRIBUTE);

			if (annotation.getDetails().get("name") != null) {
				newAttributeNode = (AttrImpl) document
						.createAttribute(annotation.getDetails().get("name"));
				newAttributeNode.setValue((String) container.eGet(feature));
			} else {
				newAttributeNode = (AttrImpl) document.createAttribute(feature
						.getName());
				while (container.eGet(feature)==null){
					container.eSet(feature,FSMLEcoreUtil.getAttributeValueFromAttributeValueWizard((EAttribute)feature));
				}
				newAttributeNode.setValue((String) container.eGet(feature));
			}
			containerNode.setAttributeNode(newAttributeNode);
			FormatProcessorXML formatter = new FormatProcessorXML();
			formatter.formatNode(containerNode);
			modelForEdit.save();
			modelForEdit.changedModel();
			modelForEdit.releaseFromEdit();
			MarkerDescriptor markerDescriptor = Markers
					.createMarkerDescriptor(resource);

			markerDescriptor.setAttributes(feature, newAttributeNode
					.getStartOffset(), newAttributeNode.getEndOffset());
			markerDescriptor.create(container);

		} catch (IOException e) {
			throw new FSMLMappingException(Cause.UNKNOWN,
					"Error in XML Forward, IOException");
		} catch (CoreException e) {
			throw new FSMLMappingException(Cause.UNKNOWN,
					"Error in XML Forward, CoreException");
		}
		return true;
	}

	@Override
	public boolean forwardFeatureRepresentedAsReference(
			ClassSyncItem classSyncItem, IProgressMonitor progressMonitor)
			throws FSMLMappingException {
		EObject elementToForward = classSyncItem.getModel() != null ? classSyncItem
				.getModel()
				: classSyncItem.getCode();
		// in case a class isn't associated with an xml element
		EObject contextElement = FSMLEcoreUtil.retrieveContextElement(
				elementToForward, QUERY_XML_ELEMENT);
		EObject contextDocument = FSMLEcoreUtil.retrieveContextElement(
				elementToForward, QUERY_XML_DOCUMENT);
		IResource resource = feature2IResource4Forward.get(FSMLEcoreUtil
				.getFSMLId(contextDocument, null));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(resource.getRawLocation());
		IDOMModel modelForEdit;
		try {
			Document contextDocumentNode = feature2IDOMDocument4Forward
					.get(FSMLEcoreUtil.getFSMLId(contextDocument, null));
			modelForEdit = (IDOMModel) StructuredModelManager.getModelManager()
					.getModelForEdit(file);

			Node contextElementNode = feature2Node4Forward.get(FSMLEcoreUtil
					.getFSMLId(contextElement.eContainer(), null));
			// get the path of the reference

			String path = contextElement.eContainingFeature().getEAnnotation(
					QUERY_XML_ELEMENTS).getDetails().get("path");
			
			//start editing the xml file
			modelForEdit.aboutToChangeModel();
			DocumentImpl document = (DocumentImpl) modelForEdit
			.getDocument();
			
			if (!path.equals("/")) {
				String elementToCreate = null;
				if (path.indexOf("/") == -1) {
					elementToCreate = path;
				} else {
					elementToCreate = path.substring(path.lastIndexOf("/") + 1, path.length());
					path = path.substring(0, path.lastIndexOf("/")); // cut out the last part of the path since that is for the new node
					StringTokenizer tokenizer = new StringTokenizer(path, "/");

					Node currentNode = null;
					ArrayList<Node> result = new ArrayList<Node>();
					Node lastPathElementNodeFound = contextElementNode;
					StringBuffer partsOfPathFoundInCode = new StringBuffer();
					if (path.charAt(0) != '/') { // it's a relative path
						Node parent = contextElementNode;
						currentNode = parent.getFirstChild();
					} else { // it's an absolute path

						// we want to check the first token to see whether the
						// name is the same as root node's name
						// if not, just return an empty vector
						// if so, we can move on to the next token in the xpath
						currentNode = contextDocumentNode;
						if (!currentNode.getNodeName().equals(
								tokenizer.nextToken())) {
							throw new FSMLMappingException(
									Cause.MODEL_NAVIGATION_ERROR,
									"invalid xml path");
						}
						currentNode = currentNode.getFirstChild();
					}

					String currentToken = tokenizer.nextToken();

					while (currentNode != null) {
						if (currentNode instanceof ElementImpl) {
							if (currentToken == null) {
								contextElementNode = null;
							}
							if (currentNode.getNodeName().equals(currentToken)) {
								// proceed to produce the nodeList
								String currentTokenValue = currentToken;
								try {
									lastPathElementNodeFound = currentNode;
									partsOfPathFoundInCode.append(currentToken+"/");
									currentToken = tokenizer.nextToken(); // pre-get the next token to see if we are in the last token
								} catch (NoSuchElementException e) {
									// reached the end of the xpath
									result.add(currentNode);
									currentToken = currentTokenValue;
									// look for sibling
									currentNode = currentNode.getNextSibling();
									continue;
								}
								currentNode = currentNode.getFirstChild();
								continue;
							}
						}
						currentNode = currentNode.getNextSibling();
					}
					if (result.size()==0) {
						//couldn't find the elements specified in path
						//create the xml elements
						tokenizer = new StringTokenizer(path.replaceAll(partsOfPathFoundInCode.toString(), ""), "/");
						while (tokenizer.hasMoreTokens()) {
							ElementImpl newElementNode = (ElementImpl) document
							.createElement(tokenizer.nextToken());
							lastPathElementNodeFound.appendChild(newElementNode);
							lastPathElementNodeFound=newElementNode;
						}
						contextElementNode = lastPathElementNodeFound;
					} else {
						contextElementNode = result.get(0);
					}
				}
		
				ElementImpl newElementNode = (ElementImpl) document
						.createElement(elementToCreate);
				feature2Node4Forward.put(FSMLEcoreUtil.getFSMLId(
						elementToForward, null), newElementNode);
				contextElementNode.appendChild(newElementNode);

				FormatProcessorXML formatter = new FormatProcessorXML();
				formatter.formatNode(contextElementNode);
				
				modelForEdit.save();
				modelForEdit.changedModel();
				modelForEdit.releaseFromEdit();
				
				
				//set the markers
				MarkerDescriptor markerDescriptor = Markers
						.createMarkerDescriptor(resource);
				markerDescriptor.setAttributes(null, newElementNode
						.getStartOffset(), newElementNode.getEndOffset());
				markerDescriptor.create(elementToForward);

			}

		} catch (IOException e1) {
			throw new FSMLMappingException(Cause.UNKNOWN,
					"Error in XML Forward, IOException");
		} catch (CoreException e1) {
			throw new FSMLMappingException(Cause.UNKNOWN,
					"Error in XML Forward, CoreException");
		}

		return true;
	}

	public boolean canCreateChildrenForDefaultQuery(EClass eClass) {
		return FSMLEcoreUtil.getEAnnotation(eClass, QUERY_XML_DOCUMENT) != null;
	}

	public boolean createChildrenForDefaultQuery(EObject element,
			EReference feature, EClass referenceType,
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(referenceType,
				QUERY_XML_DOCUMENT);
		if (annotation != null) {
			EObject projectElement = FSMLEcoreUtil.retrieveContextElement(
					element, "project");
			IProject project = (IProject) Queries.INSTANCE.getContext(
					projectElement, IProject.class, true);

			String pathName = (String) annotation.getDetails().get("path");
			String fileName = (String) annotation.getDetails().get("fileName");
			//ResourcesPlugin.getWorkspace().getRoot().getFile(path)
			
			if ((pathName == null || pathName.isEmpty()) &&(fileName == null || fileName.isEmpty())) 
				return false;
			
			ArrayList<IFile> xmlDocumentsToCreate = new ArrayList<IFile>();
			if (pathName != null){
				IFile fileFromPath = project.getFile(pathName);
				if (fileFromPath.exists()){
					xmlDocumentsToCreate.add(fileFromPath);
				}				
			}
			else{
				try{
					for (IResource resource : project.members()) {
						if (resource instanceof IFile && resource.getName().equalsIgnoreCase(fileName)){
							xmlDocumentsToCreate.add((IFile)resource);
						}
						else if (resource instanceof IFolder){
							this.searchFolderForFile((IFolder)resource,fileName,xmlDocumentsToCreate);
						}
					}
				}
				catch(CoreException e){
					return false; 
				}
			}
			for (IFile file : xmlDocumentsToCreate) {
				IDOMModel xmlModel;
				try {
					xmlModel = (IDOMModel) StructuredModelManager.getModelManager()
							.getModelForEdit(file);
				} catch (Exception e) {
					return false;
				}
				IDOMDocument xmlDocument = xmlModel.getDocument();
	
				EObject child = EcoreUtil.create(referenceType);
	
				EAnnotation firstXMLDocumentElement = FSMLEcoreUtil.getEAnnotation(
						referenceType, QUERY_XML_ELEMENT);
	
				String firstXMLDocumentElementName = null;
				if (firstXMLDocumentElement != null)
					firstXMLDocumentElementName = (String) firstXMLDocumentElement
							.getDetails().get("name");
	
				Node rootElement = xmlDocument.getFirstChild();
				while (rootElement!=null &&(!(rootElement instanceof Element)
						|| !rootElement.getNodeName().equals(
								firstXMLDocumentElementName))) {
					rootElement = rootElement.getNextSibling();
				}
				if (rootElement!=null) {
					feature2Node.put(child, rootElement);
				} else {
					return false;
				}
				if (feature.isMany())
					((EList) element.eGet(feature)).add(child);
				else
					element.eSet(feature, child);
	
				feature2IDOMDocument.put(child, xmlDocument);
				feature2IDOMDocument4Forward.put(FSMLEcoreUtil.getFSMLId(child,
						null), xmlDocument);
				if (file.exists()) {
					feature2IResource.put(child, file);
					feature2IResource4Forward.put(FSMLEcoreUtil.getFSMLId(child,
							null), file);
					if (rootElement instanceof ElementImpl){
						MarkerDescriptor markerDescriptor = Markers
								.createMarkerDescriptor(file);
						markerDescriptor.setAttributes(null, ((ElementImpl)rootElement)
								.getStartOffset(), ((ElementImpl)rootElement).getEndOffset());
						markerDescriptor.create(child);
					}
				}
				if (reverseFeatureRepresentedAsClass(child, progressMonitor)) {
					Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				}
				if (rootElement!=null){
					feature2Node4Forward.put(FSMLEcoreUtil.getFSMLId(child, null),
							rootElement);
				}
			}
			return true;
		}
		return false;
	}

	private void searchFolderForFile(IFolder folder, String fileName, ArrayList<IFile> xmlDocumentsToCreate) {
		try{
			for (IResource resource : folder.members()) {
				if (resource instanceof IFile && resource.getName().equalsIgnoreCase(fileName)){
					xmlDocumentsToCreate.add((IFile)resource);
				}
				else if (resource instanceof IFolder){
					this.searchFolderForFile((IFolder)resource,fileName,xmlDocumentsToCreate);
				}
			}
		}
		catch (CoreException e){
			return; 
		}
	}

	@Override
	public boolean reverseFeatureRepresentedAsAttribute(EObject element,
			EAttribute attribute, IProgressMonitor progressMonitor) {
		EAnnotation annotation3 = attribute.getEAnnotation(QUERY_XML_ATTRIBUTE);
		if (annotation3 != null) {
			EObject aux = FSMLEcoreUtil.retrieveContextElement(element,
					QUERY_XML_ELEMENT);
			ElementImpl currentNode = (ElementImpl) feature2Node.get(aux);
			EObject documentElement = FSMLEcoreUtil.retrieveContextElement(aux,
					QUERY_XML_DOCUMENT);
			IResource resource = feature2IResource.get(documentElement);
			String attributeName = (String) annotation3.getDetails()
					.get("name");
			if (attributeName == null) { // i.e. if the name detail is not
				// present, just use the attribute's
				// name
				attributeName = attribute.getName();
			}
			if (currentNode.getAttributes().getNamedItem(attributeName) == null) {
				return false;
			}
			String attributeValue = currentNode.getAttributes().getNamedItem(
					attributeName).getNodeValue();
			element.eSet(attribute, attributeValue);

			MarkerDescriptor markerDescriptor = Markers
					.createMarkerDescriptor(resource);

			AttrImpl attrImpl = (AttrImpl) currentNode.getAttributes()
					.getNamedItem(attributeName);

			markerDescriptor.setAttributes(attribute,
					attrImpl.getStartOffset(), attrImpl.getEndOffset());
			markerDescriptor.create(element);
			Stats.INSTANCE.logScatteringAndTangling(element, attribute, null,
					"<" + currentNode.getNodeName() + ">()");
			Stats.INSTANCE.logScatteringAndTangling(element, attribute, null,
					resource.getProjectRelativePath().toString());
			return true;
		}
		annotation3 = attribute.getEAnnotation("xmlElementValue");
		if (annotation3 != null) {
			EObject aux = FSMLEcoreUtil.retrieveContextElement(element,
					QUERY_XML_ELEMENT);
			ElementImpl currentNode = (ElementImpl) feature2Node.get(aux);
			EObject documentElement = FSMLEcoreUtil.retrieveContextElement(aux,
					QUERY_XML_DOCUMENT);
			IResource resource = feature2IResource.get(documentElement);
			if (currentNode == null || !(currentNode.getFirstChild() instanceof TextImpl)) {
				return false;
			}
			TextImpl childNode = (TextImpl) currentNode.getFirstChild();
			String nodeValue = childNode.getData();
			element.eSet(attribute, nodeValue);
			MarkerDescriptor markerDescriptor = Markers
					.createMarkerDescriptor(resource);
			markerDescriptor.setAttributes(null, currentNode.getStartOffset(),
					currentNode.getEndOffset());
			markerDescriptor.create(element);
			Stats.INSTANCE.logScatteringAndTangling(element, attribute, null,
					"<" + currentNode.getNodeName() + ">()");
			Stats.INSTANCE.logScatteringAndTangling(element, attribute, null,
					resource.getProjectRelativePath().toString());
			return true;
		}
		annotation3 = attribute.getEAnnotation("xmlElementValueEqualsString");
		if (annotation3 != null) {
			String stringBeingSearchedFor = (String) annotation3.getDetails()
					.get("StringToSearchFor");
			EObject aux = FSMLEcoreUtil.retrieveContextElement(element,
					QUERY_XML_ELEMENT);
			ElementImpl currentNode = (ElementImpl) feature2Node.get(aux);
			EObject documentElement = FSMLEcoreUtil.retrieveContextElement(aux,
					QUERY_XML_DOCUMENT);
			IResource resource = feature2IResource.get(documentElement);
			if (!(currentNode.getFirstChild() instanceof TextImpl)) {
				return false;
			}
			TextImpl childNode = (TextImpl) currentNode.getFirstChild();
			String nodeValue = childNode.getData();
			if (nodeValue.equalsIgnoreCase(stringBeingSearchedFor)) {
				element.eSet(attribute, true);
			} else {
				element.eSet(attribute, false);
			}

			MarkerDescriptor markerDescriptor = Markers
					.createMarkerDescriptor(resource);
			markerDescriptor.setAttributes(null, currentNode.getStartOffset(),
					currentNode.getEndOffset());
			markerDescriptor.create(element);
			Stats.INSTANCE.logScatteringAndTangling(element, attribute, null,
					"<" + currentNode.getNodeName() + ">()");
			Stats.INSTANCE.logScatteringAndTangling(element, attribute, null,
					resource.getProjectRelativePath().toString());

			return true;
		}
		annotation3 = attribute.getEAnnotation("noXMLElement");
		if (annotation3 != null) {
			String path = (String) annotation3.getDetails().get("path");
			EObject aux = FSMLEcoreUtil.retrieveContextElement(element,
					QUERY_XML_ELEMENT);
			ElementImpl currentNode = (ElementImpl) feature2Node.get(aux);
			EObject documentElement = FSMLEcoreUtil.retrieveContextElement(aux,
					QUERY_XML_DOCUMENT);
			IResource resource = feature2IResource.get(documentElement);

			ArrayList<Node> resultVector = findChildGivenPath(aux, path);
			if (resultVector.isEmpty()) {
				element.eSet(attribute, true);
			} else {
				element.eSet(attribute, false);
			}
			MarkerDescriptor markerDescriptor = Markers
					.createMarkerDescriptor(resource);
			markerDescriptor.setAttributes(null, currentNode.getStartOffset(),
					currentNode.getEndOffset());
			markerDescriptor.create(element);
			return true;
		}
		annotation3 = attribute.getEAnnotation("documentPath");
		if (annotation3 != null) {
			EObject documentElement = FSMLEcoreUtil.retrieveContextElement(element,QUERY_XML_DOCUMENT);
			IResource resource = feature2IResource.get(documentElement);
			element.eSet(attribute, resource.getFullPath().toString());
			return true; 
		}
		return false;
	}

	private ArrayList<Node> findChildGivenPath(EObject aux, String path) {
		// skip TextImpl and DocumentTypeImpl
		// or just try to look for the next ElementImpl
		ArrayList<Node> result = new ArrayList<Node>();
		if (path == null){
			return result;
		}
		StringTokenizer tokenizer = new StringTokenizer(path, "/");

		Node currentNode = null;
		
		if (path.charAt(0) != '/') { // it's a relative path
			Node parent = feature2Node.get(aux);
			if (parent==null) {
				return result;
			}
			currentNode = parent.getFirstChild();
		} else { // it's an absolute path

			EObject documentElement = FSMLEcoreUtil.retrieveContextElement(aux,
					QUERY_XML_DOCUMENT);
			Node root = feature2Node.get(documentElement);
			// we want to check the first token to see whether the name is the
			// same as root node's name
			// if not, just return an empty vector
			// if so, we can move on to the next token in the xpath
			currentNode = root;
			if (!currentNode.getNodeName().equals(tokenizer.nextToken())) {
				return result;
			}
			currentNode = currentNode.getFirstChild();
		}

		String currentToken = tokenizer.nextToken();

		while (currentNode != null) {
			if (currentNode instanceof ElementImpl) {
				if (currentToken == null) {
					return null;
				}
				if (currentNode.getNodeName().equals(currentToken)) {
					// proceed to produce the nodeList
					String currentTokenValue = currentToken;
					try {
						currentToken = tokenizer.nextToken(); // pre-get the
						// next token to
						// see if we are
						// in the last
						// token
					} catch (NoSuchElementException e) {
						// reached the end of the xpath
						result.add(currentNode);
						currentToken = currentTokenValue;
						// look for sibling
						currentNode = currentNode.getNextSibling();
						continue;
					}
					currentNode = currentNode.getFirstChild();
					continue;
				}
			}
			currentNode = currentNode.getNextSibling();
		}
		// return result when there are no more siblings
		return result;

	}

	@Override
	public boolean reverseFeatureRepresentedAsReference(EObject element,
			EReference reference, EClass referenceType,
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		EAnnotation annotation = reference.getEAnnotation(QUERY_XML_ELEMENTS);
		if (annotation != null) {
			String path = (String) annotation.getDetails().get("path");

			EObject aux = FSMLEcoreUtil.retrieveContextElement(element,
					QUERY_XML_ELEMENT);
			ArrayList<Node> resultVector = findChildGivenPath(aux, path);
			if (resultVector.isEmpty()){
				path = (String) annotation.getDetails().get("path2");
				resultVector = findChildGivenPath(aux, path);
			}

			// let's sort the nodes
			Object[] result = resultVector.toArray();

			
//			  { class NodeComparator implements Comparator { public int
//			  compare(Object o1, Object o2) { ElementImpl e1 = (ElementImpl)
//			  o1; ElementImpl e2 = (ElementImpl) o2;
//			  
//			  //TODO: need to modify this hard-coding
//			  
//			  if (e1.getAttributes().getNamedItem("name") == null
//								|| e2.getAttributes().getNamedItem("name") == null) {
//							return (e1.getAttributes().getNamedItem("path")
//									.getNodeValue()).compareTo(e2
//									.getAttributes().getNamedItem("path")
//									.getNodeValue());
//						} else {
//							return (e1.getAttributes().getNamedItem("name")
//									.getNodeValue()).compareTo(e2
//									.getAttributes().getNamedItem("name")
//									.getNodeValue());
//						}
//					}
//				}
//				NodeComparator comparator = new NodeComparator();
//				Arrays.sort(result, comparator);
//			}
			 

			for (int i = 0; i < result.length; i++) {
				EObject child = EcoreUtil.create(referenceType);
				feature2Node.put(child, (Node) result[i]);

				if (reference.isMany()) {
					((EList) element.eGet(reference)).add(child);
				} else {
					element.eSet(reference, child);

				}
				reverseFeatureRepresentedAsClass(child, progressMonitor);
				feature2Node4Forward.put(FSMLEcoreUtil.getFSMLId(child, null),
						(Node) result[i]);

				EObject documentElement = FSMLEcoreUtil.retrieveContextElement(
						aux, QUERY_XML_DOCUMENT);
				IResource resource = feature2IResource.get(documentElement);
				ElementImpl elementImpl = (ElementImpl) result[i];
				MarkerDescriptor markerDescriptor = Markers
						.createMarkerDescriptor(resource);
				markerDescriptor.setAttributes(null, elementImpl
						.getStartOffset(), elementImpl.getEndOffset());
				markerDescriptor.create(child);
				Stats.INSTANCE.logScatteringAndTangling(element, reference,
						null, resource.getProjectRelativePath().toString());
			}
			if (result.length>0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
