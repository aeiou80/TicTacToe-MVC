import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * A class for the GUI view of a Tic Tac Toe game
 * 
 * @author Cameron Davis
 *
 */
public class View extends JFrame {

	JButton board[][] = new JButton[3][3];

	/**
	 * Default constructor. Creates a 3x3 grid layout panel of buttons.
	 */
	public View() {
		this.setTitle("Tic Tac Toe!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3));

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = new JButton("---");
				board[row][col].putClientProperty("row", row);
				board[row][col].putClientProperty("col", col);
				buttonPanel.add(board[row][col]);
			}
		}

		buttonPanel.setPreferredSize(new Dimension(250, 250));

		this.add(buttonPanel);
		this.pack();

		// frame opens in center of monitor
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		this.setVisible(true);
	}

	/**
	 * Adds action listener to all buttons
	 * 
	 * @param ticTacToeListener the action listener
	 */
	public void addTicTacToeListener(ActionListener ticTacToeListener) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				board[row][col].addActionListener(ticTacToeListener);
		}
	}

	public void setButtonText(char c, int row, int col) {
		board[row][col].setText(Character.toString(c));
	}

	/**
	 * Opens a dialog message box with the specified message
	 * 
	 * @param message the message to display
	 */
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
