package minesweeper.game.player;

import minesweeper.game.Game;

import commons.IntegerCoordinate;


public class Mark extends Move {

	private IntegerCoordinate coord;
	
	public Mark(Game game, IntegerCoordinate coord) {
		super(game);
		this.coord = coord;
	}

	@Override
	public void execute() {
		game.getBoard().mark(coord);
	}

	@Override
	public String toString() {
		return "mark" + coord.toString();
	}


}
