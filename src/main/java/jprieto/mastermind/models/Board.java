package jprieto.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import jprieto.mastermind.types.Color;

public class Board {

	private SecretCombination secretCombination;
	private List<ProposedCombination> proposedCombinations;
	private List<Result> results;
	private int attempts;

	public Board() {
		this.clear();
	}
	
	private Board(Board board) {
		this();
		assert board != null;
		this.secretCombination = board.secretCombination.copy();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		for(int i = 0; i < board.getAttempts(); i++)
		{
			this.proposedCombinations.add(board.getProposedCombination(i).copy());
			this.results.add(board.getResult(i).copy());
		}
		this.attempts = board.attempts;
	}
	
	public Board copy() {
		return new Board(this);
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}

	public int getAttempts() {
		return this.attempts;
	}
	
	public Result getResult(int position) {
		return this.results.get(position);
	}
	
	public ProposedCombination getProposedCombination(int position) {
		return this.proposedCombinations.get(position);
	}
	
	public SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}
	
	public void putSecretCombination(SecretCombination secretCombination)
	{
		this.secretCombination = secretCombination;
	}
	
	public void putProposedCombinations(int attempts, List<ProposedCombination> proposedCombinations)
	{
		this.attempts = attempts;
		this.proposedCombinations = proposedCombinations;
	}
	
	public void putResults(List<Result> results)
	{
		this.results = results;
	}

}
