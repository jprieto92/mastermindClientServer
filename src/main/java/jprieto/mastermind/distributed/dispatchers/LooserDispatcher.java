package jprieto.mastermind.distributed.dispatchers;

import jprieto.mastermind.controllers.PlayController;

public class LooserDispatcher extends Dispatcher {

    public LooserDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).isLooser());
	}
    
}