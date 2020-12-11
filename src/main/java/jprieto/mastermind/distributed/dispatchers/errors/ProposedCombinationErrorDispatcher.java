package jprieto.mastermind.distributed.dispatchers.errors;

import java.util.List;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.distributed.dispatchers.Dispatcher;
import jprieto.mastermind.types.Color;

public class ProposedCombinationErrorDispatcher extends Dispatcher {

	public ProposedCombinationErrorDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		List<Color> proposedCombination = this.tcpip.receiveProposedCombination();
		this.tcpip.send(((PlayController)this.acceptorController).getProposedCombinationError(proposedCombination));
	}

}
