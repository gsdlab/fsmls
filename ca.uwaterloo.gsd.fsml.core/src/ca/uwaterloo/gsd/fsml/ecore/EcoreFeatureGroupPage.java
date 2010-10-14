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

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class EcoreFeatureGroupPage extends WizardPage implements
		Listener {
	
	

	protected Text valueText;
	protected Object returnObject;
	protected Combo featureGroupCombo; 
	protected Constructor classConstructor = null;
	protected ArrayList<Text> constructorParameters = new ArrayList<Text>(); 
	public boolean canFinish = true;
	private EList<EStructuralFeature> structuralFeatures; 
	
	public EcoreFeatureGroupPage(String pageName,EList<EStructuralFeature> structuralFeatures) {
		super(pageName);
		this.structuralFeatures = structuralFeatures;
		this.setTitle("Make a Selection");
		this.setMessage("Select a value for the new Attribute.");
		this.setImageDescriptor(getImageDescriptor("wizban/NewFmp.gif"));
		this.structuralFeatures = structuralFeatures;
	}

    protected ImageDescriptor getImageDescriptor(String relativePath) {
    	return AbstractUIPlugin.imageDescriptorFromPlugin("ca.uwaterloo.gsd.ecore.fmp", "icons/full/" + relativePath);
    }
	
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		//this.getWizard().
		
	}

	public void createControl(Composite parent) {
		Composite composite =  new Composite(parent, SWT.NULL);
		addPropertyWizardPageToComposite(composite);
		setControl(composite);			
	}

    private void addPropertyWizardPageToComposite(Composite composite) {
		RowLayout rl = new RowLayout(SWT.VERTICAL);
		rl.fill = true;
		
		composite.setLayout(rl);
		
		
		
//		if (attribute.getEType().getInstanceClassName().equals("char")||attribute.getEType().getInstanceClassName().equals("byte")||
//				isAttributeANumericPrimitive(attribute.getEType().getInstanceClassName()) || attribute.getEType().getInstanceClass().equals(String.class)){
//			new Label (composite, SWT.NONE).setText("Enter a value for " + attribute.getEContainingClass().getName()+"'s "+attribute.getName()+" ("+attribute.getEType().getInstanceClassName() + ") attribute.");
//			valueText=new Text(composite,SWT.BORDER);
//			if (attribute.getEType().getInstanceClassName().equals("char")){			
//				valueText.setTextLimit(1);
//			}
//		}
//		else if (attribute.getEType().getInstanceClassName().equals("boolean")){
			new Label (composite, SWT.NONE).setText("Make a selection");
		    featureGroupCombo = new Combo(composite, SWT.BORDER | SWT.READ_ONLY);
		    for (EStructuralFeature structuralFeature : structuralFeatures) {
			    featureGroupCombo.add(structuralFeature.getName());
				
			}
//		}
//    	else{
//    		new Label (composite, SWT.NONE).setText("Fill in the constructor parameters for the " + attribute.getEContainingClass().getName()+"'s "+attribute.getName()+" ("+attribute.getEType().getInstanceClassName() + ") attribute.");
//    		Class attributeClass = attribute.getEType().getInstanceClass();
//    		if (attributeClass.getConstructors().length != 0){
//    			
//    			//first loop through and check for 1 primitive constructor. 
//    			for (Constructor currentConstructor : attributeClass.getConstructors()) {
//    				if (currentConstructor.getParameterTypes().length == 1 && (currentConstructor.getParameterTypes()[0].isPrimitive()||currentConstructor.getParameterTypes()[0].equals(String.class))){
//    					//if the single param is a primitive or a string then we have it. 
//    					classConstructor = currentConstructor;
//    					break;
//    				}
//    			}
//    			if (classConstructor == null){
//    				//otherwise serach for next simplist. 
//    				for (Constructor currentConstructor : attributeClass.getConstructors()) {
//    					boolean isConstructorPrimitive = true;
//    					for (Class paramType : currentConstructor.getParameterTypes()) {
//    						if (!paramType.isPrimitive()&& !paramType.equals(String.class)){
//    							isConstructorPrimitive = false;
//    							break;
//    						}
//    					}
//    					if (isConstructorPrimitive == true){
//    						classConstructor = currentConstructor;
//    						break;
//    					}
//    				}
//    			}
//    			if (classConstructor == null){
//    				return;
//    			}
//    			for (Class paramType : classConstructor.getParameterTypes()) {
//					if (paramType.isPrimitive() || paramType.equals(String.class)){
//						new Label (composite,SWT.NONE).setText("Enter a value for the " +paramType.getName()+" ("+ paramType.getSimpleName() + ") type constructor parameter." );
//						constructorParameters.add(new Text (composite,SWT.BORDER));
//					}
//				}
//    		}
//    	}
	}




	private boolean isAttributeANumericPrimitive(String instanceClassName) {
		return instanceClassName.equals("int")||instanceClassName.equals("long")||instanceClassName.equals("double")||instanceClassName.equals("float")||instanceClassName.equals("short"); 
	}
	
}
