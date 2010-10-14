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
package ca.uwaterloo.gsd.fsml.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.provider.FsmlEditPlugin;
import ca.uwaterloo.gsd.fsml.preferences.FSMLPreferenceConstants;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class Stats {
	/**
	 * Singleton
	 */
	public static final Stats INSTANCE = new Stats();
	private final MessageConsole console = new MessageConsole("FSML", null);
	private final MessageConsoleStream consoleStream = console.newMessageStream();
	private Stats() {
		// add the console
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
		reset();
	}
	/**
	 * Whether to log, count and print instances of features
	 */
	public static boolean logFeatureInstances() {
		return FsmlEditPlugin.getPlugin().getPreferenceStore().getBoolean(FSMLPreferenceConstants.LOG_FEATURE_INSTANCE_ID);
	}
	boolean logFeatureInstances;
	private HashMap<String, Integer> features;
	
	/**
	 * Whether to log, count and print metamodel annotations
	 */
	public static boolean logMetamodelAnnotations() {
		return FsmlEditPlugin.getPlugin().getPreferenceStore().getBoolean(FSMLPreferenceConstants.LOG_METAMODEL_ANNOTATIONS_ID);
	}
	boolean logMetamodelAnnotations;
	private HashMap<String, Integer> metamodelAnnotations;
	
	/**
	 * Whether to log, count and print implementation variants
	 */
	public static boolean logCodePatternVariants() {
		return FsmlEditPlugin.getPlugin().getPreferenceStore().getBoolean(FSMLPreferenceConstants.LOG_CODE_PATTERN_VARIANTS_ID);
	}
	boolean logCodePatternVariants;
	private HashMap<String, HashMap<String,Integer>> codePatternVariants;
	
	/**
	 * Whether to log, count and print errors
	 */
	public static boolean logErrors() {
		return FsmlEditPlugin.getPlugin().getPreferenceStore().getBoolean(FSMLPreferenceConstants.LOG_ERRORS_ID);
	}
	boolean logErrors;
	private HashMap<String, Integer> errors;
	
	/**
	 * Whether to print messages during the execution
	 */
	public static boolean logMessages() { 
		return FsmlEditPlugin.getPlugin().getPreferenceStore().getBoolean(FSMLPreferenceConstants.LOG_MESSAGES_ID);
	}
	boolean logMessages;
	private HashMap<String, Integer> messages;
	
	/**
	 * Whether to log, count and print errors
	 */
	public static boolean logBugs() { 
		return FsmlEditPlugin.getPlugin().getPreferenceStore().getBoolean(FSMLPreferenceConstants.LOG_BUGS_ID);
	}
	boolean logBugs;
	private HashMap<String, Integer> bugs;
	
	/**
	 * Whether to log, count and print scattering and tangling
	 */
	public static boolean logScatteringAndTangling() { 
		return FsmlEditPlugin.getPlugin().getPreferenceStore().getBoolean(FSMLPreferenceConstants.COMPUTE_SCATTERING_AND_TANGLING_MEASURES_ID);
	}
	public boolean logScatteringAndTangling;
	private HashMap<String, HashMap<String, Integer>> scatteringAndTangling;
	
	public void reset() {
		features = new HashMap<String, Integer>();
		metamodelAnnotations = new HashMap<String, Integer>();
		codePatternVariants = new HashMap<String, HashMap<String,Integer>>();
		errors = new HashMap<String, Integer>();
		messages = new HashMap<String, Integer>();
		bugs = new HashMap<String, Integer>();
		scatteringAndTangling = new HashMap<String, HashMap<String, Integer>>();
		
		console.clearConsole();
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
		
		logBugs = logBugs();
		logCodePatternVariants = logCodePatternVariants();
		logErrors = logErrors();
		logFeatureInstances = logFeatureInstances();
		logMessages = logMessages();
		logMetamodelAnnotations = logMetamodelAnnotations();
		logScatteringAndTangling = logScatteringAndTangling();
	}
	
	private void logAndIncrement(String key, HashMap<String, Integer> map) {
		Integer count = map.get(key);
		if (count == null)
			map.put(key, 1);
		else
			map.put(key, count + 1);
	}
	
	public void logFeatureInstance(String feature) {
		if (!logFeatureInstances)
			return;
		
		logAndIncrement(feature, features);
	}
	public String computeFeatureId(EObject element, EStructuralFeature eStructuralFeature) {
		StringBuffer pathToRoot = new StringBuffer();
		EObject aux = element;
		while (aux.eContainingFeature() != null) {
			pathToRoot.insert(0, aux.eContainingFeature().getName() + "  ");
			aux = aux.eContainer();
		}
		return pathToRoot + (eStructuralFeature != null ? eStructuralFeature.getName() : "" );
	}
	public void logFeatureInstance(EObject element, EStructuralFeature eStructuralFeature, EAnnotation annotation) {
		logFeatureInstance(
				computeFeatureId(element, eStructuralFeature) + 
				(annotation != null ? " <" + annotation.getSource() + ">" : "" )
		);
	}
	
	public void logImplVariant (String feature, String implVariant) {
		if (!codePatternVariants.containsKey(feature)) {
			HashMap<String, Integer> implVariants = new HashMap<String, Integer>();
			implVariants.put(implVariant, new Integer(1));
			codePatternVariants.put(feature, implVariants);
		}
		else {
			HashMap<String, Integer> implVariants = codePatternVariants.get(feature);
			if (!implVariants.containsKey(implVariant)) {
				implVariants.put(implVariant, new Integer(1));
				codePatternVariants.put(feature,implVariants);
			}
			else {
				Integer count = implVariants.get(implVariant);
				count++;
				implVariants.put(implVariant, count);
				codePatternVariants.put(feature,implVariants);
			}
		}
		
	}
	
	public void logImplVariant(EClass eClass, EStructuralFeature eStructuralFeature, EAnnotation annotation, String implVariant) {
		logImplVariant(eClass.getName() + "::" + eStructuralFeature.getName() + " <" + annotation.getSource() + ">", implVariant);
	}
	
	public void logError(String error) {
		if (!logErrors)
			return;
		
		logAndIncrement(error, errors);
		// Michal: output errors to the debug console anyway
		System.out.println("Error: " + error);
	}

	public void printMessage(String message) {
		if (logMessages)
			consoleStream.println(message);
		// Michal: output messages to the debug console anyway
		System.out.println("Message: " + message);
	}
	public void logMessage(String message) {
		if (!logMessages)
			return;
		
		logAndIncrement(message, messages);
	}
	public void logBug(String message) {
		logAndIncrement(message, bugs);
		// Michal: output bugs to the debug console anyway
		System.out.println("Bug: " + message);
	}
	public void logMetamodelAnnotation(EModelElement modelElement) {
		if (!logMetamodelAnnotations)
			return;
		
		ArrayList<EAnnotation> annotations = FSMLEcoreUtil.getAllEAnnotations(modelElement);
		for (Object object : annotations) {
			EAnnotation annotation = (EAnnotation) object;
			String key = annotation.getSource();
			
			logAndIncrement(key, metamodelAnnotations);
		}
	}
	public void logScatteringAndTangling(EObject element, EStructuralFeature feature, Object value, String location) {
		if (!logScatteringAndTangling)
			return;
		
		if (element instanceof Model)
			return;
		
		// navigate to the concern, i.e., concept contained by the model
		
		EObject concern = element;
		String concernId = null;
		
		while (concern.eContainer() != null) {
			EClass eClass = concern.eClass();
			EReference baseConceptReference = FSMLEcoreUtil.findBaseConceptReference(eClass);
			if (baseConceptReference != null) {
				concern = (EObject) concern.eGet(baseConceptReference);
				eClass = concern.eClass();
			}
			EStructuralFeature fqNameFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { "fullyQualifiedName" });
			if (fqNameFeature != null) { 
				concernId = (String) concern.eGet(fqNameFeature);
				break;
			}
			else {
				EStructuralFeature nameFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { "className" });
				EStructuralFeature qualifierFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { "qualifier" });
				if (nameFeature != null) {
					String name = (String) concern.eGet(nameFeature);
					String qualifier = (String) concern.eGet(qualifierFeature);
					concernId = qualifier != null ?
							qualifier + "."	+ name :
							name;
					break;
				}
			}
			concern = concern.eContainer();
		}
			
		if (concernId == null)
			return;
		HashMap<String, Integer> locationsOfConcern = scatteringAndTangling.get(concernId);
		if (locationsOfConcern == null) {
			locationsOfConcern = new HashMap<String, Integer>();
			locationsOfConcern.put(location, 1);
			scatteringAndTangling.put(concernId, locationsOfConcern);
		}
		else 
			logAndIncrement(location, locationsOfConcern);
	}
	public void printScatteringAndTangling() {
		if (! logScatteringAndTangling)
			return;
		
		consoleStream.print("\nScattering and tangling: ");
		
		StringBuffer buffer = new StringBuffer();
		if (scatteringAndTangling.size() > 0)
			buffer.append(": (" + scatteringAndTangling.size() + ")\n");
		
		HashMap<String, List<String>> components = new HashMap<String, List<String>>();
		HashMap<String, List<String>> operations = new HashMap<String, List<String>>();
		
		int numberOfConcerns = 0;
		for (Entry<String, HashMap<String, Integer>> entry : scatteringAndTangling.entrySet()) {
			String concern = entry.getKey();
			numberOfConcerns++;
			for (Entry<String, Integer> locationEntry : entry.getValue().entrySet()) {
				String location = locationEntry.getKey();
				buffer.append(concern + "\t" + location + "\t" + locationEntry.getValue() + "\n");
		
				if (location.endsWith("()")) { 
					List<String> ops = operations.get(concern);
					if (ops == null) {
						ops = new LinkedList<String>();
						operations.put(concern, ops);
					}
					if (!ops.contains(location))
						ops.add(location);
				}
				else { 
					List<String> comps = components.get(concern);
					if (comps == null) {
						comps = new LinkedList<String>();
						components.put(concern, comps);
					}
					if (!comps.contains(location))
						comps.add(location);
				}
			}
		}
		consoleStream.println(buffer.toString());
		
		// print metrics: concern diffusion over components and over operations
		buffer = new StringBuffer();
		
		// sort into buckets
		HashMap<Integer, Integer> componentBuckets = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> operationBuckets = new HashMap<Integer, Integer>();
		int maxNumberOfComponents = 0;
		int maxNumberOfOperations = 0;
		
		buffer.append("Concern diffusion over components.\n");
		for (Entry<String, List<String>> entry : components.entrySet()) {
			int numberOfComponents = entry.getValue().size();
			if (numberOfComponents > maxNumberOfComponents)
				maxNumberOfComponents = numberOfComponents;
			buffer.append(entry.getKey() + "\t" + numberOfComponents + "\t" + entry.getValue().toString() + "\n");
			Integer count = componentBuckets.get(numberOfComponents);
			componentBuckets.put(numberOfComponents, count == null ? 1 : count + 1);
		}
		buffer.append("\nConcern diffusion over operations.\n");
		for (Entry<String, List<String>> entry : operations.entrySet()) {
			int numberOfOperations = entry.getValue().size();
			if (numberOfOperations > maxNumberOfOperations)
				maxNumberOfOperations = numberOfOperations;
			buffer.append(entry.getKey() + "\t" + numberOfOperations + "\t" + entry.getValue().toString() + "\n");
			Integer count = operationBuckets.get(numberOfOperations);
			operationBuckets.put(numberOfOperations, count == null ? 1 : count + 1);
		}
		consoleStream.println(buffer.toString());
		
		// print distrubution over buckets
		StringBuffer bucketBuffer = new StringBuffer("Number of components\t");
		StringBuffer countBuffer = new StringBuffer("Number of concerns\t");
		StringBuffer percentageBuffer = new StringBuffer("Percentage of all\t");
		for (int i = 1; i <= maxNumberOfComponents; i++) {
			Integer count = componentBuckets.get(i);
			if (count == null)
				continue;
			bucketBuffer.append(i + "\t");
			countBuffer.append(count + "\t");
			percentageBuffer.append(count * 100 / numberOfConcerns + "%\t");
		}
		consoleStream.println("Distribution of " + numberOfConcerns + " concerns over components (CDC)");
		consoleStream.println(bucketBuffer.toString());
		consoleStream.println(countBuffer.toString());
		consoleStream.println(percentageBuffer.toString());
		
		bucketBuffer = new StringBuffer("Number of operations\t");
		countBuffer = new StringBuffer("Number of concerns\t");
		percentageBuffer = new StringBuffer("Percentage of all\t");
		for (int i = 1; i <= maxNumberOfOperations; i++) {
			Integer count = operationBuckets.get(i);
			if (count == null)
				continue;
			bucketBuffer.append(i + "\t");
			countBuffer.append(count + "\t");
			percentageBuffer.append(count * 100 / numberOfConcerns + "%\t");
		}
		consoleStream.println("Distribution of " + numberOfConcerns + " concerns over operations (CDO)");
		consoleStream.println(bucketBuffer.toString());
		consoleStream.println(countBuffer.toString());
		consoleStream.println(percentageBuffer.toString());
	}
	
	public void printEntries(HashMap<String, Integer> map) {
		StringBuffer buffer = new StringBuffer();
		if (map.size() > 0)
			buffer.append(": (" + map.size() + ")\n");
		for (Entry<String, Integer> entry : map.entrySet())
			buffer.append(entry.getKey() + "\t" + entry.getValue().toString() + "\n");

		consoleStream.println(buffer.toString());
	}
	public void printFeatureInstances() {
		if (!logFeatureInstances)
			return;
		
		consoleStream.print("\n" + (features.isEmpty() ? "No feature instances." : "Feature instances"));
		printEntries(features);
	}
	public void printMetamodelAnnotations() {
		if (!logMetamodelAnnotations)
			return;
		
		consoleStream.print("\nMetamodel annotations");
		printEntries(metamodelAnnotations);
	}
	public void printErrors() {
		if (!logErrors())
			return;
		
		consoleStream.print("\n" + (errors.isEmpty() ? "No errors." : "Errors"));
		printEntries(errors);
	}
	
	public void printImplVariants() {
		if (!logCodePatternVariants)
			return;
		
		consoleStream.print("\n" + (codePatternVariants.isEmpty() ? "No code pattern variants." : "Code pattern variants:\n"));
		
		StringBuffer buffer = new StringBuffer();
		for (Entry<String, HashMap<String, Integer>> entry: codePatternVariants.entrySet()) {
			buffer.append(entry.getKey()  + "\n");
			for (Entry<String, Integer>entry2:entry.getValue().entrySet()) {
				buffer.append("\t"+entry2.getKey() + "\t" + entry2.getValue().toString() + "\n");
					
			}
			
		}

		consoleStream.println(buffer.toString());
	}
	public void printCountedMessages() {
		if (!logMessages)
			return;
		
		consoleStream.print("\n" + (messages.isEmpty() ? "No messages." : "Messages"));
		printEntries(messages);
	}
	
	public void printBugs() {
		if (!logBugs)
			return;
		
		consoleStream.print("\n" + (bugs.isEmpty() ? "No bugs." : "Bugs"));
		printEntries(bugs);
	}
	
	public void printAll() {
		printMetamodelAnnotations();
		
		printFeatureInstances();
		
		printErrors();
		
		printImplVariants();
		
		printCountedMessages();
		
		printBugs();
		
		printScatteringAndTangling();
	}
	
}
