package jprieto.mastermind.controllers.implementation;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.models.SessionImplementation;
import jprieto.mastermind.controllers.StartController;

public class StartControllerImplementation extends StartController {

  SessionImplementation sessionImplementation;	

  public StartControllerImplementation(Session session) {
    super(session);
    this.sessionImplementation = ((SessionImplementation) this.session);
  }

  public void initGame() {
    this.sessionImplementation.next();
  }
  
  public int getWidth()
  {
	  return this.sessionImplementation.getWidth();
  }

}
