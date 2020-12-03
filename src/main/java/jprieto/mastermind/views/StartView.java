package jprieto.mastermind.views;

import jprieto.mastermind.controllers.StartController;
import jprieto.utils.WithConsoleView;

class StartView extends WithConsoleView{
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		startController.initGame();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
