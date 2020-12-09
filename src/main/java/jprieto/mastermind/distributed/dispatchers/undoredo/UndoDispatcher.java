package jprieto.mastermind.distributed.dispatchers.undoredo;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.distributed.dispatchers.Dispatcher;

public class UndoDispatcher extends Dispatcher {

	public UndoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).undo();
	}

}
