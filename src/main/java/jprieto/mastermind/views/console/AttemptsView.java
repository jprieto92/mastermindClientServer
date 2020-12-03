package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView{

	private PlayController playController;

	AttemptsView(PlayController playController) {
		this.playController = playController;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.playController.getAttempts()));
	}

}
