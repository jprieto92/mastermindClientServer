package jprieto.mastermind.distributed.dispatchers.undoredo;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.distributed.dispatchers.Dispatcher;

public class UndoableDispatcher extends Dispatcher {

	public UndoableDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).undoable());
	}

}
