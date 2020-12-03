package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.UseCaseController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView{
	
	private UseCaseController controller;
	
	SecretCombinationView(UseCaseController controller) {
		super();
		this.controller = controller;
	}
	
	void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
