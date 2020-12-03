package jprieto.mastermind.distributed.dispatchers;

public enum FrameType { 
	START,
	STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE,
	CLOSE,
	WINNER,
	LOOSER,
	PROPOSE_COMBINATION,
	ATTEMPTS,
	COLORS,
	BLACKS,
	WHITES,
	NEXT_STATE,
	NEW_GAME,
	WIDTH;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
