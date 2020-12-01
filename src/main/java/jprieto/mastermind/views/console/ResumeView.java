package jprieto.mastermind.views.console;

import jprieto.mastermind.controllers.ResumeController;
import jprieto.mastermind.views.MessageView;
import jprieto.utils.YesNoDialog;

class ResumeView {

	boolean interact(ResumeController resumeController) {
		boolean isResumed = new YesNoDialog().read(MessageView.RESUME.toString());
		resumeController.resume(isResumed);
		return isResumed;
	}
	
}
