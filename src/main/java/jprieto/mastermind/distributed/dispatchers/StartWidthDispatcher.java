package jprieto.mastermind.distributed.dispatchers;

import jprieto.mastermind.controllers.StartController;

public class StartWidthDispatcher extends Dispatcher {

    public StartWidthDispatcher(StartController startController) {
		super(startController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((StartController) this.acceptorController).getWidth());
	}
}