package jprieto.mastermind.distributed;

import jprieto.mastermind.controllers.ResumeController;
import jprieto.mastermind.distributed.dispatchers.FrameType;
import jprieto.mastermind.models.Session;
import jprieto.utils.TCPIP;

public class ResumeControllerProxy extends ResumeController {
	
	private TCPIP tcpip;

	public ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean newGame) {
		this.tcpip.send(FrameType.NEW_GAME.name());
		this.tcpip.send(newGame);	
	}

}
