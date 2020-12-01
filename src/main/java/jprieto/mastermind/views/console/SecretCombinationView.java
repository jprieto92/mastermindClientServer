package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.UseCaseController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.Console;

class SecretCombinationView {
	
	private UseCaseController controller;
	
	SecretCombinationView(UseCaseController controller) {
		super();
		this.controller = controller;
	}
	
	void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			Console.instance().write(MessageView.SECRET.getMessage());
		}
		Console.instance().writeln();
	}
	
}
