package minesweeper.game.player;

import minesweeper.game.Game;


public class Done extends Move {

	public Done(Game game) {
		super(game);
	}

	@Override
	public void execute() {
		game.stop();
	}

	@Override
	public String toString() {
		return "done";
	}

}
