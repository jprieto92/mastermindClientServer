package jprieto.mastermind.controllers.implementation;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.models.SessionImplementation;
import jprieto.mastermind.controllers.ResumeController;

public class ResumeControllerImplementation extends ResumeController {
	
  private SessionImplementation sessionImplementation;

  public ResumeControllerImplementation(Session session) {
    super(session);
    this.sessionImplementation = ((SessionImplementation) this.session);
  }

  @Override
  public void resume(boolean isResumed) {
    if (isResumed){
      this.sessionImplementation.newGame();
    } else {
      this.sessionImplementation.next();
    }
  }

}
