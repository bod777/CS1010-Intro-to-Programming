/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. 
It asks the user whether he/she would like to play/quit inside a loop. 
If the user decides to play then: 
1. Connect4Grid2DArray is created using the Connect4Grid interface, 
2. the two players are initialised - must specify the type to be ConnectPlayer, and 
3. the game starts. In the game, I ask the user where he/she would like to drop the piece. 
I perform checks by calling methods in the Connect4Grid interface. 
Finally a check is performed to determine a win. 
Comment: This class performs all the things as outlined above
Marks: 35

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: I do define 7 method within the interface.
Marks: 10

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. 
It creates a grid using a 2D array 
Implementation of the method to check whether the column to drop the piece is valid. 
It provides as implementation of the method to check whether the column to drop the piece is full. 
It provides as implementation of the method to drop the piece.  
It provides as implementation of the method to check whether there is a win.
Comment: The class successfully implements all the methods from the interface.
Marks: 25

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: This class has one abstract (isHuman) and one non abstract method (chooseColumn).
Marks: 10

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). 
It provides the Human player functionality.
Comment: 10
Marks: Yes, it does overrides the abstract method.

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). 
It provides AI player functionality. 
Comment: 10
Marks: Yes, it does overrides the abstract method.

Total Marks out of 100: 100

*/
package connect4Game;

import java.util.Scanner;

public class Connect4Game {
	
	public static final String QUIT = "quit";
	public static final String RESTART = "restart";
	public static final String YES = "yes";
	public static final String YELLOW = "yellow";
	public static final String RED = "red";
	public static final String HUMAN = "human";
	public static final String COMPUTER = "computer";
	public static final int NUMBER_OF_ROWS = 6;
	public static final int NUMBER_OF_COLUMNS = 7;
	
	
	public static void main (String[] args) {
		boolean quit = false;
		
		while(!quit) {
			Scanner input1 = new Scanner(System.in);
			System.out.println("\nWould you like to play a game of Connect4 (enter Yes or enter Quit to leave)?");
			if (input1.hasNext(YES)) {
				Scanner input2 = new Scanner(System.in);
				System.out.println("Would you like to play against another human or a computer player (or enter Quit to leave)?");
				if (input2.hasNext(HUMAN)) {
					Scanner input3 = new Scanner(System.in);
					System.out.println("Would you like to use the yellow or red discs (or enter Quit to leave)?");
					if (input3.hasNext(YELLOW)) {
						ConnectPlayer yellowPlayer = new C4HumanPlayer();
						ConnectPlayer redPlayer = new C4HumanPlayer();
						GameLoop(yellowPlayer, redPlayer);
					}
					else if (input3.hasNext(RED)) {
						ConnectPlayer yellowPlayer = new C4HumanPlayer();
						ConnectPlayer redPlayer = new C4HumanPlayer();
						GameLoop(yellowPlayer, redPlayer);
					}
					else if (input3.hasNext(QUIT)) {
						System.out.println("Thank you. Goodbye!");
						quit = true;
					}
					else {
						System.out.println("Invalid input. Please try again.");
					}
				}
				if (input2.hasNext(COMPUTER)) {
					Scanner input3 = new Scanner(System.in);
					System.out.println("Would you like to use the yellow or red discs (or enter Quit to leave)?");
					if (input3.hasNext(YELLOW)) {
						ConnectPlayer yellowPlayer = new C4HumanPlayer();
						ConnectPlayer redPlayer = new C4RandomAIPlayer();
						GameLoop(yellowPlayer, redPlayer);
					}
					else if (input3.hasNext(RED)) {
						ConnectPlayer yellowPlayer = new C4RandomAIPlayer();
						ConnectPlayer redPlayer = new C4HumanPlayer();
						GameLoop(yellowPlayer, redPlayer);
					}
					else if (input3.hasNext(QUIT)) {
						System.out.println("Thank you. Goodbye!");
						quit = true;
					}
					else {
						System.out.println("Invalid input. Please try again.");
					}
				}
				else if (input2.hasNext(QUIT)) {
					System.out.println("Thank you. Goodbye!");
					quit = true;
				}
				else {
					System.out.println("Invalid input. Please try again.");
				}
		//		input2.close();
			}
			else if (input1.hasNext(QUIT)) {
				System.out.println("Thank you. Goodbye!");
				quit = true;
			}
			else {
				System.out.println("Invalid input. Please try again.");
			}
	//		input1.close();
		}		
	}
	public static void GameLoop(ConnectPlayer yellowPlayer, ConnectPlayer redPlayer) {
		Connect4Grid2DArray grid = new Connect4Grid2DArray();
		ConnectPlayer currentPlayer = yellowPlayer;
		boolean finished = false;
		while(!finished) 
		{
			if (currentPlayer.isHuman()) 
			{
				boolean humanLoop=true;
				while(humanLoop) 
				{
					Scanner input4 = new Scanner(System.in);
					System.out.println("\n"+(currentPlayer==redPlayer?"Red Player's Move...":"Yellow Player's Move...")
							+ "\nWhich column (1-7) you like to drop your disc down?"); //(or else enter Restart to restart the game)?");
					if (input4.hasNextInt()) 
					{
						int columnInput = input4.nextInt();
						columnInput = columnInput-1;
						if ((grid.isValidColumn(columnInput))&&(!grid.isColumnFull(columnInput))) 
						{
							grid.dropPiece(currentPlayer, columnInput);
							System.out.println(grid.toString(yellowPlayer, redPlayer));
							
							if (grid.didLastPieceConnect4())
							{
								System.out.println("CONGRATS" + (currentPlayer==redPlayer?" Red Player!":" Yellow "
										+ "Player!") + " YOU GOT 4 IN A ROW");
								finished = true;
							}
							else if (grid.isGridFull()) 
							{
								System.out.println("Grid is full. It is a draw.");
								finished = true;
							}
							currentPlayer=(yellowPlayer==currentPlayer)?redPlayer:yellowPlayer;
							humanLoop=false;
						}
						else 
						{
							System.out.println("Sorry, but this move is not possible. Please try again.");
						}
					}
					else 
					{
						System.out.println("Invalid Input. Please try again.");
					}
				}
			}
			else if (!currentPlayer.isHuman())
			{
				System.out.println("\nNow its the computer's turn.");
				boolean computerLoop = true;
				while(computerLoop) 
				{
					int computerOutput = currentPlayer.chooseColumn();
					if (!grid.isColumnFull(computerOutput)) 
					{
						grid.dropPiece(currentPlayer, computerOutput);
						System.out.println(grid.toString(yellowPlayer, redPlayer));
						if (grid.didLastPieceConnect4())
						{
							System.out.println("Hard Luck. The Computer has gotten 4 IN A ROW.");
							finished = true;
						}
						currentPlayer=(yellowPlayer==currentPlayer)?redPlayer:yellowPlayer;
						computerLoop=false;
					}
				}
			}
			if (grid.isGridFull()) 
			{
				System.out.println("Grid is full. It is a draw.");
				finished=true;
			}
		}
	}
}