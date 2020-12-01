package jprieto.mastermind.views;

import jprieto.utils.Console;

public enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	ACTION_COMMAND("Do a action"), 
	UNDO_COMMAND("Undo previous action"), 
	REDO_COMMAND("Redo previous action"),
	LOOSER("You've lost!!! :-(");

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void write() {
		Console.instance().write(this.message);
	}

	public void writeln() {
		Console.instance().writeln(this.message);
	}

}
