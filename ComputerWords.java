
import java.util.Arrays;
import java.util.List;

public class ComputerWords{
	//data members
	private String playerOneWord;//Input from P1
	private String playerTwoWord;//Input from P2
	private String messagePlayerOne;//output score or invalid word for P1
	private String messagePlayerTwo;//output score ro invalid word for P2
	private StringBuffer bufferPlayerOne;
	private StringBuffer bufferPlayerTwo;
	private String validLettersPlayerOne;
	private String validLettersPlayerTwo;
	private int playerOneScore;//Score for P1
	private int playerTwoScore;//Score for P2
	private String[] wordsArray;//Stores the set of valid words
	private List<String> wordsList;//will transfer the words array to a list for validation
	private char[] alphabetCharArray;//stores the 26 letter of the english alphabet
	private char[] randomLetters;//Will store a set of 12 tandom letters the player can use
	private String letters;//will store the random letter in a string


	//constructor
	public ComputerWords(){
		playerOneWord = new String();
		playerTwoWord = new String();
		messagePlayerOne = new String();
		messagePlayerTwo = new String();
		bufferPlayerOne = new StringBuffer();
		bufferPlayerTwo = new StringBuffer();
		validLettersPlayerOne = new String();
		validLettersPlayerTwo = new String();
		playerOneScore = 0;
		playerTwoScore = 0;
		wordsArray = new String[] {"algorithm", "application", "backup", "bit", "buffer", "bandwidth",
								   "broadband", "bug", "binary", "browser", "bus", "cache", "command",
								   "computer", "cookie", "compiler", "cyberspace", "compress", "configure",
								   "database", "digital", "data", "debug", "desktop", "disk", "domain",
								   "decompress", "development", "download", "dynamic", "email", "encryption",
								   "firewall", "flowchart", "file", "folder", "graphics", "hyperlink",
								   "host", "hardware", "icon", "inbox", "internet", "kernel", "keyword",
								   "keyboard", "laptop", "login", "logic", "malware", "motherboard", "mouse",
								   "mainframe", "memory", "monitor", "multimedia", "network", "node",
								   "offline", "online", "path", "process", "protocol", "password",
								   "phishing", "platform", "program", "portal", "privacy", "programmer",
								   "queue", "resolution", "root", "restore", "router", "reboot", "runtime",
								   "screen", "security", "shell", "snapshot", "spam", "screenshot", "server",
								   "script", "software", "spreadsheet", "storage", "syntax", "table",
								   "template", "thread", "terminal", "username", "virtual", "virus", "web",
								   "website", "window", "wireless"};
		alphabetCharArray = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
										'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		randomLetters = new char[12]; //{'i', 'b', 'w', 'a', 'e', 'f', 'g', 'r', 't', 'j', 's', 'o'};//Uncomment previous comment for testing words "bit" and "software"
		wordsList = Arrays.asList(wordsArray);//This variable transforms the array of computer words to a list

	}

	//set methods >> one for every input
	public void setPlayerOneWord (String playerOneWord){
		this.playerOneWord = playerOneWord;
	}

	public void setPlayerTwoWord (String playerTwoWord){
		this.playerTwoWord = playerTwoWord;
	}


	//compute methods
	public void computeLetters(){//this method generates a different set of random letters per round in the main app

		//this block of code uses a loop to store 12 random letters in a char array and save them in a String to prompt the players
		for (int i = 0; i < 12; i++) {
			randomLetters[i] = alphabetCharArray[(int) (Math.random() * alphabetCharArray.length)];
		}
		letters = String.valueOf(randomLetters);
	}

	public void compute(){//this method will validate the input from the players and that every letter from random set is used

		//PLAYER ONE: this section will validate player One input against the list of words
		if(wordsList.contains(playerOneWord)) {;

			//this loop validates the input from the user versus the given words

			char [] playerOneRandomLetters = Arrays.copyOf(randomLetters, randomLetters.length);
			bufferPlayerOne = new StringBuffer();
			for(int i = 0; i < playerOneWord.length(); i++){
				for (int j = 0; j < playerOneRandomLetters.length; j++){
					if(playerOneWord.charAt(i) == playerOneRandomLetters[j]){
						bufferPlayerOne.append(playerOneRandomLetters[j]);
						playerOneRandomLetters[j] = '*';//this condition will replace the char from the array with the random letters to make sure they are used only once
						break;
					}//end if statement
				}//end loop j
			}//end loop i

			//this block will compare the two string and return a score if the giben words were used by the user
			validLettersPlayerOne = bufferPlayerOne.toString();

			if (validLettersPlayerOne.equals(playerOneWord)){
				playerOneScore = playerOneWord.length();
				for(int i = 0; i < playerOneWord.length(); i++){
					if(playerOneWord.charAt(i) == 'i' || playerOneWord.charAt(i) == 'u' || playerOneWord.charAt(i) == 's'){
						playerOneScore = playerOneScore - 1;
					}
				}
				messagePlayerOne = "Player One: Valid word!"
									+ "\nWord: " + playerOneWord
									+ "\nPoints : " + playerOneScore;
			} else {
				messagePlayerOne = "Player One: Sorry, you did not use the letters given";
				playerOneScore = 0;
			}//end of if statement that validates the letters


		} else {
			messagePlayerOne = ("Sorry Player One, your word: " + playerOneWord + ", is Invalid, no points :( ");
			playerOneScore = 0;

		}//end of player one input against the list of words



		//PLAYER TWO: this section will validate player two input against the list of words
		if(wordsList.contains(playerTwoWord)) {

			//this loop validates the input from the user versus the given words

			char [] playerTwoRandomLetters = Arrays.copyOf(randomLetters, randomLetters.length);
			bufferPlayerTwo = new StringBuffer();
			for(int i = 0; i < playerTwoWord.length(); i++){
				for (int j = 0; j < playerTwoRandomLetters.length; j++){
					if(playerTwoWord.charAt(i) == playerTwoRandomLetters[j]){
						bufferPlayerTwo.append(playerTwoRandomLetters[j]);
						playerTwoRandomLetters[j] = '*';
						break;
					}//end if statement
				}//end loop j
			}//end loop i

			//this block will compare the two string and return a score if the giben words were used by the user
			validLettersPlayerTwo = bufferPlayerTwo.toString();

			if (validLettersPlayerTwo.equals(playerTwoWord)){
				playerTwoScore = playerTwoWord.length();
				for(int i = 0; i < playerTwoWord.length(); i++){
					if(playerTwoWord.charAt(i) == 'i' || playerTwoWord.charAt(i) == 'u' || playerTwoWord.charAt(i) == 's'){
						playerTwoScore = playerTwoScore - 1;
					}
				}
				messagePlayerTwo = "Player Two: Valid word!"
									+ "\nWord: " + playerTwoWord
									+ "\nPoints : " + playerTwoScore;
			} else {
				messagePlayerTwo = "Player Two: Sorry, you did not use the letters given";
				playerTwoScore = 0;
			}//end of if statement that validates the letters


		} else {
			messagePlayerTwo = ("Sorry Player Two, your word: " + playerTwoWord + ", is Invalid, no points :( ");
			playerTwoScore = 0;
		}//end of player two input against the list of words

	}//end of compute method

	//get methods
	public String getLetters(){
		return letters;
	}

	public String getMessagePlayerOne(){
		return messagePlayerOne;
	}

	public String getMessagePlayerTwo(){
		return messagePlayerTwo;
	}

	public int getPlayerOneScore(){
		return playerOneScore;
	}

	public int getPlayerTwoScore(){
		return playerTwoScore;
	}




}