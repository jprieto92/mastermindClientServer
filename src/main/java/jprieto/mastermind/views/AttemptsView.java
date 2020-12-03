package jprieto.mastermind.views;

import jprieto.mastermind.controllers.PlayController;
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
