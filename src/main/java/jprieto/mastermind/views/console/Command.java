package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.PlayController;

abstract class Command extends jprieto.utils.Command {

  protected PlayController playController;

  protected Command(String title, PlayController playController) {
    super(title);
    this.playController = playController;
  }

}
