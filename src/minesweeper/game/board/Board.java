package minesweeper.game.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import minesweeper.game.Game;

import commons.IntegerCoordinate;

public class Board implements LocationListener {

	private Location[][][] grid; // up to 3 dimensions
	private List<Location> locations = new ArrayList<Location>();

	private Game game;

	public Board(Game game) throws Exception {
		this.game = game;
		create();
	}

	public void probe(IntegerCoordinate coord) {
		getLocation(coord).probe();
	}

	public void mark(IntegerCoordinate coord) {
		getLocation(coord).mark();
	}

	public void unmark(IntegerCoordinate coord) {
		getLocation(coord).unmark();
	}

	public void question(IntegerCoordinate coord) {
		getLocation(coord).question();
	}

	public int getProximityCount(IntegerCoordinate coordinate) {

		int bombsInProximity = 0;
		for (IntegerCoordinate coord : getNeighbors(coordinate)) {
			if (getLocation(coord).isBomb()) {
				bombsInProximity++;
			}
		}
		return bombsInProximity;
	}

	public Location getLocation(IntegerCoordinate coord) {
		return grid[coord.getX()][coord.getY()][coord.getZ()];
	}

	public Location getLocation(int x) {
		return getLocation(x, 0, 0);
	}

	public Location getLocation(int x, int y) {
		return getLocation(x, y, 0);
	}

	public Location getLocation(int x, int y, int z) {
		return grid[x][y][z];
	}

	private Set<IntegerCoordinate> getNeighbors(IntegerCoordinate coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();
		int z = coordinate.getZ();

		Set<IntegerCoordinate> results = new HashSet<IntegerCoordinate>();
		for (int xt = x - 1; xt <= x + 1; xt++) {
			for (int yt = y - 1; yt <= y + 1; yt++) {
				for (int zt = z - 1; zt <= z + 1; zt++) {
					IntegerCoordinate testCoord = new IntegerCoordinate(xt, yt,
							zt);
					if (isOnBoard(testCoord)) {
						results.add(testCoord);
					}
				}
			}
		}
		return results;
	}

	private boolean isOnBoard(IntegerCoordinate coord) {
		int x = coord.getX();
		int y = coord.getY();
		int z = coord.getZ();
		if (x < 0 || x > game.getConfig().getMaxX())
			return false;
		if (y < 0 || y > game.getConfig().getMaxY())
			return false;
		if (z < 0 || z > game.getConfig().getMaxZ())
			return false;
		return true;
	}

	public int getProximityCount(Location location) {
		IntegerCoordinate coordinate = location.getCoordinate();
		return getProximityCount(coordinate);
	}

	public int getProximityCount(int x, int y, int z) {
		IntegerCoordinate coord = new IntegerCoordinate(x, y, z);
		return getProximityCount(coord);
	}

	public int getProximityCount(int x, int y) {
		return getProximityCount(x, y, 0);
	}

	public int getProximityCount(int x) {
		return getProximityCount(x, 0, 0);
	}

	public void placeBombsRandomly() {
		for (Location loc : getRandomLocations(game.getConfig().getBombsTotal())) {
			loc.setBomb();
		}
	}

	private List<Location> getRandomLocations(int quantity) {
		List<Location> results = new ArrayList<Location>();
		ArrayList<Location> pool = this.toArrayList();
		Random rand = new Random();
		for (int count = 0; count < quantity; count++) {
			results.add(pool.remove(rand.nextInt(pool.size())));
		}
		return results;
	}

	private ArrayList<Location> toArrayList() {
		ArrayList<Location> arr = new ArrayList<Location>();
		for (int x = 0; x <= game.getConfig().getMaxX(); x++)
			for (int y = 0; y <= game.getConfig().getMaxY(); y++)
				for (int z = 0; z <= game.getConfig().getMaxZ(); z++) {
					arr.add(grid[x][y][z]);
				}
		return arr;
	}

	private void create() throws Exception {
		grid = new Location[game.getConfig().getMaxX() + 1][game.getConfig()
				.getMaxY() + 1][game.getConfig().getMaxZ() + 1];
		for (int z = 0; z <= game.getConfig().getMaxZ(); z++)
			for (int y = 0; y <= game.getConfig().getMaxY(); y++)
				for (int x = 0; x <= game.getConfig().getMaxX(); x++) {
					IntegerCoordinate coord = null;
					switch (game.getConfig().getDimensions()) {
					case 1:
						coord = new IntegerCoordinate(x);
						break;
					case 2:
						coord = new IntegerCoordinate(x, y);
						break;
					case 3:
						coord = new IntegerCoordinate(x, y, z);
						break;
					}
					grid[x][y][z] = new Location(this, coord);
					locations.add(grid[x][y][z]);
				}
	}

	public List<Location> getLocations() {
		return locations;
	}

	@Override
	public void onStateChanged(Location loc, State newState) {
		if (newState instanceof ExplodedState) {
			System.out.println("KABOOM!");
			System.out.println("Board has detected an explosion.");
			game.stop();
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int z = 0; z <= game.getConfig().getMaxZ(); z++) {
			for (int y = 0; y <= game.getConfig().getMaxY(); y++) {
				for (int x = 0; x <= game.getConfig().getMaxX(); x++) {
					builder.append("[");
					builder.append(grid[x][y][z].toString());
					builder.append("]");
				}
				builder.append("\n");
			}
		}
		return builder.toString();
	}

	public String getPlayersView() {
		return this.toString();
	}

	public void display() {
		System.out.println(this.toString());
	}

	public String reveal() {
		StringBuilder builder = new StringBuilder();
		for (int z = 0; z <= game.getConfig().getMaxZ(); z++) {
			for (int y = 0; y <= game.getConfig().getMaxY(); y++) {
				for (int x = 0; x <= game.getConfig().getMaxX(); x++) {
					builder.append("[");
					if (grid[x][y][z].isBomb()) {
						builder.append("*");
					} else {
						builder.append(" ");
					}
					builder.append("]");
				}
				builder.append("\n");
			}
		}

		return builder.toString();
	}
}
