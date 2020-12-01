package jprieto.mastermind.models;

class Result {

	private int blacks = 0;

	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}
	
	private Result(Result result)
	{
		assert result.blacks >= 0;
		assert result.whites >= 0;
		this.blacks = result.blacks;
		this.whites = result.whites;
	}

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	int getBlacks() {
		return this.blacks;
	}

	int getWhites() {
		return this.whites;
	}
	
	Result copy()
	{
		return new Result(this);
	}

}
