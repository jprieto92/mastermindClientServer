package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.models.SessionImplementation;

public class RedoController extends Controller {

  private SessionImplementation sessionImplementation;
	
  public RedoController(Session session) {
    super(session);
    this.sessionImplementation = ((SessionImplementation) this.session);
  }

  public void redo() {
    this.sessionImplementation.redo();
  }

  public boolean redoable() {
    return this.sessionImplementation.redoable();
  }

}
