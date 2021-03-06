package org.rascalmpl.eclipse.perspective.actions;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.rascalmpl.eclipse.editor.ParseController;
import org.rascalmpl.eclipse.library.util.ValueUI;
import org.rascalmpl.values.ValueFactoryFactory;

public class BrowseTree extends AbstractEditorAction {

	public BrowseTree(UniversalEditor editor) {
		super(editor, "Browse parse tree");
	}
	
	@Override
	public void run() {
		IConstructor tree = (IConstructor) ((ParseController) editor.getParseController()).getCurrentAst();

		if (tree != null) {
			IValueFactory valueFactory = ValueFactoryFactory.getValueFactory();
			new ValueUI(valueFactory).tree(tree);
		}
	}
}
