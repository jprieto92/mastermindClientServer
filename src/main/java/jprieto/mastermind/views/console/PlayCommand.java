package jprieto.mastermind.views.console;

import java.util.List;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;
import jprieto.mastermind.views.MessageView;

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
		do {
			List<Color> colors = new ProposedCombinationView(playController).read();
			error = playController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
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
