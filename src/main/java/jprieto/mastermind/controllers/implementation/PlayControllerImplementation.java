package jprieto.mastermind.controllers.implementation;

import java.util.List;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;
import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.controllers.UndoController;
import jprieto.mastermind.controllers.ActionController;
import jprieto.mastermind.controllers.RedoController;

public class PlayControllerImplementation extends PlayController {

	private ActionController actionController;
	private UndoController undoController;
	private RedoController redoController;

	public PlayControllerImplementation(Session session) {
		super(session);
		this.actionController = new ActionController(session);
		this.undoController = new UndoController(session);
		this.redoController = new RedoController(session);
	}

	@Override
	public boolean isLooser() {
		return this.actionController.isLooser();
	}

	@Override
	public boolean isWinner() {
		return this.actionController.isWinner();
	}

	@Override
	public void addProposedCombination(List<Color> colors) {
		this.actionController.addProposedCombination(colors);
	}
	
	@Override
	public Error getProposedCombinationError(List<Color> colors)
	{
		return this.actionController.getProposedCombinationError(colors);
	}

	@Override
	public int getAttempts() {
		return this.actionController.getAttempts();
	}

	@Override
	public List<Color> getColors(int position) {
		return this.actionController.getColors(position);
	}

	@Override
	public int getBlacks(int position) {
		return this.actionController.getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return this.actionController.getWhites(position);
	}

	@Override
	public void undo() {
		this.undoController.undo();
	}

	@Override
	public boolean undoable() {
		return this.undoController.undoable();
	}

	@Override
	public void redo() {
		this.redoController.redo();
	}

	@Override
	public boolean redoable() {
		return this.redoController.redoable();
	}
	
	@Override
	public int getWidth()
	{
		return this.actionController.getWidth();
	}

}
