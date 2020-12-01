package jprieto.mastermind.views.console;

import jprieto.mastermind.types.Color;
import jprieto.utils.Console;

class ColorView extends jprieto.mastermind.views.ColorView {

	ColorView(Color color) {
		super(color);
	}
	
	void write() {
		Console.instance().write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
