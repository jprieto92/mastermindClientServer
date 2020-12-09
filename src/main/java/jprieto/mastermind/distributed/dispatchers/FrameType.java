package jprieto.mastermind.distributed.dispatchers;

public enum FrameType { 
	STATE,
	START,
	START_WIDTH,
	WINNER,
	LOOSER,
	PROPOSE_COMBINATION,
	ATTEMPTS,
	COLORS,
	BLACKS,
	WHITES,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE,
	PLAY_WIDTH,
	CLOSE,
	NEXT_STATE,
	NEW_GAME;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
