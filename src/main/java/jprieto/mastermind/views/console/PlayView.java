package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.PlayController;

class PlayView {

    void interact(PlayController playController) {
        new PlayMenu(playController).execute();
    }
}