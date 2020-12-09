package jprieto.mastermind.distributed.dispatchers;

import java.util.List;

import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.types.Color;
import jprieto.utils.ColorUtils;

public class ColorsDispatcher extends Dispatcher {

    public ColorsDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		List<Color> colors = ((PlayController)this.acceptorController).getColors(position);
		String proposedCombination = "";
		for(int i = 0; i< colors.size(); i++)
		{
			proposedCombination += ColorUtils.INITIALS[colors.get(i).ordinal()];
		}
		this.tcpip.send(proposedCombination);
	}
    
}