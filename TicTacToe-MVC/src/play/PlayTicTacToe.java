package play;

import tictactoe.Controller;
import tictactoe.Model;
import tictactoe.View;

public class PlayTicTacToe {
	
	public static void main(String args[]) {
		View theView = new View();
		Model theModel = new Model(theView.getSizeToCreateBoard());
		Controller theController = new Controller(theModel, theView);
	}
	
}
