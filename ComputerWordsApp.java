import javax.swing.JOptionPane;

public class ComputerWordsApp{
	public static void main (String[] args){
		//variables
		String playerOneWord;//Input from P1
		String playerTwoWord;//Input from P2
		String letters;
		String messagePlayerOne;
		String messagePlayerTwo;
		int playerOneScore;
		int playerTwoScore;
		int playerOneTotalScore = 0;
		int playerTwoTotalScore = 0;
		int roundNum = 0;

		//declare and create objets
		ComputerWords myGame = new ComputerWords();

		//////input & process//////

		//Welcome message and rules
		JOptionPane.showMessageDialog(null, "FIND COMPUTER WORDS GAME!"
                                      + "\n"
                                      + "\n"
                                      + "\nInstructions:"
                                      + "\n1. Select the number of rounds you want to play. Numbers only."
                                      + "\n2. A message with 12 randonmly generated letters will appear every round."
                                      + "\n3. Each player has to type one computer-related word created with the letters. Note that both players' words can not be the same "
                                      + "\n4. The players can use the same letter only the number of times it appears."
                                      + "\n5. The player with the highest score is the winner."
                                      + "\n"
                                      + "\n"
                                      + "Scoring:"
                                      + "\nEach player receives the same"
                                      + " amount of points as the number of"
                                      + " characters in the word excluding the"
                                      + " letters ‘i’, ‘u’ and ‘s’.");

		//This section prompts the user to set the number of rounds to play and validates that only numbers are entered through a do while loop and try and catch
		 boolean isInt = false;//Here we set the condition to begin the loop
		 do{

			 try{
				 roundNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of rounds you want to play. Only numbers"));
				 //System.out.println("Valid input");
				 isInt = true;//if the result is an integer, return true to get out of the loop and continue the game
			 }catch (NumberFormatException ex) {
				 JOptionPane.showMessageDialog(null, "Please make sure you use numbers only");
			 }

		} while (isInt == false);//End of do while loop that validates only numbers are entered for the number of rounds

		//Rounds Loop: this loop will run the code as many times as the user wants
		for(int i = 0; i < roundNum; i++) {

			//prompt random words here, create a compute random letters method to call the computeLetters method and get different random letters for each round
			myGame.computeLetters();
			letters = myGame.getLetters();//this method allow us to display the random letters to the users in the form of a String
			JOptionPane.showMessageDialog(null, "Round " + (i + 1)
										  + "\n"
										  + "\nLetters: " + letters.toUpperCase());//toUpperCase will display the set of random letters in upper case

			//input validation: player one and player two loop until they type diferent words
			do{
				playerOneWord = JOptionPane.showInputDialog("Player one, enter your guess");
				playerTwoWord = JOptionPane.showInputDialog("Player two, enter your guess");
					if(playerOneWord.equalsIgnoreCase(playerTwoWord)){
						JOptionPane.showMessageDialog(null, "Both players words are equal. Try again choosing different words");
					}
			}
			while (playerOneWord.equalsIgnoreCase(playerTwoWord));//end of do while loop that validates repeated words

			//call my methods

			myGame.setPlayerOneWord(playerOneWord.toLowerCase());
			myGame.setPlayerTwoWord(playerTwoWord.toLowerCase());
			myGame.compute();
			messagePlayerOne = myGame.getMessagePlayerOne();
			messagePlayerTwo = myGame.getMessagePlayerTwo();
			playerOneScore = myGame.getPlayerOneScore();
			playerTwoScore = myGame.getPlayerTwoScore();

			//output, one for each player and round
			JOptionPane.showMessageDialog(null, messagePlayerOne);
			JOptionPane.showMessageDialog(null, messagePlayerTwo);
			JOptionPane.showMessageDialog(null, "Round " + (i + 1) + " results"
										  + "\n"
										  + "\nPlayer One: " + playerOneScore + " points"
										  + "\nPlayer Two: " + playerTwoScore + " points");

			playerOneTotalScore = playerOneTotalScore + playerOneScore;
			playerTwoTotalScore = playerTwoTotalScore + playerTwoScore;


		}//end of rounds loop

		/////output/////
		//This section will use if statements select the user with the highest score as the winner and prompt a message with the final results

		if(playerOneTotalScore > playerTwoTotalScore){
			JOptionPane.showMessageDialog(null, "The winner is Player One!!!!");
		} else if (playerOneTotalScore < playerTwoTotalScore){
			JOptionPane.showMessageDialog(null, "The winner is Player Two!!!!");
		} else {
			JOptionPane.showMessageDialog(null, "Draw Game!");
		}

		JOptionPane.showMessageDialog(null, "Final Results!"
									  + "\n"
									  + "\nPlayer One: " + playerOneTotalScore + " points"
									  + "\nPlayer Two: " + playerTwoTotalScore + " points");


	}
}