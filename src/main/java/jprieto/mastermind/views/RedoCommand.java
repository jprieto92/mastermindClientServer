package jprieto.mastermind.views;

import jprieto.mastermind.controllers.PlayController;

class RedoCommand extends Command {

  RedoCommand(PlayController playController) {
    super(MessageView.REDO_COMMAND.getMessage(), playController);
  }

  @Override
  protected void execute() {
    this.playController.redo();
  }

  @Override
  protected boolean isActive() {
    return this.playController.redoable();
  }

}
