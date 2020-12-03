package jprieto.mastermind.controllers;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.models.SessionImplementation;

public class UndoController extends Controller {
	
  private SessionImplementation sessionImplementation;

  public UndoController(Session session) {
    super(session);
    this.sessionImplementation = ((SessionImplementation) this.session);
  }

  public void undo() {
    this.sessionImplementation.undo();
  }

  public boolean undoable() {
    return this.sessionImplementation.undoable();
  }

}
