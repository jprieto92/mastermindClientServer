package jprieto.mastermind.distributed.dispatchers;

import jprieto.mastermind.controllers.ResumeController;

public class ResumeDispatcher extends Dispatcher {

    public ResumeDispatcher(ResumeController resumeController) {
		super(resumeController);
	}

	@Override
	public void dispatch() {
		boolean newGame = this.tcpip.receiveBoolean();
		((ResumeController)this.acceptorController).resume(newGame);	
	}
}