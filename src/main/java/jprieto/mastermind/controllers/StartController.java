package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;

public abstract class StartController extends AcceptorController {

  public StartController(Session session) {
    super(session);
  }

  public abstract int getWidth();
  
  public abstract void initGame();

  @Override
  public void accept(ControllerVisitor controllerVisitor) {
	 controllerVisitor.visit(this);	
  }

}
