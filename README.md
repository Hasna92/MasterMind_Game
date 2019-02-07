# MasterMind_Game
This is a very simple text based implementation of the classic Game Mastermind. GUI coming soon! 
All the problem design credit goes to EE422C at the university of Texas at Austin ECE department. 
Very simple project meant to highlight characteristics of Object-Oriented Programming, modular design, and abstraction - So be sure to look 
out for those things!


HOW TO PLAY: 

In this game - you have a set number of guesses to guess a color code. The color code is set by the GameConfiguration class, 
along with the number of guesses a player has, and how long the code is: ie. 4 guesses, 5 guesses, 6 guesses. 

Guesses are case sensitive. Also, a guess of "HISTORY" will show status of current game board, ie: all previous guesses and their feedback.
Feedback returns black and white pegs. 
-The number of black pegs shows how many colors you got right with respect to their position. 
-The number of white pegs shows how many colors you got right in the code but not in the right position.
-ie: secretcode = BPOY
     Guess = BGPR
     gives feedback = 1b_1w
     
     
