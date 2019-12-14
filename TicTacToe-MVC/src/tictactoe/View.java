package tictactoe;

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
	
	private JButton board[][];
	private int size;

	/**
	 * Default constructor. Creates a 3x3 grid layout panel of buttons.
	 */
	public View() {
		this.setTitle("Tic Tac Toe!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	/**
	 * Creates a Tic Tac Toe board via a grid of JButtons
	 * 
	 * @param size the squared dimensions of the board
	 */
	private void createBoard(int size) {
		this.size = size;
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(size, size));
		
		board = new JButton[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				board[row][col] = new JButton("---");
				board[row][col].putClientProperty("row", row);
				board[row][col].putClientProperty("col", col);
				buttonPanel.add(board[row][col]);
			}
		}

		buttonPanel.setPreferredSize(new Dimension(300, 300));
		this.add(buttonPanel);
		this.pack();

		// makes window initially open in center of monitor
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		this.setVisible(true);
	}
	
	/**
	 * Gets board size from user via input box
	 * 
	 * @return integer of the board size
	 */
	public int getSizeToCreateBoard() {
		String inputSize;
		while (true) {
			inputSize = JOptionPane.showInputDialog("Please enter the size of the Tic Tac Toe board");
			if (inputSize.matches("[0-9]+")) 
				break;
		}
		
		createBoard(Integer.parseInt(inputSize));
		return Integer.parseInt(inputSize);
	}

	/**
	 * Add a Tic Tac Toe listener to all buttons on the board
	 * 
	 * @param ticTacToeListener the action listener
	 */
	public void addTicTacToeListener(ActionListener ticTacToeListener) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++)
				board[row][col].addActionListener(ticTacToeListener);
		}
	}
	
	/**
	 * Change the text of a button on the board
	 * 
	 * @param c	a character
	 * @param row
	 * @param col
	 */
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
