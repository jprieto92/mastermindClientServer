package jprieto.mastermind;

import jprieto.mastermind.views.View;
import jprieto.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind{

	protected View createView() {
		return new GraphicsView();
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
