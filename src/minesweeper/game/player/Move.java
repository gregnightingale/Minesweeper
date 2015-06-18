package minesweeper.game.player;

import minesweeper.game.Game;

public abstract class Move {
	protected Game game;

	abstract public void execute();

	public Move(Game game) {
		this.game = game;
	}
}
