package minesweeper.game.board;

class MarkedState extends State {
	private static MarkedState inst = new MarkedState();

	private MarkedState() {
	}

	static State instance() {
		return inst;
	}

	@Override
	public void probeAndClear(Location loc) {
		super.probeAndClear(loc); // default behavior
	}

	@Override
	public void changeToMarkedState(Location loc) { // toggle
		loc.setCurrent(BlankState.instance());
	}

	@Override
	public void changeToBlankState(Location loc) {
		loc.setCurrent(BlankState.instance());
	}

	@Override
	public void changeToQuestionedState(Location loc) {
		loc.setCurrent(QuestionedState.instance());
	}

	@Override
	public String getTextRepresentation(Location loc) {
		return "+";
	}

}
