package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.StartController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.Console;

class StartView {
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		startController.initGame();
		Console.instance().writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
