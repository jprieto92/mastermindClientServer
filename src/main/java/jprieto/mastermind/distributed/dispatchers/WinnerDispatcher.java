package jprieto.mastermind.distributed.dispatchers;

import jprieto.mastermind.controllers.PlayController;

public class WinnerDispatcher extends Dispatcher {

    public WinnerDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).isWinner());
	}
    
}