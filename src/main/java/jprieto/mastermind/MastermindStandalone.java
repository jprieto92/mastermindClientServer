package jprieto.mastermind;

import jprieto.mastermind.controllers.implementation.LogicImplementation;

public class MastermindStandalone extends Mastermind{
	
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

	@Override
	protected LogicImplementation createLogic() {
		return new LogicImplementation();
	}
}
