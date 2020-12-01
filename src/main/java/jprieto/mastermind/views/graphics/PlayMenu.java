package jprieto.mastermind.views.graphics;

import jprieto.mastermind.controllers.PlayController;
import jprieto.utils.Menu;

public class PlayMenu extends Menu {

  PlayMenu(PlayController playController) {
    this.addCommand(new PlayCommand(playController));
    this.addCommand(new UndoCommand(playController));
    this.addCommand(new RedoCommand(playController));
  }

}
