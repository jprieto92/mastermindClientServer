package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.WithConsoleView;

class ResultView extends WithConsoleView{
	
	private PlayController playController;
	
	ResultView(PlayController playController){
		this.playController = playController;
	}

	void writeln(int i) {
		this.console.writeln(MessageView.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.playController.getBlacks(i))
				.replaceFirst("#whites", "" + this.playController.getWhites(i)));
	}

}
