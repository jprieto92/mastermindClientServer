package jprieto.mastermind.distributed;

import jprieto.mastermind.controllers.StartController;
import jprieto.mastermind.distributed.dispatchers.FrameType;
import jprieto.mastermind.models.Session;
import jprieto.utils.TCPIP;

public class StartControllerProxy extends StartController {
	
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void initGame() {
		this.tcpip.send(FrameType.START.name());
	}

}
