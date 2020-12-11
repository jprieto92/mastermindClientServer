package jprieto.mastermind.distributed;

import java.util.List;

import jprieto.mastermind.types.Color;
import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.Error;
import jprieto.mastermind.distributed.dispatchers.FrameType;
import jprieto.mastermind.distributed.dispatchers.TCPIP;
import jprieto.utils.ColorUtils;



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
	public void addProposedCombination(List<Color> colors) {
		this.tcpip.send(FrameType.PROPOSE_COMBINATION.name());
		String proposedCombination = "";
		for(int i = 0; i< colors.size(); i++)
		{
			proposedCombination += ColorUtils.INITIALS[colors.get(i).ordinal()];
		}
		this.tcpip.send(proposedCombination);
	}
	
	@Override
	public Error getProposedCombinationError(List<Color> colors) {
		this.tcpip.send(FrameType.PROPOSED_COMBINATION_ERROR.name());
		String proposedCombination = "";
		for(int i = 0; i< colors.size(); i++)
		{
			proposedCombination += ColorUtils.INITIALS[colors.get(i).ordinal()];
		}
		this.tcpip.send(proposedCombination);
		return this.tcpip.receiveError();
	}

	@Override
	public int getAttempts() {
		this.tcpip.send(FrameType.ATTEMPTS.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public List<Color> getColors(int position) {
		this.tcpip.send(FrameType.COLORS.name());
		this.tcpip.send(position);
		return this.tcpip.receiveProposedCombination();
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
		this.tcpip.send(FrameType.START_WIDTH.name());
		return this.tcpip.receiveInt();
	}
}
