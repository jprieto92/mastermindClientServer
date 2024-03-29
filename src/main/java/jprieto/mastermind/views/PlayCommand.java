package jprieto.mastermind.views;

import java.util.List;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;

class PlayCommand extends Command {

  PlayCommand(PlayController playController) {
    super(MessageView.ACTION_COMMAND.getMessage(), playController);
  }

  @Override
  protected void execute() {
    this.addProposedCombination(playController);
  }

  private void addProposedCombination(PlayController playController) {
	  Error error;
	  List<Color> colors;
		do {
			colors = new ProposedCombinationView(playController).read();
			error = playController.getProposedCombinationError(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		playController.addProposedCombination(colors);
		this.console.writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}
		if (playController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (playController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
  }

  @Override
  protected boolean isActive() {
    return true;
  }

}
