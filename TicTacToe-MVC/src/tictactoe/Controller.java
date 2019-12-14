package tictactoe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * A class for the controller of a Tic Tac Toe game
 * 
 * @author Cameron Davis
 *
 */
public class Controller {

	private Model theModel;
	private View theView;

	/**
	 * Default constructor
	 * 
	 * @param theModel Tic Tac Toe model
	 * @param theView  Tic Tac Toe view
	 */
	public Controller(Model theModel, View theView) {
		this.theView = theView;
		this.theModel = theModel;
		theView.addTicTacToeListener(new TicTacToeListener());
	}

	class TicTacToeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			int row = (int) btn.getClientProperty("row");
			int col = (int) btn.getClientProperty("col");
			char turn = theModel.getTurn();

			if (theModel.doMove(row, col)) { // true --> successful move
				theView.setButtonText(turn, row, col);
				System.out.println("Player " + turn + " played at row: " + row + ", col: " + col);

				char winner = theModel.findWinner();
				if (winner != '\0') {
					theView.displayMessage("Player " + winner + " has won!");
					System.exit(0);
				}

				if (theModel.isTiedGame()) {
					theView.displayMessage("Draw!");
					System.exit(0);
				}

			} else // false --> bad move
				theView.displayMessage("That space is already taken!");
		}

	}

}
