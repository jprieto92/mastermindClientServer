package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.Console;

public class AttemptsView {

	private PlayController playController;

	AttemptsView(PlayController playController) {
		this.playController = playController;
	}

	void writeln() {
		Console.instance().writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.playController.getAttempts()));
	}

}
