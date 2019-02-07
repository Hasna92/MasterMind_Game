package assignment2;

public class Driver {
	
	public static void main(String [] args) {
		
		boolean testing = false;
		if(args.length != 0)
			if(args[0].equals("1"))
				testing = true;
		Game mainGame = new Game(testing);
		mainGame.startGame();
		mainGame.runGame();
	
	}

}
