package jprieto.mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import jprieto.mastermind.models.Session;
import jprieto.mastermind.types.StateValue;

public class Logic {

	  protected Session session;
	  protected Map<StateValue, AcceptorController> controllers;

	  protected Logic() {
			this.controllers = new HashMap<StateValue, AcceptorController>();
		}

	  public AcceptorController getController() {
	    return this.controllers.get(this.session.getValueState());
	  }

	}
