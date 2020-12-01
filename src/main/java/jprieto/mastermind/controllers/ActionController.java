package jprieto.mastermind.controllers;

import java.util.List;

import jprieto.mastermind.models.Combination;
import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.Color;
import jprieto.mastermind.types.Error;

public class ActionController extends UseCaseController {

	public ActionController(Session session) {
    super(session);
  }
  
  public boolean isLooser() {
		return this.session.isLooser();
	}

	public boolean isWinner() {
		return this.session.isWinner();
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
			this.session.addProposedCombination(colors);
			if (this.session.isWinner() || this.session.isLooser()) {
				this.session.next();
			}
		}
		return error;	
	}

	public int getAttempts() {
		return this.session.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.session.getColors(position);
	}

	public int getBlacks(int position) {
		return this.session.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.session.getWhites(position);
	}

}
