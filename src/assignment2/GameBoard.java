package assignment2;

public class GameBoard {
	
	public String [] gameBoard;
	public int guessNum;
	
	public GameBoard(){
		 gameBoard = new String [GameConfiguration.guessNumber];
		 guessNum = 0;
	}
	
	/*
	 * Method updates gameBoard to hold most recent guess and feedback.
	 * @param: String with most recent guess and feedback
	 * @return: none
	 */
	public void addToGameBoard(String feedback) {
		gameBoard[guessNum]=feedback;
		guessNum++;
	}
	
	/*
	 * Method completely clears the current GameBoard.
	 * Should be used whenever a new game is started so a new object does not have to be created.
	 */
	public void clearBoard() {
		for(int i =0; i< gameBoard.length;i++)
			gameBoard[i] = "";
		guessNum = 0;
	}
	
	/*
	 * This method returns the last guess and feedback recorded.
	 * @param:none
	 * @return: last guess and feedback recorded in game.
	 */
	public String returnLastMove() {
		String ret = gameBoard[gameBoard.length-1];
		return ret;
	}
}
