package minesweeper.game.board;

public class ProbeData {
	private int minesInProximity = 0;

	public int getMinesInProximity() {
		return minesInProximity;
	}

	public void setMinesInProximity(int minesInProximity) {
		this.minesInProximity = minesInProximity;
	}
	
	@Override
	public String toString() {
		return Integer.toString(minesInProximity);
	}
}
