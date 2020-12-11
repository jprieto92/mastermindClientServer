package jprieto.mastermind.distributed;

import jprieto.mastermind.controllers.implementation.LogicImplementation;
import jprieto.mastermind.distributed.dispatchers.DispatcherPrototype;
import jprieto.mastermind.distributed.dispatchers.FrameType;
import jprieto.mastermind.distributed.dispatchers.WinnerDispatcher;
import jprieto.mastermind.distributed.dispatchers.StartDispatcher;
import jprieto.mastermind.distributed.dispatchers.StartWidthDispatcher;
import jprieto.mastermind.distributed.dispatchers.LooserDispatcher;
import jprieto.mastermind.distributed.dispatchers.ProposeCombinationDispatcher;
import jprieto.mastermind.distributed.dispatchers.AttemptsDispatcher;
import jprieto.mastermind.distributed.dispatchers.ColorsDispatcher;
import jprieto.mastermind.distributed.dispatchers.BlacksDispatcher;
import jprieto.mastermind.distributed.dispatchers.WhitesDispatcher;
import jprieto.mastermind.distributed.dispatchers.undoredo.UndoDispatcher;
import jprieto.mastermind.distributed.dispatchers.undoredo.UndoableDispatcher;
import jprieto.mastermind.distributed.dispatchers.undoredo.RedoDispatcher;
import jprieto.mastermind.distributed.dispatchers.undoredo.RedoableDispatcher;
import jprieto.mastermind.distributed.dispatchers.PlayWidthDispatcher;
import jprieto.mastermind.distributed.dispatchers.ResumeDispatcher;
import jprieto.mastermind.distributed.dispatchers.StateDispatcher;
import jprieto.mastermind.distributed.dispatchers.errors.ProposedCombinationErrorDispatcher;





public class LogicImplementationServer extends LogicImplementation {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.START_WIDTH, new StartWidthDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PROPOSE_COMBINATION, new ProposeCombinationDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PROPOSED_COMBINATION_ERROR, new ProposedCombinationErrorDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PLAY_WIDTH, new PlayWidthDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
	}

}
