package jprieto.mastermind;

import jprieto.mastermind.controllers.AcceptorController;
import jprieto.mastermind.controllers.Logic;
import jprieto.mastermind.views.View;

public abstract class Mastermind {
	
	private Logic logic;
	private View view;
	
	protected Mastermind() {
		this.logic = this.createLogic();
		this.view = new View();
	}
	
	protected abstract Logic createLogic();

	protected void play() {
		AcceptorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				this.view.interact(controller);
			}
		} while (controller != null); 
	}
	
}

