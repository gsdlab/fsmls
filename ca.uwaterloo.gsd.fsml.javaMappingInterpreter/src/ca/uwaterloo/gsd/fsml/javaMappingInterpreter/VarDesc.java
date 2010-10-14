/*******************************************************************************
 * Copyright (c) 2010 Thiago Tonelli Bartolomei.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Thiago Tonelli Bartolomei - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Type;

 public class VarDesc {
	public static final int LOCAL=0;
	public static final int MEMBER=1; 
	public static final int STATIC=2;
	public static final int SPECIAL=3;
	
	public final Type type;
	public final ITypeBinding typeBind;
	public final int dims;
	public final String name;
	public final int kind;
	public VarDesc(ITypeBinding type) {
		this.type=null;
		this.typeBind=type;
		this.dims=0;
		this.name=null;
		this.kind=SPECIAL;
	}
	public VarDesc(Type type, int dims, int kind, String name) {
		this.type=type;
		this.typeBind=null;
		this.dims=dims;
		this.name=name;
		this.kind=kind;
	}
	public String toString() {
		StringBuilder buf=new StringBuilder();
		buf.append(type);
		buf.append(" ");
		buf.append(name);
		return buf.toString();
	}
}
