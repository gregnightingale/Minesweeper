package minesweeper.game.player;

import minesweeper.game.Game;

import commons.IntegerCoordinate;


public class Question extends Move {
	
	private IntegerCoordinate coord;

	public Question(Game game, IntegerCoordinate coord) {
		super(game);
		this.coord = coord;
	}

	@Override
	public void execute() {
		game.getBoard().question(coord);
	}

	@Override
	public String toString() {
		return "question" + coord.toString();
	}

}
