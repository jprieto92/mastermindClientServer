package jprieto.mastermind.views.graphics;

import java.util.List;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.Console;

class PlayCommand extends Command {

  PlayCommand(PlayController playController) {
    super(MessageView.ACTION_COMMAND.getMessage(), playController);
  }

  @Override
  protected void execute() {
    this.addProposedCombination(playController);
  }

  private void addProposedCombination(PlayController playController) {
	  
  }

  @Override
  protected boolean isActive() {
    return true;
  }

}
