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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.refactoring.CompilationUnitChange;
import org.eclipse.jdt.internal.core.dom.rewrite.TrackedNodePosition;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IRewriteTarget;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.IUndoManager;
import org.eclipse.ltk.core.refactoring.RefactoringCore;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.TextEditGroup;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaASTManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * A Manager for Java ASTs that were parsed during analysis.
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class JavaASTManager implements IJavaASTManager {
	/**
	 * maps original type roots (not working copies!) to their parse trees
	 */
	protected HashMap<ITypeRoot, CompilationUnit> iTypeRoot2CompilationUnit = new HashMap<ITypeRoot, CompilationUnit>();
	protected ASTParser parser = null;
	protected IJavaProject project = null;
	private IProgressMonitor progressMonitor;
	
	/**
	 * Creates a new cache for this java project
	 * 
	 * @param project the java project
	 */
	public JavaASTManager(IJavaProject project) {
		this.project = project;
		this.progressMonitor = new NullProgressMonitor();
	}
	/**
	 * Gets the parser, creating it if needed.
	 * 
	 * @return the AST parser
	 */
	protected ASTParser getParser() {
		if (parser == null) {
			parser = ASTParser.newParser(AST.JLS3);
			parser.setProject(project);
		}
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		return parser;
	}
	
	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init() {
	}
	
	/**
	 * Clears the whole cache
	 */
	@Override
	public void finish() {
		// need to discard or commit all acquired working copies
		for (Entry<ITypeRoot, CompilationUnit> entry : iTypeRoot2CompilationUnit.entrySet()) {
			ITypeRoot iTypeRoot = entry.getKey();
			CompilationUnit compilationUnit = entry.getValue();
			ICompilationUnit workingCopy = null;
			IRewriteTarget rewriteTarget= null;
			TextChange change=null;
			try {
				// need to apply the changes and commit the working copy
				if (!iTypeRoot.isReadOnly()) {
					try {
						String source = iTypeRoot.getBuffer().getContents();
						Document document = new Document(source);
						
						// computation of the text edits
						TextEdit edits = compilationUnit.rewrite(document, project.getOptions(true));
						
						

						workingCopy = iTypeRoot.getWorkingCopy(JavaMappingInterpreter.primaryWorkingCopyOwner, progressMonitor);
						
							
						IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
						//new code to accomodate the recommender system so the entire file doesn't get refreshed
						if (activeWorkbenchWindow!=null && activeWorkbenchWindow.getActivePage().getActiveEditor()!=null){
							IEditorPart activeEditor = activeWorkbenchWindow.getActivePage().getActiveEditor();
							CompilationUnitChange cuChange = new CompilationUnitChange("FSMLEdit", workingCopy);
							cuChange.setSaveMode(TextFileChange.LEAVE_DIRTY);
							change= cuChange;
							change.setEdit(edits);
							rewriteTarget= (IRewriteTarget) activeEditor.getAdapter(IRewriteTarget.class);
							if (rewriteTarget != null) {
								rewriteTarget.beginCompoundChange();
							}
							change.initializeValidationData(new NullProgressMonitor());
							RefactoringStatus valid;
							try {
								valid = change.isValid(new NullProgressMonitor());
								if (valid.hasFatalError()) {
									IStatus status= new Status(IStatus.ERROR, JavaPlugin.getPluginId(), IStatus.ERROR,
										valid.getMessageMatchingSeverity(RefactoringStatus.FATAL), null);
									throw new CoreException(status);
								} else {
									IUndoManager manager= RefactoringCore.getUndoManager();
									manager.aboutToPerformChange(change);
									Change undoChange= change.perform(new NullProgressMonitor());
									manager.changePerformed(change, true);
									if (undoChange != null) {
										undoChange.initializeValidationData(new NullProgressMonitor());
										manager.addUndo("FSMLEdit", undoChange);
									}
								}
							} catch (OperationCanceledException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (CoreException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} finally{
								
							}
							
							if (CodeTransforms.currentProposal!=null){
								
								TrackedNodePosition nodePosition=null;
					
								if (edits instanceof MultiTextEdit){
									TextEdit[] children = edits.getChildren();
									
									 int count = 0;
									for (int i=0;i<children.length;i++){
										if (!(children[i] instanceof InsertEdit)){
											continue;
										} else {
											if (((InsertEdit)children[i]).getText().trim().replaceAll("\n|\t","").length()==0){
												continue;
											}
										}
										TextEdit.getCoverage(new TextEdit[]{children[i]});
										TextEditGroup textEditGroup = new  TextEditGroup("FSMLEditGroup",children[i]);
										nodePosition = new TrackedNodePosition(textEditGroup,null);
										if (count==0){
											CodeTransforms.currentProposal.addLinkedPosition(nodePosition, true, "FSMLProposalLinkedPosition"+count);
										} else {
											CodeTransforms.currentProposal.addLinkedPosition(nodePosition, false, "FSMLProposalLinkedPosition"+count);
										}
										count++;
									}
								} else {
									TextEditGroup textEditGroup = new  TextEditGroup("FSMLEditGroup",edits);
									nodePosition = new TrackedNodePosition(textEditGroup,null);
									CodeTransforms.currentProposal.addLinkedPosition(nodePosition, true, "FSMLProposalLinkedPosition");
									
								}
								CodeTransforms.currentProposal=null;
							}
						} else {
							// computation of the new source code
							edits.apply(document);

							String newSource = document.get();
							
							// update of the compilation unit
							workingCopy.getBuffer().setContents(newSource);
							workingCopy.commitWorkingCopy(true, null);
						}
					} catch (MalformedTreeException e) {
						// still need to discard
						e.printStackTrace();
					} catch (BadLocationException e) {
						// still need to discard
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// thrown by rewrite is recording of modifications was not turned on. Can safely discard
					} catch (JavaModelException e) {
						e.printStackTrace();
					}
				}
			} finally {
				try {
					if (workingCopy != null) {
						workingCopy.discardWorkingCopy();
						//entry.setValue(workingCopy.reconcile(AST.JLS3, false, null, progressMonitor));
					}
				} catch (JavaModelException e1) {
					e1.printStackTrace();
				}
				if (rewriteTarget != null) {
					rewriteTarget.endCompoundChange();
				}
				if (change != null) {
					change.dispose();
				}
			}
		}
		/*cache.clear();
		acquiredWorkingCopies.clear();*/
	}

	/**
	 * Gets the compilation unit for this java element. If not in cache, this method will parse
	 * the AST and put it in the cache.
	 * 
	 * @param iJavaElement the java element
	 * @return the compilation unit
	 */
	@Override
	public CompilationUnit getCompilationUnit(IJavaElement iJavaElement) {
		ITypeRoot iTypeRoot = JavaModelUtils.getTypeRoot(iJavaElement);
		return iTypeRoot != null ? getCompilationUnit(iTypeRoot) : null;
	}
	
	/**
	 * Gets a compilation unit that was parsed for this type root (a class file or a compilation unit
	 * from java model). If it was not parsed, it will parse.
	 * 
	 * @param iTypeRoot the key (a type root)
	 * @return the compilation unit, or null
	 */
	@Override
	public CompilationUnit getCompilationUnit(ITypeRoot iTypeRoot) {
		try {
			if (! iTypeRoot2CompilationUnit.containsKey(iTypeRoot)) {
				parseTypeRoot(iTypeRoot);
			}
			return iTypeRoot2CompilationUnit.get(iTypeRoot);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parses the element (or re-parses if it already was parsed) and returns the compilation unit 
	 * resulting from it. This method will cache the results. 
	 * 
	 * @param iTypeRoot the java element to be parsed
	 * @return the compilation unit
	 * @throws JavaModelException 
	 */
	@Override
	public CompilationUnit parseTypeRoot(ITypeRoot iTypeRoot) throws JavaModelException {
		
		if (iTypeRoot == null) return null;
		
		if (!iTypeRoot.isStructureKnown() || iTypeRoot.getSource() == null) {
			Stats.INSTANCE.logError("parseTypeRoot: there is no source for binary file " + iTypeRoot.getElementName());
			return null;
		}
		getParser().setSource(iTypeRoot);
		CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(progressMonitor);
		iTypeRoot2CompilationUnit.put(iTypeRoot, compilationUnit);
		
		
		boolean titleShown = false;
		// log "unresolved name" problems
		for(IProblem p : compilationUnit.getProblems()) {
			if ((p.getID() & IProblem.IgnoreCategoriesMask) == 50 ||
				(p.getID() & IProblem.IgnoreCategoriesMask) == 324) {
				if (! titleShown) {
					titleShown = true;
					Stats.INSTANCE.printMessage("Compilation Error(s) for : " + iTypeRoot.getElementName() + " might cause resolution problems:"); 		
				}
				Stats.INSTANCE.printMessage("  " + p);
			}
		}
		
		return compilationUnit;
	}
	/**
	 * Parses the type root referent to the element (or re-parses if it already was parsed) and 
	 * returns the compilation unit resulting from it. This method will cache the results. 
	 * 
	 * @param element the java element to be parsed
	 * @return the compilation unit
	 * @throws JavaModelException 
	 */
	@Override
	public CompilationUnit parseTypeRoot(IJavaElement element) throws JavaModelException {
		return parseTypeRoot(JavaModelUtils.getTypeRoot(element));
	}

	/**
	 * Caches the compilation unit for this type root.
	 *  
	 * @param root the type root
	 * @param unit the compilation unit
	 */
	@Override
	public void setCompilationUnit(ITypeRoot root, CompilationUnit unit) {
		iTypeRoot2CompilationUnit.put(root, unit);
	}

}
