package jprieto.mastermind.models;

import jprieto.mastermind.types.StateValue;

public interface Session {

	StateValue getValueState();
	int getWidth();
	
}
