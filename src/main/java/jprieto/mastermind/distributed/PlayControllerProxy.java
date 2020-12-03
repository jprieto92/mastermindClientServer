package jprieto.mastermind.distributed;

import java.util.ArrayList;
import java.util.List;

import jprieto.mastermind.types.Color;
import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.Error;
import jprieto.mastermind.distributed.dispatchers.FrameType;
import jprieto.mastermind.distributed.dispatchers.TCPIP;



public class PlayControllerProxy extends PlayController {

	private TCPIP tcpip;

	PlayControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public boolean isLooser() {
		this.tcpip.send(FrameType.LOOSER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isWinner() {
		this.tcpip.send(FrameType.WINNER.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public Error addProposedCombination(List<Color> colors) {
		this.tcpip.send(FrameType.PROPOSE_COMBINATION.name());
		return this.tcpip.receiveError();
	}

	@Override
	public int getAttempts() {
		this.tcpip.send(FrameType.ATTEMPTS.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public List<Color> getColors(int position) {
		List<Color> colors = new ArrayList<Color>();
		this.tcpip.send(FrameType.COLORS.name());
		// send position
		// fill new List<Color>  receiving int
		return colors;
	}

	@Override
	public int getBlacks(int position) {
		this.tcpip.send(FrameType.BLACKS.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public int getWhites(int position) {
		this.tcpip.send(FrameType.WHITES.name());
		this.tcpip.send(position);
		return this.tcpip.receiveInt();
	}

	@Override
	public void undo() {
		this.tcpip.send(FrameType.UNDO.name());
	}

	@Override
	public boolean undoable() {
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();	
	}

	@Override
	public void redo() {
		this.tcpip.send(FrameType.REDO.name());
	}

	@Override
	public boolean redoable() {
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}
	
	@Override
	public int getWidth()
	{
		this.tcpip.send(FrameType.WIDTH.name());
		return this.tcpip.receiveInt();
	}
}
