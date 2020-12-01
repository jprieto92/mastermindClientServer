package jprieto.mastermind.views.graphics;

import jprieto.mastermind.controllers.AcceptorController;
import jprieto.mastermind.controllers.ControllerVisitor;
import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.controllers.ResumeController;
import jprieto.mastermind.controllers.StartController;
import jprieto.mastermind.views.View;

public class GraphicsView extends View implements ControllerVisitor{

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	
	public void visit(StartController startController) {
		this.gameView.interact(startController);
	}

	
	public void visit(PlayController playController) {
		this.gameView.interact(playController);
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


	@Override
	public void interact(AcceptorController controller) {
		controller.accept(this);
	}

}
