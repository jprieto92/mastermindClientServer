package jprieto.mastermind.views.console;

import jprieto.mastermind.types.Error;
import jprieto.utils.Console;

class ErrorView extends jprieto.mastermind.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		Console.instance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
