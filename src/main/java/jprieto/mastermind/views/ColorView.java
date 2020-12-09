package jprieto.mastermind.views;

import jprieto.mastermind.types.Color;
import jprieto.utils.ColorUtils;

class ColorView extends ColorUtils {

	public ColorView(Color color) {
		super(color);
	}
	
	@Override
	public void write() {
		this.console.write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
