package jprieto.mastermind.views.graphics;

import jprieto.mastermind.controllers.ProposalController;
import jprieto.mastermind.controllers.ResumeController;
import jprieto.mastermind.controllers.StartController;
import jprieto.mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	
	public void visit(StartController startController) {
		this.gameView.interact(startController);
	}

	
	public void visit(ProposalController proposalController) {
		this.gameView.interact(proposalController);
	}

	
	public void visit(ResumeController resumeController) {
		ResumeDialog resumeDialog = new ResumeDialog();
		resumeController.resume(resumeDialog.isNewGame());
		if (resumeDialog.isNewGame()) {
			this.gameView = new GameView();
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
		}
	}

}
