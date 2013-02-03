package edu.virginia.cs.cs4501.dgm3df;

public class Connect4 {

	public static void main(String[] args) {
		int state = 0;

		cli Cli = new cli();
		while (state != -1) {// checks if program is in quitting stage
			switch (state) {
			case 0:
				Cli.runtime();
				if (Cli.getHasWon()) {
					state = 1;
				} else if (Cli.getHasDraw()) {
					state = 2;
				}
				break;
			case 1:// prints endgame with winner
				Cli.showWin();
				if (Cli.getQuit()) {
					state = -1;
				} else if (Cli.getNewGame()) {
					Cli = new cli();
					state = 0;
				}
				break;
			case 2:// prints end game eith draw game
				Cli.showDraw();
				if (Cli.getQuit()) {
					state = -1;
				} else if (Cli.getNewGame()) {
					Cli = new cli();
					state = 0;
				}
				break;
			}
		}

	}
}