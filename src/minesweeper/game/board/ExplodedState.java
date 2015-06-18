package minesweeper.game.board;

class ExplodedState extends State {

	private static ExplodedState inst = new ExplodedState();

	private ExplodedState() {
	}

	static State instance() {
		return inst;
	}

	@Override
	public void probeAndClear(Location loc) {
		// the game is already over, player has exploded!
		// TODO provide feedback
	}

	@Override
	public void changeToMarkedState(Location loc) {
		// the game is already over, player has exploded!
		// TODO provide feedback
	}

	@Override
	public void changeToBlankState(Location loc) {
		// the game is already over, player has exploded!
		// TODO provide feedback
	}

	@Override
	public void changeToQuestionedState(Location loc) {
		// the game is already over, player has exploded!
		// TODO provide feedback
	}

	@Override
	public String getTextRepresentation(Location loc) {
		return "X";
	}

}
