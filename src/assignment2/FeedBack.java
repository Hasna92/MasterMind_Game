package assignment2;
import java.util.Arrays;
 

public class FeedBack {
	
	/*
	 * Method Checks to see if entered input is valid.
	 * @input: User-entered guess
	 * @Return: if valid guess return valid guess with feedback generated
	 * @Return: if invalid returns "INVALID GUESS"
	 */
	public static String getOutput(String guess, String code) {
		String result = "";
		String colors = Arrays.toString(GameConfiguration.colors);
		String [] guessArr = guess.split("");
		String [] codeArr = code.split("");
		int blackPegs=0;
		int whitePegs=0;
		
		//Check to see if Invalid Guess
		if(guess.length() != GameConfiguration.pegNumber)
			return "INVALID_GUESS";
		for(int i =0; i< guessArr.length; i++) {
			if(!(colors.contains(guessArr[i])))
				return "INVALID_GUESS";	
		}
		
		//If guess is valid, calculates feedback and returns it with guess
		for(int i =0; i<codeArr.length;i++) {
			if(guessArr[i].equals(codeArr[i])) {
				blackPegs++;
				guessArr[i]="-";
				code = code.substring(0, i) + "-" + code.substring(i+1, code.length());
			}
		}
		for(int i=0; i<codeArr.length;i++) {
			if(!(guessArr[i].equals("-")))
				if(code.contains(guessArr[i]))
					whitePegs++;
		}
		
		
		result += String.format("%s -> %db_%dw", guess,blackPegs, whitePegs);
		
		return result;
		
	}
	
}
