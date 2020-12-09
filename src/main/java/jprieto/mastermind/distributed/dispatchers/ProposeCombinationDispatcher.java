package jprieto.mastermind.distributed.dispatchers;

import java.util.List;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.types.Color;

public class ProposeCombinationDispatcher extends Dispatcher {

    public ProposeCombinationDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		List<Color> proposedCombination = this.tcpip.receiveProposedCombination();
		this.tcpip.send(((PlayController)this.acceptorController).addProposedCombination(proposedCombination));
	}
    
}