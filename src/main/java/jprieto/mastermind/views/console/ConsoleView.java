package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.AcceptorController;
import jprieto.mastermind.controllers.ControllerVisitor;
import jprieto.mastermind.controllers.PlayController;
import jprieto.mastermind.controllers.ResumeController;
import jprieto.mastermind.controllers.StartController;
import jprieto.mastermind.views.View;

public class ConsoleView extends View implements ControllerVisitor {
	
	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;
	
	public ConsoleView(){
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resumeView = new ResumeView();
	}

	
	@Override
	public void interact(AcceptorController controller) {
		controller.accept(this);
	}


	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}


	public void visit(PlayController playController) {
		this.playView.interact(playController);		
	}


	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);		
	}

}
