package assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

	public Scanner kb;
	
	public UserInterface(Scanner kb) {
		this.kb = kb;
	}
	
	
	/*
	 * This method simply prints the Greeting message at the very beginning of program.
	 */
	public void printGreeting() {
		System.out.println("Welcome to Mastermind.");
		//For complete game experience. not needed for submission but personal sharing. 
		System.out.println(String.format("The code is %d colors long", GameConfiguration.pegNumber));
		System.out.println(String.format("The acceptable guesses include %s", Arrays.toString(GameConfiguration.colors)));
		System.out.println(String.format("You have %d guesses to get it right! Good Luck!", GameConfiguration.guessNumber));
	}
	
	/*
	 * Method asks user if they want to play a new game. 
	 * @Return: returns Y or N after reading user input
	 */
	public String newGame() {
		System.out.println("Do you want to play a new game? (Y/N):");
		String answer  = kb.next();
		return answer;
	}
	
	/*
	 * Method reads and returns input from user for guess.
	 */
	public String getGuess() {
		System.out.println("Enter guess:");
		String guess = kb.next();
		return guess;
	}
	
	/*
	 * Method prints the current GameBoard.
	 * @param: none
	 * @return: none
	 */
	public void printGameBoard(GameBoard gb) {
		int i =0;
		while(i<GameConfiguration.guessNumber && gb.gameBoard[i] != null && !(gb.gameBoard[i].equals(""))) {
			System.out.println(gb.gameBoard[i]);
			i++;
		}		
	}
	
	/*
	 * This method prints how many guesses a user has left.
	 * @param: gameboard to read and see how guesses how many guesses have been made.
	 * @return: none
	 */
	public void guessesLeft(GameBoard gb) {
		System.out.println(String.format("You have %d guess(es) left.", GameConfiguration.guessNumber - gb.guessNum));
	}
}
