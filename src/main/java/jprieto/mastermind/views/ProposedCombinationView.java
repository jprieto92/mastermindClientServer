package jprieto.mastermind.views;

import java.util.ArrayList;
import java.util.List;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.types.Color;
import jprieto.utils.WithConsoleView;

class ProposedCombinationView extends WithConsoleView{
	
	private PlayController playController;
	
	ProposedCombinationView(PlayController playController) {
		this.playController = playController;
	}
	
	void write(int position) {
		for (Color color : this.playController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			Color color = ColorView.getInstance(characters.charAt(i));
			if(null == color)
			{
				color = ColorView.getNullInstance();
			}
			colors.add(color);
		}
		return colors;
	}
	
}
