package minesweeper.game.board;

abstract class State {
	/**
	 * probe the location to determine how many mines are in proximity, if the
	 * location hosts a mine, the player is destroyed and the game is over.
	 * 
	 * @param loc
	 */
	public void probeAndClear(Location loc) {
		if (loc.isBomb()) {
			loc.setCurrent(ExplodedState.instance());
		} else {
			loc.setCurrent(ClearedState.instance());
			ProbeData probeData = new ProbeData();
			int minesInProximity = loc.getBoard().getProximityCount(loc);
			probeData.setMinesInProximity(minesInProximity);
			loc.setProbeData(probeData);
			// TODO if none in proximity clear out empty region automatically.
		}
	};

	/**
	 * mark the location that has been determined to host a mine.  
	 * marking an already marked location will toggle the mark off.
	 * 
	 * @param loc
	 */
	abstract public void changeToMarkedState(Location loc);

	/**
	 * question marking an already question marked location will simply toggle
	 * the question mark off.
	 * 
	 * @param loc
	 */
	abstract public void changeToQuestionedState(Location loc);

	/**
	 * clear player marks or question marks from the location
	 * 
	 * @param loc
	 */
	abstract public void changeToBlankState(Location loc);

	abstract public String getTextRepresentation(Location loc);

}