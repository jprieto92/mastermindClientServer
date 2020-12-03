package jprieto.mastermind.views;

import jprieto.mastermind.controllers.Controller;


import jprieto.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView{
	
	private Controller controller;
	
	SecretCombinationView(Controller controller) {
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
