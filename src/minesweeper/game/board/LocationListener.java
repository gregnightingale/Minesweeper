package minesweeper.game.board;

public interface LocationListener {
	public void onStateChanged(Location loc, State newState);
}
