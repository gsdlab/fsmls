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
package test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;
public class TestApplet extends JApplet implements MouseListener, Runnable, KeyListener, MouseMotionListener {

	public MouseListener mouseListenerField = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	};
	public Thread thread1Helper;
	public Thread thread2Variable;
	public Thread thread3This;
	public Thread thread4Field;
	public CustomThread thread5Subclass = new CustomThread();
	
	public Runnable thread4runnableField = new Runnable() {
		public void run() {
		}
	};
	private KeyListener keyListenerField = new KeyListener() {
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {
		}
		public void keyTyped(KeyEvent e) {
		}
	};
	private MouseMotionListener mouseMotionListenerField = new MouseMotionListener() {
		public void mouseDragged(MouseEvent e) {
		}
		public void mouseMoved(MouseEvent e) {
		}
	};

	public void init() {
		showStatus("initializing...");
		addMouseListener(this);
		addMouseListener(mouseListenerField);
		thread1Helper = new Thread(new Runnable() {
			public void run() {
			}
		});
		Runnable thread2runnableVariable = new Runnable() {
			public void run() {
			}
		};
		thread2Variable = new Thread(thread2runnableVariable);
		thread3This = new Thread(this);
		thread4Field = new Thread(thread4runnableField);
		getParameter("WIDTH");
		
		addKeyListener(this);
		addMouseMotionListener(this);
		
		addKeyListener(keyListenerField);
		addMouseMotionListener(mouseMotionListenerField);
		
		new Thread(new Runnable() {
			public void run() {
				// do the one-time task
			}
		});
	}

	public void destroy() {
		removeMouseListener(this);
		removeMouseListener(mouseListenerField);
		thread1Helper = null;
		thread2Variable = null;
		thread3This = null;
		thread4Field = null;
		removeKeyListener(this);
		removeMouseMotionListener(this);
		removeKeyListener(keyListenerField);
		removeMouseMotionListener(mouseMotionListenerField);
	}

	public String[][] getParameterInfo() {
		return null;
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void run() {
	}

	public void start() {
	}

	public void paint(Graphics graphics) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	class CustomThread extends Thread {
		public void run() {
			super.run();
		}
	}
}
