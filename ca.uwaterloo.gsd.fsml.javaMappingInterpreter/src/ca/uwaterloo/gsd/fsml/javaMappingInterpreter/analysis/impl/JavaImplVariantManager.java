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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.provider.FsmlEditPlugin;
import ca.uwaterloo.gsd.fsml.implModel.Default;
import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
import ca.uwaterloo.gsd.fsml.implModel.Variant;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaImplVariantManager;

public class JavaImplVariantManager implements IJavaImplVariantManager {

	public static final String modelName = JavaImplVariantManagerConstants.MODEL_NAME
			+ JavaImplVariantManagerConstants.MODEL_FILE_EXTENSION;
	protected IJavaProject project = null;
	protected Resource resourceImplModel = null;

	private EClass implModelEClass = null;
	private EObject implModelEObject = null;
	private EList<EObject> existingResourceModel;
	private HashSet<String> overridedDefaultsMappingKeys = new HashSet<String>();

	private ResourceSet resourceSet;

	//since in forward, a new model is not created and defaults may have already been set in the current model
	//but the finish method will still be called, the following flag is necessary
	private boolean skipFinish = true;

	public JavaImplVariantManager(IJavaProject project) {
		this.project = project;
		this.initialize();
	}

	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init() {
	}

	private void initialize() {
		try {
			// Create a resource set
			//
			resourceSet = new ResourceSetImpl();
			skipFinish = false;
			IFile implModelFile = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(project.getPath().append(modelName));
			URI implModelURI = URI.createPlatformResourceURI(implModelFile
					.getFullPath().toString(), true);

			if (implModelFile.exists()) {

				existingResourceModel = resourceSet.getResource(implModelURI,
						true).getContents();

			}
			resourceImplModel = resourceSet.createResource(implModelURI);

			// create the model
			implModelEClass = ImplModelPackage.eINSTANCE.getimplModel();
			implModelEObject = EcoreUtil.create(implModelEClass);

		} catch (Exception exception) {
			FsmlEditPlugin.INSTANCE.log(exception);
		}
	}

	public EObject getModel() {
		return implModelEObject;
	}

	public void finish() {
		if (JavaMappingInterpreter.analyzeImplVariants()) {

			if (skipFinish) {
				return;
			}

			try {
				skipFinish = true;//next time
				computeDefault();

				// add the implementation model object to the content
				resourceImplModel.getContents().add(implModelEObject);

				// Save the contents of the resource to the file system.
				Map options = new HashMap();
				
				// Michal: TODO: fix it
				//options.put(XMLResource.OPTION_ENCODING, "ASCII");
				options.put("OPTION_ENCODING", "ASCII");
				
				resourceImplModel.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void computeDefault() {
		// adaptive/intelligent/predictive code generation goes here...

		// reset all the "overridden" defaults into the newly generated model
		if (existingResourceModel != null) {
			EList<EObject> implModelContents = existingResourceModel.get(0)
					.eContents();
			EObject currentFeature = null;
			for (int i = 0; i < implModelContents.size(); i++) {
				currentFeature = implModelContents.get(i);
				if (currentFeature.eClass().getName().startsWith(
						JavaImplVariantManagerConstants.DEFAULT)) {
					EStructuralFeature overrided = currentFeature.eClass()
							.getEStructuralFeature(
									JavaImplVariantManagerConstants.OVERRIDDEN);
					if (currentFeature.eGet(overrided).equals(Boolean.TRUE)) {
						String eClass = currentFeature
								.eGet(
										currentFeature
												.eClass()
												.getEStructuralFeature(
														JavaImplVariantManagerConstants.ECLASS))
								.toString();
						String eStructuralFeature = currentFeature
								.eGet(
										currentFeature
												.eClass()
												.getEStructuralFeature(
														JavaImplVariantManagerConstants.ESTRUCTURALFEATURE))
								.toString();

						// mapping key is by the mapping excluding mapping type,
						// not mapping type
						String mappingKey = eClass
								+ JavaImplVariantManagerConstants.DELIMITER
								+ eStructuralFeature;
						overridedDefaultsMappingKeys.add(mappingKey);
						((EList) implModelEObject.eGet(getDefaultsReference()))
								.add(currentFeature);
					}
				}
			}
		}

		EList<EObject> features = implModelEObject.eContents();

		/*alternatively, the variant EObject can be used as the key for the
		 *variant hashmap. However, since the equals in EObject is equivalent to ==
		 *instead of comparing the values in the EObjects, the containsKey
		 *method in HashMap will fail. Although EcoreUtil has an equals method for this
		 *purpose, using the method will require overriding the equals method in EObject (generated code that
		 *is current unstable)
		 *
		 */

		//anonymous class of the object stored in the variant hashmap   
		class VariantHashMapObject {
			int occurrences = 1;
			EObject variant = null;

			VariantHashMapObject(EObject variant) {
				this.variant = variant;
			}

			public int getOccurrences() {
				return occurrences;
			}

			public EObject getVariant() {
				return variant;
			}

			public VariantHashMapObject incrementOccurrences() {
				occurrences++;
				return this;
			}
		}

		HashMap<String, HashMap<String, VariantHashMapObject>> mapping = new HashMap<String, HashMap<String, VariantHashMapObject>>();

		// find the number of occurrences of each variant in each mapping
		for (EObject currentFeature : features) {

			if (!currentFeature.eClass().getName().startsWith(
					JavaImplVariantManagerConstants.DEFAULT)) {
				// make sure that it is a variant
				String eClass = currentFeature.eGet(
						currentFeature.eClass().getEStructuralFeature(
								JavaImplVariantManagerConstants.ECLASS))
						.toString();
				String eStructuralFeature = currentFeature
						.eGet(
								currentFeature
										.eClass()
										.getEStructuralFeature(
												JavaImplVariantManagerConstants.ESTRUCTURALFEATURE))
						.toString();

				// mapping key is by the mapping excluding mapping type, not
				// mapping type
				String mappingKey = eClass
						+ JavaImplVariantManagerConstants.DELIMITER
						+ eStructuralFeature;
				StringBuffer structuralFeatures = new StringBuffer();
				
				for (EStructuralFeature feature:currentFeature.eClass().getEAllAttributes()) {
					structuralFeatures.append(currentFeature.eGet(feature));
				}
				String variantKey = currentFeature.toString().replaceFirst(
						".+\\(", currentFeature.eClass().getName() + "(")+structuralFeatures.toString();

				if (overridedDefaultsMappingKeys.contains(mappingKey)) {
					System.err.println(mappingKey + " overrided by the user");
				} else {
					if (!mapping.containsKey(mappingKey)) {
						HashMap<String, VariantHashMapObject> variants = new HashMap<String, VariantHashMapObject>();
						variants.put(variantKey, new VariantHashMapObject(
								currentFeature));
						mapping.put(mappingKey, variants);
					} else {
						HashMap<String, VariantHashMapObject> variants = mapping
								.get(mappingKey);
						if (mapping.get(mappingKey).containsKey(variantKey)) {
							// check if the variant already exists
							variants.put(variantKey, variants.get(variantKey)
									.incrementOccurrences());
						} else {
							// variant is new
							variants.put(variantKey, new VariantHashMapObject(
									currentFeature));
						}
						mapping.put(mappingKey, variants);
					}
				}
			}
		}
		// iterate over the hash maps and set the defaults (the most frequently occuring) in the model
		for (String mappingKey : mapping.keySet()) {
			Map<String, VariantHashMapObject> variants = mapping
					.get(mappingKey);
			String variant = "";
			EObject defaultVariant = null;
			int maxOccurrences = 0;
			for (Map.Entry entry : variants.entrySet()) {
				int currentVariantOccurrences = ((VariantHashMapObject) entry
						.getValue()).getOccurrences();
				if (currentVariantOccurrences >= maxOccurrences) {
					if (currentVariantOccurrences == maxOccurrences) {
						System.out
								.println("More than one default variant candidates found ("
										+ currentVariantOccurrences + ")");
					}
					defaultVariant = EcoreUtil
							.copy(((VariantHashMapObject) entry.getValue())
									.getVariant());
					variant = (String) entry.getKey();
					maxOccurrences = currentVariantOccurrences;
				}
			}
			//set the defaults in the model
			try {

				String currentMappingType = variant.split(JavaImplVariantManagerConstants.DELIMITER)[1];

				EObject defaultForCurrentMapping = EcoreUtil
						.create(getDefaultEClass(JavaImplVariantManagerConstants.DEFAULT
								+ JavaImplVariantManagerConstants.DELIMITER
								+ currentMappingType));

				defaultForCurrentMapping
						.eSet(
								defaultForCurrentMapping
										.eClass()
										.getEStructuralFeature(
												JavaImplVariantManagerConstants.ECLASS),
								mappingKey
										.substring(
												0,
												mappingKey
														.indexOf(JavaImplVariantManagerConstants.DELIMITER)));
				defaultForCurrentMapping
						.eSet(
								defaultForCurrentMapping
										.eClass()
										.getEStructuralFeature(
												JavaImplVariantManagerConstants.ESTRUCTURALFEATURE),
								mappingKey
										.substring(
												mappingKey
														.indexOf(JavaImplVariantManagerConstants.DELIMITER) + 1,
												mappingKey.length()));

				((EList) implModelEObject.eGet(getDefaultsReference()))
						.add(defaultForCurrentMapping);

				((EList) defaultForCurrentMapping
						.eGet(getVariantReferenceForDefault(defaultForCurrentMapping
								.eClass()))).add(defaultVariant);

			} catch (FSMLMappingException e) {
				e.printStackTrace();
			}
		}

		//let's sort all the variants for easier readability
		
		if (features.size()==0) {
			return;
		}
		EObject[] result = features.toArray(new EObject[1]);
		{
			class NodeComparator implements Comparator {
				public int compare(Object o1, Object o2) {
					EObject e1 = (EObject) o1;
					EObject e2 = (EObject) o2;
					
					
					
					return (FSMLEcoreUtil.getFSMLId(e1,null).compareTo(FSMLEcoreUtil.getFSMLId(e2,null)));
				}
			}
			NodeComparator comparator = new NodeComparator();
			Arrays.sort(result,comparator);
		}
		implModelEObject= EcoreUtil.create(implModelEClass);
	
		for (EObject sortedFeature: result){
			if (sortedFeature.eClass().getName().startsWith(JavaImplVariantManagerConstants.DEFAULT)) {
				((EList) implModelEObject.eGet(getDefaultsReference()))
				.add(sortedFeature);
			} else {
				((EList) implModelEObject.eGet(getVariantsReference()))
				.add(sortedFeature);

			}
		}
		
	}

	public String getVariantName(EObject variant) {

		return variant.eClass().getName().replaceFirst(
				JavaImplVariantManagerConstants.VARIANT
						+ JavaImplVariantManagerConstants.DELIMITER + ".+"
						+ JavaImplVariantManagerConstants.DELIMITER, "");
	}

	public EObject getDefault(String eClass, String eStructuralFeature,
			String annotationSource) {

		// reload the model in case the user override the default
		//TODO: need to be smarter and only refresh the model from the disk once in each forward
		IFile implModelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				project.getPath().append(modelName));
		URI implModelURI = URI.createPlatformResourceURI(implModelFile
				.getFullPath().toString(), true);

		if (implModelFile.exists()) { // it should exist
			resourceSet = new ResourceSetImpl();
			existingResourceModel = resourceSet.getResource(implModelURI, true)
					.getContents();
			implModelEObject = existingResourceModel.get(0);
		} // TODO: else - the implModel is gone ...need to use the default from the metamodel 

		

		EList<Default> defaultMappingTypes = ((EList) implModelEObject
				.eGet(getDefaultsReference()));
		for (Default defaultMappingType : defaultMappingTypes) {
			if (defaultMappingType.eClass().getName().equals(
					JavaImplVariantManagerConstants.DEFAULT
							+ JavaImplVariantManagerConstants.DELIMITER
							+ annotationSource)) {
				// check if the mapping is the same (eClass and
				// eStructuralFeature)
				if (defaultMappingType.eGet(
						defaultMappingType.eClass().getEStructuralFeature(
								JavaImplVariantManagerConstants.ECLASS))
						.equals(eClass)
						&& defaultMappingType
								.eGet(
										defaultMappingType
												.eClass()
												.getEStructuralFeature(
														JavaImplVariantManagerConstants.ESTRUCTURALFEATURE))
								.equals(eStructuralFeature)) {

					EList<Variant> defaultVariants = ((EList) defaultMappingType
							.eGet(getVariantReferenceForDefault(defaultMappingType
									.eClass())));
					return defaultVariants.get(0);

				}
			} // if
		} // for

		return null;

	}

	public EReference getVariantsReference() {
		EList<EStructuralFeature> features = implModelEClass
				.getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature.getName().equals(
					JavaImplVariantManagerConstants.VARIANTS))
				return (EReference) feature;
		}
		return null;
	}

	public static EReference getVariantReferenceForDefault(EClass defaultEClass) {
		EList<EStructuralFeature> features = defaultEClass
				.getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature.getName().equals(
					JavaImplVariantManagerConstants.VARIANT))
				return (EReference) feature;
		}
		return null;

	}

	public EReference getDefaultsReference() {
		EList<EStructuralFeature> features = implModelEClass
				.getEAllStructuralFeatures();
		for (EStructuralFeature feature : features) {
			if (feature.getName().equals(
					JavaImplVariantManagerConstants.DEFAULTS))
				return (EReference) feature;
		}
		return null;
	}

	public EClass getVariantEClass(String name) throws FSMLMappingException {
		Collection<EClass> concreteClasses = FSMLEcoreUtil
				.getSubclassesOfEClass(getVariantsReference()
						.getEReferenceType(), true);
		EClass targetClass = null;
		for (EClass currentClass : concreteClasses) {
			if (currentClass.getName().equals(name)) {
				targetClass = currentClass;
				break;
			}
		}
		if (targetClass == null) {
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE,
					"in impl Model");

		}
		return targetClass;
	}

	public EClass getDefaultEClass(String name) throws FSMLMappingException {
		Collection<EClass> concreteClasses = FSMLEcoreUtil
				.getSubclassesOfEClass(getDefaultsReference()
						.getEReferenceType(), true);
		EClass targetClass = null;
		for (EClass currentClass : concreteClasses) {
			if (currentClass.getName().equals(name)) {
				targetClass = currentClass;
				break;
			}
		}
		if (targetClass == null) {
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE,
					"in impl Model");
		}
		return targetClass;
	}

}
