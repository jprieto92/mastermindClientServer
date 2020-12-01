package jprieto.mastermind;

import jprieto.mastermind.views.View;
import jprieto.mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	protected View createView() {
		return new ConsoleView();
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
}
