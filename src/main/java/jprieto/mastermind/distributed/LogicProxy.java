package jprieto.mastermind.distributed;

import jprieto.mastermind.controllers.Logic;
import jprieto.mastermind.types.StateValue;
import jprieto.mastermind.distributed.dispatchers.TCPIP;

public class LogicProxy extends Logic {
	
	private TCPIP tcpip;
	
	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.controllers.put(StateValue.INITIAL, new StartControllerProxy(this.session,this.tcpip));
		this.controllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session,this.tcpip));
		this.controllers.put(StateValue.RESUME, new ResumeControllerProxy(this.session,this.tcpip));
		this.controllers.put(StateValue.EXIT, null);
	}

	public void close() {
		this.tcpip.close();
	}
	
}
