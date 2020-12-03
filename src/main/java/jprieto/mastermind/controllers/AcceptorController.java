package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;

public abstract class AcceptorController extends Controller {
    
    AcceptorController(Session session) {
		super(session);
	}

	public abstract void accept(ControllerVisitor controllersVisitor);
}
