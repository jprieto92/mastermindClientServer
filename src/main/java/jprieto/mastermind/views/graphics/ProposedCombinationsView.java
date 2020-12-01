package jprieto.mastermind.views.graphics;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import jprieto.mastermind.controllers.PlayController;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {
	
	ProposedCombinationsView() {
		this.setLayout(new GridBagLayout());
	}

	void add(PlayController playController) {
		int attempts = playController.getAttempts();
		this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
		this.add(new ProposedCombinationView(playController), new Constraints(1, attempts, 1, 1));
		this.add(new ResultView(playController), new Constraints(2, attempts, 1, 1));
	}
}
