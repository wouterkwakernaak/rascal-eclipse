package org.meta_environment.rascal.eclipse.console.internal;

import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.console.TextConsoleViewer;

public class InterpreterConsoleViewer extends TextConsoleViewer{
	private final InterpreterConsole console;
	private final CommandHistory history;

	public InterpreterConsoleViewer(InterpreterConsole console, Composite parent){
		super(parent, console);
		
		this.console = console;
		this.history = console.getHistory();
	}
	
	public StyledText createTextWidget(Composite parent, int styles){
		return new InterpreterConsoleStyledText(parent, styles);
	}

	private class InterpreterConsoleStyledText extends StyledText{

		public InterpreterConsoleStyledText(Composite parent, int style){
			super(parent, style);
		}

		public void invokeAction(int action){
			switch(action){
				case ST.LINE_UP:
					String previousCommand = history.getPreviousCommand();
					console.historyCommand(previousCommand);
					return;
				case ST.LINE_DOWN:
					String nextCommand = history.getNextCommand();
					console.historyCommand(nextCommand);
					return;
			}

			super.invokeAction(action);
		}
	}
}