package jprieto.mastermind.distributed.dispatchers;

import jprieto.mastermind.controllers.PlayController;

public class PlayWidthDispatcher extends Dispatcher {

    public PlayWidthDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController) this.acceptorController).getWidth());
	}
}