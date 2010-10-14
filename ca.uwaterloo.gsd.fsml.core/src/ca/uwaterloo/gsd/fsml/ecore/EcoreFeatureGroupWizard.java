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
package ca.uwaterloo.gsd.fsml.ecore;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class EcoreFeatureGroupWizard extends Wizard implements INewWizard {
	public static final String WIZARD_CANCELED = "WIZARDCANCELED";
	// workbench selection when the wizard was started

	
	private Object returnValue = null; 
	
	// the workbench instance
	protected IWorkbench workbench;
	
	protected EcoreFeatureGroupPage ecoreFmpFeatureGroupPage;
	
	public EcoreFeatureGroupWizard() {
		this.setWindowTitle("Ecore Fmp Attribute Value");
	}

	public void init(IWorkbench workbench) {
		this.workbench = workbench;
	
	}
	public boolean canFinish() {
		
		return ecoreFmpFeatureGroupPage.canFinish;
	}

	public boolean performCancel() {
		returnValue = WIZARD_CANCELED;
		return true;
	}

	public boolean performFinish() {
		returnValue = ecoreFmpFeatureGroupPage.featureGroupCombo.getText();
//		try{
//			returnValue = this.determineReturnValueFromWizard(attribute.getEType().getInstanceClassName());
//		}
//		catch (NumberFormatException e){
//			ecoreFmpAttributeValuePage.setErrorMessage("There was a number format exception. Please enter a correct value.");
//			return false; 
//		}
//		catch (Exception e){
//			if (ecoreFmpAttributeValuePage.classConstructor == null){
//				ecoreFmpAttributeValuePage.setErrorMessage("This attribute can not be constructed since it has no primitive constructor");
//			}
//			else{
//				ecoreFmpAttributeValuePage.setErrorMessage("There was a problem during attribute instantiation. Please cancel and try again.");
//			}
//			return false; 			
//		}

		return true;
	}
	
//	private Object determineReturnValueFromWizard(String instanceTypeString) throws NumberFormatException,Exception {
//		try{
//			if (attribute.getEType().getInstanceClass().isPrimitive() || attribute.getEType().getInstanceClass().equals(String.class)){
//				if (attribute.getEType().getInstanceClassName().equals("boolean")){
//					return this.getObjectFromClassStringAndValueString(attribute.getEType().getInstanceClassName(), ecoreFmpAttributeValuePage.booleanCombo.getText());
//				}
//				else{
//					return this.getObjectFromClassStringAndValueString(attribute.getEType().getInstanceClassName(), ecoreFmpAttributeValuePage.valueText.getText());
//				}
//			}
//			else{
//				//otherwise its a non primitive
//				ArrayList<Text> paramValues = ecoreFmpAttributeValuePage.constructorParameters;
//				Object[] paramObjects = new Object[paramValues.size()];
//				Constructor returnValueConstructor = ecoreFmpAttributeValuePage.classConstructor;
//				for (int paramIndex = 0; paramIndex < paramValues.size();paramIndex++){
//					paramObjects[paramIndex] = this.getObjectFromClassStringAndValueString(returnValueConstructor.getParameterTypes()[paramIndex].getName(),paramValues.get(paramIndex).getText());
//				}
//				if (returnValueConstructor != null){
//					return returnValueConstructor.newInstance(paramObjects);
//				}
//				else{
//					throw new Exception("No Primitive Constructors found.");
//				}
//			}
//		}
//		catch (NumberFormatException e){
//			throw e;
//		}
//		catch (InvocationTargetException e){
//			if (e.getTargetException() instanceof NumberFormatException){
//				throw (NumberFormatException)e.getTargetException(); 
//			}
//			throw e;
//		}
//		catch (Exception e){
//			throw e; 
//		}
//	}

	private Object getObjectFromClassStringAndValueString(String className, String stringTextToInterpret) {
		try{
			if (className.equals("char")){
				return Character.valueOf(stringTextToInterpret.charAt(0));
			}
			else if (className.equals("boolean")){
				return Boolean.valueOf(stringTextToInterpret);
			}
			else if (className.equals("int")){
				return Integer.valueOf(stringTextToInterpret);
			}
			else if (className.equals("byte")){
				return Byte.valueOf(stringTextToInterpret);
			}
			else if (className.equals("short")){
				return Short.valueOf(stringTextToInterpret);
			}
			else if (className.equals("long")){
				return Long.valueOf(stringTextToInterpret);
			}
			else if (className.equals("float")){
				return Float.valueOf(stringTextToInterpret);
			}
			else if (className.equals("double")){
				return Double.valueOf(stringTextToInterpret);
			}
			else {
				return stringTextToInterpret;
			}
		}
		catch (NumberFormatException e){
			throw e;
		}
		
	}

	public void addEcoreFmpTypeSelectionWizardPage(EcoreFeatureGroupPage newPage){
		ecoreFmpFeatureGroupPage = newPage;
		addPage(ecoreFmpFeatureGroupPage);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		
	}

	public Object getReturnValue() {
		return returnValue;
	}
	
}
