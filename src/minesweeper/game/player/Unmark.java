package minesweeper.game.player;

import minesweeper.game.Game;

import commons.IntegerCoordinate;


public class Unmark extends Move {

	private IntegerCoordinate coord;
	
	public Unmark(Game game, IntegerCoordinate coord) {
		super(game);
		this.coord = coord;
	}

	@Override
	public void execute() {
		game.getBoard().unmark(coord);
	}

	@Override
	public String toString() {
		return "mark" + coord.toString();
	}


}
