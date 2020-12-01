package jprieto.mastermind.models;

import java.util.List;

import jprieto.mastermind.types.Color;

class ProposedCombination extends Combination {

	ProposedCombination(List<Color> colors) {
		this.colors = colors;
	}
	
	private ProposedCombination(ProposedCombination proposedCombination) {
		this.colors = proposedCombination.colors;
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ProposedCombination copy() {
		return new ProposedCombination(this);
	}

}
