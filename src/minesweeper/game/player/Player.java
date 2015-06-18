package minesweeper.game.player;

import java.util.Scanner;

import minesweeper.game.Game;

import commons.IntegerCoordinate;

public class Player {

	private Game game;
	private Scanner scanner = new Scanner(System.in);

	public Player(Game game) {
		this.game = game;
	}

	public void executeMove() {
		Move move = getMove();
		move.execute();
	}

	public void showBoard() {
		System.out.println(game.getBoard().getPlayersView());
	}

	private Move getMove() {
		Move move = null;
		while (move == null) {
			System.out.println("Enter Command:");
			String command = scanner.next();
			// TODO improve input to handle 1,2,3 dimensional board
			if (command.matches("[Mm]")) {
				System.out.println("mark");
				System.out.println(" enter x:");
				int x = scanner.nextInt();
				System.out.println(" enter y:");
				int y = scanner.nextInt();
				IntegerCoordinate coord = new IntegerCoordinate(x - 1, y - 1);
				move = new Mark(game, coord);
			} else if (command.matches("[Pp]")) {
				System.out.println("probe");
				System.out.println(" enter x:");
				int x = scanner.nextInt();
				System.out.println(" enter y:");
				int y = scanner.nextInt();
				IntegerCoordinate coord = new IntegerCoordinate(x - 1, y - 1);
				move = new Probe(game, coord);
			} else if (command.matches("[Dd]")) {
				move = new Done(game);
			} else {
				System.out.println("input error - try again.");
			}
		}
		return move;
	}

}
