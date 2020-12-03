package jprieto.mastermind.views.console;

import jprieto.mastermind.types.Color;

class ColorView extends jprieto.mastermind.views.ColorView {

	ColorView(Color color) {
		super(color);
	}
	
	void write() {
		this.console.write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
