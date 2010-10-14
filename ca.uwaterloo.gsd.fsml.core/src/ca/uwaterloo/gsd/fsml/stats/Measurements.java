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
package ca.uwaterloo.gsd.fsml.stats;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to help measuring the execution of programs.
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class Measurements {

	protected static Map<String, Measurements> instances = null;
	
	private Measurements() {	
	}
	
	/**
	 * Gets the measurements instance for this unique key
	 * 
	 * It is recommended to use the class/method being measured as key.
	 * 
	 * @param key a unique key for a measurements instance
	 * @return the instance, creating if needed
	 */
	public static Measurements instance(String key) {
		if (instances == null) {
			instances = new HashMap<String, Measurements>();
		}
		if (! instances.containsKey(key)) {
			instances.put(key, new Measurements());
		}
		return instances.get(key);
	}
	
	protected long count = 0;
	protected long value = 0;
	protected long lastStart = 0;
	
	public void start() {
		lastStart = System.nanoTime();
	}
	
	public void stop() {
		if (lastStart != 0) {
			value += System.nanoTime() - lastStart;
			count++;
		}
		lastStart = 0;
	}
	
	public void reset() {
		count = 0;
		value = 0;
		lastStart = 0;
	}
	
	public void print(String text) {
		double v = (value / (double) 1000000);
		StringBuffer buf = new StringBuffer(text);
		buf.append(" count : ");
		buf.append(count);
		buf.append("; total time : ");
		buf.append(v);
		buf.append("ms; average : ");
		buf.append((v / (double) count) + "ms");
		Stats.INSTANCE.printMessage(buf.toString());
	}
	
	public void printAndReset(String text) {
		print(text);
		reset();
	}
}
