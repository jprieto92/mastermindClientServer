package jprieto.mastermind.distributed.dispatchers.undoredo;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.distributed.dispatchers.Dispatcher;

public class RedoDispatcher extends Dispatcher {

	public RedoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).redo();
	}

}
