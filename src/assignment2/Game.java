package assignment2;

import java.util.Scanner;

public class Game {
	
	public UserInterface gameUserInteraction;
	public final Scanner keyboard;
	public boolean testMode;
	
	/*
	 * Game Object Constructor - creates one Keyboard scanner and passes it (pass by reference)
	 * Maintains one object created
	 */
	public Game(boolean testMode) {
		keyboard = new Scanner(System.in);
		this.testMode = testMode;
		gameUserInteraction = new UserInterface(keyboard);
	}
	
	/*
	 * This method starts the program. Will be the first thing called, and just print greeting. 
	 */
	public void startGame() {
		gameUserInteraction.printGreeting();
	}
	
	/*
	 * This method is the main engine to run the game. 
	 * It repeats this action until user says N to new game prompt. 
	 */
	public void runGame() {
		//Ask user if they want to play new game, if not quit
		GameBoard board = new GameBoard();
		while(gameUserInteraction.newGame().toUpperCase().equals("Y")) {
			board.clearBoard();
			String code = SecretCodeGenerator.getInstance().getNewSecretCode();
			boolean gameWon = false;
			//Test to see if testMode == true
			if(testMode == true)
				System.out.println(String.format("Secret code: %s", code));
				
			//loop for actual game until they lose, or win
			while(board.guessNum < GameConfiguration.guessNumber && gameWon == false) {
				System.out.println();
				gameUserInteraction.guessesLeft(board);
				String guess = gameUserInteraction.getGuess();
				//check guess for history
				if(guess.equals("HISTORY")) {
					gameUserInteraction.printGameBoard(board);
					continue;
				}
				String feedback = FeedBack.getOutput(guess, code);
				//check for invalid guess
				if(feedback.equals("INVALID_GUESS")) {
					System.out.println("INVALID_GUESS");
					continue;
				}
				//if valid, add to game board, check for win, if no win continue loop
				board.addToGameBoard(feedback);
				System.out.println(feedback);
				if(feedback.contains(String.format("%db", GameConfiguration.pegNumber))){
					System.out.println("You win!");
					System.out.println();
					gameWon = true;
				}
			}
			if(gameWon==true)
				continue; //outerloop
			//otherwise it means gameboard filled up with no win, so print lose message
			//continue outer loop
			System.out.println(String.format("You lose! The pattern was %s",code));	
			System.out.println();
		}
	
	}
	
} 
