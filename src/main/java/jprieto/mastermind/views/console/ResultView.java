package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.Console;

class ResultView {
	
	private PlayController playController;
	
	ResultView(PlayController playController){
		this.playController = playController;
	}

	void writeln(int i) {
		Console.instance().writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.playController.getBlacks(i))
				.replaceFirst("#whites", "" + this.playController.getWhites(i)));
	}

}
