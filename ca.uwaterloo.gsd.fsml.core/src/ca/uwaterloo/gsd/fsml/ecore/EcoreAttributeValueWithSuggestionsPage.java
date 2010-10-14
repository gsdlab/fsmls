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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class EcoreAttributeValueWithSuggestionsPage extends WizardPage implements Listener {
	
	

	
	
	private Collection<EAttribute> eAttributes;
	private Collection<EObject> eObjects;
	public boolean canFinish = true;
	protected Combo featureGroupCombo;



	public EcoreAttributeValueWithSuggestionsPage(String pageName,Collection<EObject> eObjets, Collection<EAttribute> eAttributes) {
		super(pageName);
		this.eObjects = eObjets;
		this.eAttributes = eAttributes;
	}

    protected ImageDescriptor getImageDescriptor(String relativePath) {
    	return AbstractUIPlugin.imageDescriptorFromPlugin("ca.uwaterloo.gsd.ecore.fmp", "icons/full/" + relativePath);
    }
	
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		//this.getWizard().
		
	}

	public void createControl(Composite parent) {
		RowLayout rl = new RowLayout(SWT.VERTICAL);
		rl.fill = true;
		
		parent.setLayout(rl);
		featureGroupCombo = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
		featureGroupCombo.add("new value");
		featureGroupCombo.add("-------------");
	    Iterator<EObject> eObjectsIterator = eObjects.iterator();
	    Iterator<EAttribute> eAttributesIterator = eAttributes.iterator();
		while (eObjectsIterator.hasNext()&&eAttributesIterator.hasNext()){
			Object value= eObjectsIterator.next().eGet(eAttributesIterator.next());
			if (value!=null){
				featureGroupCombo.add(value.toString());
			}
		}
		setControl(parent);		
	}

   
}
