package org.rascalmpl.eclipse.perspective.actions.highlight;

import org.eclipse.imp.editor.UniversalEditor;

public class ShowAsHTML extends HighlightAction {

	public ShowAsHTML(UniversalEditor editor) {
		super(editor, "Show as HTML", "lang::box::util::HighlightToHTML", "highlight2html", "html");
	}

}
