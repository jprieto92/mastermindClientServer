package jprieto.mastermind;

import jprieto.mastermind.controllers.Logic;
//import jprieto.tictactoe.controllers.implementation.LogicImplementation;

public class MastermindStandalone extends Mastermind{
	
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

	@Override
	protected Logic createLogic() {
		return new Logic();
	}
}
