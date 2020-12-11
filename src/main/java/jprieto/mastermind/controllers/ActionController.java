package jprieto.mastermind.controllers;

import java.util.List;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;
import jprieto.mastermind.models.SessionImplementation;

public class ActionController extends Controller {
	
	private SessionImplementation sessionImplementation;

	public ActionController(Session session) {
    super(session);
    this.sessionImplementation = ((SessionImplementation) this.session);
  }
  
  public boolean isLooser() {
		return this.sessionImplementation.isLooser();
	}

	public boolean isWinner() {
		return this.sessionImplementation.isWinner();
	}

	public void addProposedCombination(List<Color> colors) {
		this.sessionImplementation.addProposedCombination(colors);
	}
	
	public Error getProposedCombinationError(List<Color> colors)
	{
		return this.sessionImplementation.getProposedCombinationError(colors);
	}

	public int getAttempts() {
		return this.sessionImplementation.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.sessionImplementation.getColors(position);
	}

	public int getBlacks(int position) {
		return this.sessionImplementation.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.sessionImplementation.getWhites(position);
	}
	
	public int getWidth()
	{
		return this.sessionImplementation.getWidth();
	}

}
