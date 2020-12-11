package jprieto.mastermind.controllers;

import java.util.List;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;

public abstract class PlayController extends AcceptorController {

	public PlayController(Session session) {
		super(session);
	}

	public abstract boolean isLooser();

	public abstract boolean isWinner();

	public abstract void addProposedCombination(List<Color> colors);
	
	public abstract Error getProposedCombinationError(List<Color> colors);

	public abstract int getAttempts();

	public abstract List<Color> getColors(int position);

	public abstract int getBlacks(int position);

	public abstract int getWhites(int position);

	public abstract void undo();

	public abstract boolean undoable();

	public abstract void redo();

	public abstract boolean redoable();
	
	public abstract int getWidth();

	@Override
	public void accept(ControllerVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}
