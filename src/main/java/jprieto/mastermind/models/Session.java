package jprieto.mastermind.models;

import java.util.List;

import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.StateValue;

public class Session {

  private Game game;
  private GameRegistry registry;
  private State state;

  public Session() {
    this.state = new State();
    this.game = new Game();
  }
  
  public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
		this.registry.register();
	}

  public StateValue getValueState() {
    return this.state.getValueState();
  }

  public void next() {
    this.state.next();
  }

  public void initGame() {
    this.registry = new GameRegistry(this.game);
  }

  public void reset() {
    this.game.clear();
    this.state.reset();
  }

  public boolean isLooser() {
    return this.game.isLooser();
  }

  public boolean isWinner() {
    return this.game.isWinner();
  }

  public void undo() {
    this.registry.undo();
  }

  public boolean undoable() {
    return this.registry.isUndoable();
  }

  public void redo() {
    this.registry.redo();
  }

  public boolean redoable() {
    return this.registry.isRedoable();
  }
  
  public int getAttempts()
  {
	  return this.game.getAttempts();
  }
  
  public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

	public int getBlacks(int position) {
		return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.game.getWhites(position);
	}

	public int getWidth() {
		return Combination.getWidth();
	}
	
}
