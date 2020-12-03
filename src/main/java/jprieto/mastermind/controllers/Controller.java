package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.StateValue;


public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}
	
	public StateValue getValueState() {
		return this.session.getValueState();
	}
	
	public int getWidth()
	{
		return this.session.getWidth();
	}
}
