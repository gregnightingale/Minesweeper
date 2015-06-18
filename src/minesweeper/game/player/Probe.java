package minesweeper.game.player;

import minesweeper.game.Game;

import commons.IntegerCoordinate;


class Probe extends Move {

	IntegerCoordinate coord;

	public Probe(Game game, IntegerCoordinate coord) {
		super(game);
		this.coord = coord;
	}

	@Override
	public void execute() {
		game.getBoard().probe(coord);
	}

	@Override
	public String toString() {
		return "probe" + coord.toString();
	}

}
