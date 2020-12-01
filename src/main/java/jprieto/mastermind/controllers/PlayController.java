package jprieto.mastermind.controllers;

import java.util.List;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;

public class PlayController extends UseCaseController implements AcceptorController {

	private ActionController actionController;
	private UndoController undoController;
	private RedoController redoController;

	public PlayController(Session session) {
		super(session);
		this.actionController = new ActionController(session);
		this.undoController = new UndoController(session);
		this.redoController = new RedoController(session);
	}

	public boolean isLooser() {
		return this.actionController.isLooser();
	}

	public boolean isWinner() {
		return this.actionController.isWinner();
	}

	public Error addProposedCombination(List<Color> colors) {
		return this.actionController.addProposedCombination(colors);
	}

	public int getAttempts() {
		return this.actionController.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.actionController.getColors(position);
	}

	public int getBlacks(int position) {
		return this.actionController.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.actionController.getWhites(position);
	}

	public void undo() {
		this.undoController.undo();
	}

	public boolean undoable() {
		return this.undoController.undoable();
	}

	public void redo() {
		this.redoController.redo();
	}

	public boolean redoable() {
		return this.redoController.redoable();
	}

	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);		
	}


}
