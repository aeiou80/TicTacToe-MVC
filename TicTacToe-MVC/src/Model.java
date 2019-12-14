
/**
 * A class for the model of a Tic Tac Toe board
 * 
 * @author Cameron Davis
 *
 */
public class Model {

	private char board[][];
	private char turn;

	/**
	 * Initializes a 3x3 Tic Tac Toe board and 'X' goes first
	 */
	public Model() {
		board = new char[3][3];
		turn = 'X';
	}

	/**
	 * Initialize a Tic Tac Toe board and choose who goes first
	 * 
	 * @param startingTurn 'X' or 'O'
	 */
	public Model(char startingTurn) {
		board = new char[3][3];
		this.turn = startingTurn;
	}

	/**
	 * Places a char of the current turn at the specified row and column
	 * 
	 * @param row
	 * @param col
	 * @return true if placement was successful, false if the space was already
	 *         taken
	 */
	public boolean doMove(int row, int col) {
		if (board[row][col] == '\0') {
			board[row][col] = turn;
			turn = (turn == 'X' ? 'O' : 'X');
			return true;
		}
		return false;
	}

	/**
	 * Scans the board for a potential winner and returns it if found
	 * 
	 * @return char of the winner or null char if no winner found
	 */
	public char findWinner() {

		// check horizontals
		char winner;
		for (int row = 0; row < board.length; row++) {
			winner = board[row][0];
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] != winner) {
					winner = '\0';
					break;
				}
			}
			if (winner != '\0')
				return winner;
		}

		// check verticals
		for (int col = 0; col < board.length; col++) {
			winner = board[0][col];
			for (int row = 0; row < board.length; row++) {
				if (board[row][col] != winner) {
					winner = '\0';
					break;
				}
			}
			if (winner != '\0')
				return winner;
		}

		// check left-to-right diagonal
		winner = board[0][0];
		for (int row = 0; row < board.length; row++) {
			if (board[row][row] != winner) {
				winner = '\0';
				break;
			}
		}
		if (winner != '\0')
			return winner;

		// check right-to-left diagonal
		winner = board[0][board.length - 1];
		for (int row = 0; row < board.length; row++) {
			if (board[row][(board.length - 1) - row] != winner) {
				winner = '\0';
				break;
			}
		}
		if (winner != '\0')
			return winner;

		return '\0';
	}

	/**
	 * Scans the board for a tied game
	 * 
	 * @return true if tied, false otherwise
	 */
	public boolean isTiedGame() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == '\0')
					return false;
			}
		}

		return true;
	}

	public char getTurn() {
		return this.turn;
	}

}
