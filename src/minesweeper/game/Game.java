package minesweeper.game;

import minesweeper.game.board.Board;
import minesweeper.game.player.Player;


public class Game {

	private Board board;
	private Player player;
	private Configuration config;

	protected boolean isDone = false;

	public Game(Configuration config) throws Exception {
		this.config = config;
		board = new Board(this);
		player = new Player(this);
		board.placeBombsRandomly();
	}

	public Board getBoard() {
		return board;
	}

	public Player getPlayer() {
		return player;
	}

	public Configuration getConfig() {
		return config;
	}

	public void play() {
		player.showBoard();
		while (!isDone) {
			player.executeMove();
			player.showBoard();
		}
		System.out.println(board.reveal());
	
		if (isWinner()) {
			System.out.println("Winner.");
		} else {
			System.out.println("You Lose.");
		}
		System.out.println("Game Over.");
	}

	/**
	 * to win, all locations with a bomb must be marked and there must be no
	 * locations marked that do not have a bomb.
	 * 
	 * @return true if win
	 */
	private boolean isWinner() {
		boolean allBombsMarked = board.getLocations().stream()
				.filter(loc -> loc.isBomb())
				.allMatch(loc -> loc.isMarked());
		boolean noFalseMarks = board.getLocations().stream()
				.filter(loc -> loc.isMarked())
				.noneMatch(loc -> !loc.isBomb());
		return allBombsMarked && noFalseMarks;
	}

	public void stop() {
		isDone = true;
	}

}
