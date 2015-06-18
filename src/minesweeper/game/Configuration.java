package minesweeper.game;

public class Configuration {

	public static final int MAX_DIMENSIONS = 3;
	int dimensions;
	int maxX = 0;
	int maxY = 0;
	int maxZ = 0;
	int bombsTotal = 1;

	public int getDimensions() {
		return dimensions;
	}
	public void setDimensions(int dimensions) throws Exception {
		this.dimensions = dimensions;
		if (dimensions > MAX_DIMENSIONS)
			throw new Exception("Exceeds maximum dimensions!");
		if (dimensions == 0)
			throw new Exception("Cannot have a zero dimensional board!");
	}
	public int getMaxX() {
		return maxX;
	}
	public void setWidth(int w) {
		this.maxX = w-1;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setHeight(int h) {
		this.maxY = h-1;
	}
	public int getMaxZ() {
		return maxZ;
	}
	public void setDepth(int d) {
		this.maxZ = d-1;
	}
	public int getBombsTotal() {
		return bombsTotal;
	}
	public void setBombsTotal(int bombsTotal) throws Exception {
		if (bombsTotal > 0) {
			this.bombsTotal = bombsTotal;
		} else {
			throw new Exception("Error - there must be a positive number of bombs.");
		}
	}

}
