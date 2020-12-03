package jprieto.mastermind.views;

import jprieto.mastermind.types.Error;
import jprieto.utils.WithConsoleView;

class ErrorView extends WithConsoleView {

	public static final String[] MESSAGES = { 
			"Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), 
			"Wrong proposed combination length" };

	protected Error error;

	public ErrorView(Error error) {
		this.error = error;
	}
	
	public String getMessage() {
		return ErrorView.MESSAGES[this.error.ordinal()];
	}
	
	void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
