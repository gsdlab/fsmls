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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class EcoreAttributeValueWithSuggestionWizard extends Wizard implements INewWizard {
	public static final String WIZARD_CANCELED = "WIZARDCANCELED";
	// workbench selection when the wizard was started
	protected EAttribute attribute;
	
	private String returnValue = null; 
	
	// the workbench instance
	protected IWorkbench workbench;
	
	protected EcoreAttributeValueWithSuggestionsPage ecoreFmpAttributeValueWithSuggestionsPage;
	
	public EcoreAttributeValueWithSuggestionWizard() {
		this.setWindowTitle("Please choose a value");
	}

	public void init(IWorkbench workbench) {
		this.workbench = workbench;
	}
	public boolean canFinish() {
		
		return ecoreFmpAttributeValueWithSuggestionsPage.canFinish;
	}

	public boolean performCancel() {
		returnValue = WIZARD_CANCELED;
		return true;
	}

	public boolean performFinish() {
		returnValue = ecoreFmpAttributeValueWithSuggestionsPage.featureGroupCombo.getText();
		return true;
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
//
//		return true;
	}
	
	

	public void addEcoreFmpTypeSelectionWizardPage(EcoreAttributeValueWithSuggestionsPage newPage){
		ecoreFmpAttributeValueWithSuggestionsPage = newPage;
		addPage(ecoreFmpAttributeValueWithSuggestionsPage);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		
	}

	public String getReturnValue() {
		return returnValue;
	}
	
}
