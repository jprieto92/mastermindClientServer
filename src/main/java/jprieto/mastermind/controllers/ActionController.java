package jprieto.mastermind.controllers;

import java.util.List;

import jprieto.mastermind.models.Combination;
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

	public Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		if (error == null){
			this.sessionImplementation.addProposedCombination(colors);
			if (this.sessionImplementation.isWinner() || this.sessionImplementation.isLooser()) {
				this.sessionImplementation.next();
			}
		}
		return error;	
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
