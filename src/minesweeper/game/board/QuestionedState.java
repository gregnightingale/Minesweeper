package minesweeper.game.board;



class QuestionedState extends State {
	private static QuestionedState inst = new QuestionedState();

	private QuestionedState() {
	}

	static State instance() {
		return inst;
	}

	@Override
	public void probeAndClear(Location loc) {
		super.probeAndClear(loc); // default behavior
	}

	@Override
	public void changeToMarkedState(Location loc) { 
		loc.setCurrent(MarkedState.instance());
	}

	@Override
	public void changeToBlankState(Location loc) {
		loc.setCurrent(BlankState.instance());
	}

	@Override
	public void changeToQuestionedState(Location loc) { // toggle
		loc.setCurrent(BlankState.instance());
	}

	@Override
	public String getTextRepresentation(Location loc) {
		return "?";
	}

}
