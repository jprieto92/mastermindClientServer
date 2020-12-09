package jprieto.mastermind.models;

import java.util.List;

import jprieto.mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;
	private Board board;

	public Game() {
		this.board = new Board();
	}

	public void clear() {
		this.board.clear();
	}

	public void addProposedCombination(List<Color> colors) {
		this.board.addProposedCombination(colors);
	}

	public boolean isLooser() {
		return this.board.getAttempts() == Game.MAX_LONG;
	}
	
	public boolean isWinner() {
		return this.board.getResult(this.board.getAttempts()-1).isWinner();
	}

	public int getAttempts() {
		return this.board.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.board.getProposedCombination(position).colors;
	}

	public int getBlacks(int position) {
		return this.board.getResult(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.board.getResult(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}
	
	public GameMemento createMemento() {
        return new GameMemento(this.board);
	}

	public void set(GameMemento memento) {
       this.board = memento.getBoard().copy();
    }
	
	public void newGame()
	{
		this.board = new Board();
	}

}
