public class Board {
	// Board class. Contains all the relevant methods to operate game
	private Cell[][] cells;
	private static final boolean player1 = false;// 'X'
	private static final boolean player2 = true;// 'O'
	private static final int maxMoves = 9;
	private int numMovesMade;

	public Board() {
		//Constructer. Builds board.
		cells = new Cell[3][3];
		numMovesMade = 0;
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells[0].length; j++) {
				cells[i][j] = new Cell();
			}
		}
	}

	public void displayboard() {
		//Displays board. Wraps every cell in brackets
		System.out.println();	
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells.length; j++) {
				System.out.print("[" + cells[i][j].getValue() + "]");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int makeMove(int r, int c, boolean player) {
		//Verifies move is valid, if so it updates and displays the board to reflect the new move.
		//Then it checks if the game is over via one player winning or a cat's game
		//Return values:
		// 0 => ok
		// -1 => error
		// 1 => game over
		int result = 0;
		if(r > 2 || r < 0 || c > 2 || c < 0) {
			System.out.println("Error: Invalid placement");
			this.displayboard();
			result = -1;
		} else if(cells[r][c].getValue() != ' ') {
			System.out.println("Error: Position aready marked");
			this.displayboard();
			result = -1;
		} else {
			if(player == player1) {
				cells[r][c].setValue('X');
			} else {
				cells[r][c].setValue('O');
			}
			numMovesMade++;
			this.displayboard();

			if(this.checkForWinner(player)) {
				if(player == player1){
					System.out.println("Player1 Won!!!");
				} else {
					System.out.println("Player2 Won!!!");
				}
				result = 1;
			} else {
				if(numMovesMade == maxMoves) {
					System.out.println("Cat's Game!!!");
					result = 1;
				}
			}

		}
		return result;
	}

	public boolean checkForWinner(boolean player) {
		//checks to see if given player has won the game. 
		//Note. If we wanted to expand this game to another dimension, say 4x4, this code would need to be completely refactored. 
			//In this case we might want to restructure cells with references to their neighbor cells in order to more efficently check if given player has won. 
		char value;
		boolean output = false;
		if(player == player1) {
			value = 'X';
		} else {
			value = 'O';
		}
		//check if won by row or column;
		for(int i = 0; i < cells.length; i++) {
			if(cells[i][0].getValue() == value && cells[i][1].getValue() == value && cells[i][2].getValue() == value) {
				output = true;
			}//check rows
			if(cells[0][i].getValue() == value && cells[1][i].getValue() == value && cells[2][i].getValue() == value) {
				output = true;
			}//check columns
		}
		//check if won by diagonal
		if(cells[1][1].getValue() == value){
			if(cells[0][0].getValue() == value && cells[2][2].getValue() == value) {
				output = true;
			}

			if(cells[0][2].getValue() == value && cells[2][0].getValue() == value) {
				output = true;
			}
		}
		return output;
	}
}