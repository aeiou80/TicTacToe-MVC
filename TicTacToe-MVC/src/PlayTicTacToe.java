
public class PlayTicTacToe {
	
	public static void main(String args[]) {
		View theView = new View();
		Model theModel = new Model();
		Controller theController = new Controller(theModel, theView);
	}
	
}
