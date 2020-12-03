package jprieto.mastermind.distributed;

import jprieto.mastermind.distributed.dispatchers.FrameType;
import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.StateValue;
import jprieto.utils.TCPIP;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	
	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}
	
	public int getWidth()
	{
		this.tcpip.send(FrameType.WIDTH.name());
		return this.tcpip.receiveInt();
	}

}
