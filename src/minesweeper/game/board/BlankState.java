package minesweeper.game.board;

class BlankState extends State {
	private static BlankState inst = new BlankState();

	private BlankState() {
	}

	static State instance() {
		return inst;
	}

	@Override
	public void probeAndClear(Location loc) {
		super.probeAndClear(loc); // default behavior
	}

	@Override
	public void changeToMarkedState(Location loc) { // cycle mark question->definite->blank
		loc.setCurrent(MarkedState.instance());
	}

	@Override
	public void changeToBlankState(Location loc) {
		// nothing to do.
		// TODO provide feedback that no action has been taken.
	}

	@Override
	public void changeToQuestionedState(Location loc) {
		loc.setCurrent(QuestionedState.instance());
	}

	@Override
	public String getTextRepresentation(Location loc) {
		return " ";
	}

}