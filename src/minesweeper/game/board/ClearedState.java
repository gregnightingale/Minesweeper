package minesweeper.game.board;

/**
 * 
 * @author gregnightingale
 *
 */
class ClearedState extends State {
	private static ClearedState inst = new ClearedState();

	private ClearedState() {
	}

	static State instance() {
		return inst;
	}

	@Override
	public void probeAndClear(Location loc) {
		// cannot probe a cleared location!
		// TODO provide feedback
	}

	@Override
	public void changeToMarkedState(Location loc) {
		// cannot mark a cleared location!
		// TODO provide feedback
	}

	@Override
	public void changeToQuestionedState(Location loc) {
		// cannot question an already cleared location!
		// TODO provide feedback
	}

	@Override
	public String getTextRepresentation(Location loc) {
		return loc.getProbeData().toString();
	}

	@Override
	public void changeToBlankState(Location loc) {
		// TODO Auto-generated method stub
		
	}

}
