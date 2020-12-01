package jprieto.mastermind.models;

class GameMemento {

  private Board board;
  

  GameMemento(Board board) {
    this.board = board.copy();
  }

  Board getBoard() {
	    return this.board;
  }

}
