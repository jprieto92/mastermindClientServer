package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;


public abstract class UseCaseController {

	protected Session session;

	UseCaseController(Session session) {
		this.session = session;
	}
	
	public int getWidth() {
		return this.session.getWidth();
	}

}
