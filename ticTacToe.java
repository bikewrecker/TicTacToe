import java.util.*;
public class ticTacToe{

	public static void main(String[] args) {
		Board gameBoard = new Board();
		displayGreeting();
		gameBoard.displayboard();
		playGame(gameBoard);
	}//main()

	public static void displayGreeting() {
		System.out.println();
		System.out.println("Welcome to ticTacToe!");
		System.out.println("Make moves by typing the coordinates of the position you want to go.");
		System.out.println("Type coordinates in the form `row column'. i.e. `1 1' for the middle position");
	}//displayGreeting

	public static void playGame(Board gameBoard) {
		boolean player1 = false;
		boolean player2 = true;
		int gameOver = 0;
		int r = 0;
		int c = 0;
		Scanner reader;
		boolean currentPlayer = player1;
		while(gameOver != 1) {
			reader = new Scanner(System.in);
			if(currentPlayer == player1){
				System.out.println("Enter a move for Player1: ");
			} else {
				System.out.println("Enter a move for Player2: ");
			}
			r = reader.nextInt();
			c = reader.nextInt();
			gameOver = gameBoard.makeMove(r,c, currentPlayer);
			if(gameOver != -1) {
				if(currentPlayer == player1) {
					currentPlayer = player2;
				} else {
					currentPlayer = player1;
				}
			}
		}
	}//playGame()
}//ticTacToe

