package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;

public abstract class ResumeController extends AcceptorController {

  public ResumeController(Session session) {
    super(session);
  }

  public abstract void resume(boolean isResumed);

  @Override
  public void accept(ControllerVisitor controllerVisitor) {
	controllerVisitor.visit(this);	
  }

}
