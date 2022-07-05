/*
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.ui.quickfix;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.xtext.test.minijava.validation.MinijavaValidator;

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
public class MinijavaQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(MinijavaValidator.INVALID_NAME)
	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
			}
		});
	}
	@Fix(MinijavaValidator.DUPLICATE_NAMES)
	 public void newName(final Issue issue, IssueResolutionAcceptor acceptor) {
	  acceptor.accept(issue, "Change name", "Change the name.", "upcase.png", new IModification() {
	   public void apply(IModificationContext context) throws BadLocationException {
	    IXtextDocument xtextDocument = context.getXtextDocument();
	    xtextDocument.replace(issue.getOffset(),issue.getLength(), xtextDocument.get(issue.getOffset(),issue.getLength()) + "New");
	   }
	  });
	 }
	 
	 @Fix(MinijavaValidator.NO_RETURN)
	 public void addReturn(final Issue issue, IssueResolutionAcceptor acceptor) {
	  acceptor.accept(issue, "Add return", "Add return.", "upcase.png", new IModification() {
	   public void apply(IModificationContext context) throws BadLocationException {
	    IXtextDocument xtextDocument = context.getXtextDocument();
	    int location = xtextDocument.get().lastIndexOf(';');
	    xtextDocument.replace(location, 1, ";\n\treturn ;");
	   }
	  });
	 }

}
