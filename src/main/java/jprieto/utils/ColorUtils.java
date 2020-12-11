package jprieto.utils;

import jprieto.mastermind.types.Color;

public abstract class ColorUtils extends WithConsoleView {

	public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p', 'n'};

	protected Color color;

	public ColorUtils(Color color) {
		this.color = color;
	}

	public static String allInitials() {
		String result = "";
		for(char character: ColorUtils.INITIALS) {
			if(character != 'n')
				result += character;
		}
		return result;
	}
	
	public char getInitial() {
		return ColorUtils.INITIALS[this.color.ordinal()];
	}

	public static Color getInstance(char character) {
		for (int i = 0; i < ColorUtils.INITIALS.length; i++) {
			if (ColorUtils.INITIALS[i] == character) {
				return Color.values()[i];
			}
		}
		return null;
	}
	
	public static Color getNullInstance()
	{
		return Color.NULL;
	}
	
	public abstract void write();

}
