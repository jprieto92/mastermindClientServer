package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;

public class StartController extends UseCaseController implements AcceptorController {

  public StartController(Session session) {
    super(session);
  }

  public void initGame() {
    this.session.initGame();
    this.session.next();
  }

  public void accept(ControllerVisitor controllerVisitor) {
	 controllerVisitor.visit(this);	
  }

}
