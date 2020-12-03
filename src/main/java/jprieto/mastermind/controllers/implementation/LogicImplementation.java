package jprieto.mastermind.controllers.implementation;

import jprieto.mastermind.controllers.Logic;
import jprieto.mastermind.models.SessionImplementation;
import jprieto.mastermind.types.StateValue;

public class LogicImplementation extends Logic {

	protected StartControllerImplementation startControllerImplementation;

	protected PlayControllerImplementation playControllerImplementation;

	protected ResumeControllerImplementation resumeControllerImplementation;

	public LogicImplementation() {
		this.session = new SessionImplementation();
		this.startControllerImplementation = new StartControllerImplementation(this.session);
		this.playControllerImplementation = new PlayControllerImplementation(this.session);
		this.resumeControllerImplementation = new ResumeControllerImplementation(this.session);
		this.controllers.put(StateValue.INITIAL, this.startControllerImplementation);
		this.controllers.put(StateValue.IN_GAME, this.playControllerImplementation);
		this.controllers.put(StateValue.RESUME, this.resumeControllerImplementation);
		this.controllers.put(StateValue.EXIT, null);
	}

}
