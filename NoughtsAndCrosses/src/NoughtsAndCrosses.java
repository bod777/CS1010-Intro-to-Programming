import java.util.Scanner;

/* SELF ASSESSMENT 
   1. clearBoard:
Did I use the correct method definition?
	Mark out of 5:5	Comment:I used the correct char[][] parameter for the definition.
Did I use loops to set each position to the BLANK character?
	Mark out of 5:5	Comment:Yes, I did use a loop.
   2. printBoard
Did I use the correct method definition?
	Mark out of 5:5	Comment:I used the correct definition with a char[][] parameter.
Did I loop through the array and prints out the board in a way that it looked like a board?
	Mark out of 5:5 Comment:Yes, I did print the array correctly in a board.
   3. canMakeMove
Did I have the correct function definition and returned the correct item?
	Mark out of 5:5	Comment:Yes, i did use the correct function definition and it correctly returned a boolean.
Did I check if a specified location was BLANK?
	Mark out of 5:5	Comment:Yes, I did check for that, as well as if the input numbers are within the array.
   4. makeMove
Did I have the correct function definition?
	Mark out of 5:5	Comment:Yes, I used the correct function definition.
Did I set the currentPlayerPiece in the specified location?
	Mark out of 5:5	Comment: Yes the function worked the way it was suppose to.
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
	Mark out of 5:5	Comment: Yes, I used the correct definition and a boolean return.
Did I loop through the board to check if there are any BLANK characters?
	Mark out of 5:5	Comment:Yes, I did use a loop.
   6. winner
Did I have the correct function definition and returned the winning character
	Mark out of 5:5	Comment: I used the correct definition which returned the winner 
Did I identify all possible horizontal, vertical and diagonal winners  
	Mark out of 15:15	Comment:Yes, it identified all possible winners.
   7.main
Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
	Mark out of 3:3	Comments:Yes, I create a 3x3 array and set it all to ' '.
Did I loop asking the user for a location until wither the board was full or there was a winner?
	Mark out of 5:5	Comments:I did use a loop.
Did I call all of the methods above?
	Mark out of 5:5	Comments:I called all the above methods
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
	Mark out of 3:	Comments:I used if statements for error-handling.
Did I switch the current player piece from cross to nought and vice versa after every valid move?
	Mark out of 3:3	Comments:yes, the pieces do switch every loop.
Did I display the winning player piece or a draw at the end of the game?
	Mark out of 3:3	Comments:It does display the winner or that it was a stalemate.
   8. Overall
Is my code indented correctly?
	Mark out of 3:3	Comments:I did indent my code correctly.
Do my variable names and Constants (at least four of them) make sense?
	Mark out of 3:3	Comments:Yes, I 
Do my variable names, method names and class name follow the Java coding standard
	Mark out of 2:2	Comments:The code follows the java coding standard.
      Total Mark out of 100 (Add all the previous marks): 100
*/
public class NoughtsAndCrosses 
{
	public static final int NUMBER_OF_ROWS = 3;
	public static final int NUMBER_OF_COLUMNS = 3;
	public static final char CLEAR_SPACE = ' ';
	public static final char X = 'X';
	public static final char O = 'O';
	public static void main(String[] args) 
	{
		boolean loop = true;
		while (loop)
		{
			System.out.println(" New Game");
			char[][] board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
			clearBoard(board);
			printBoard(board);
			char currentPlayerPiece=X;
			boolean finished = false;
			do
			{
				Scanner input= new Scanner(System.in);
				System.out.print((currentPlayerPiece=='X')?"\nCrosses turn":"\nNoughts turn");
				System.out.print("\nEnter the position (row column) you want to place your mark>");
				if (input.hasNextInt())
				{
					int row = input.nextInt()-1;
					int column=input.nextInt()-1;
					if (canMakeMove(board, row, column))
					{
						makeMove(board, currentPlayerPiece, row, column);
						currentPlayerPiece=(currentPlayerPiece==X)?O:X;
					}
					else
					{
						System.out.print("Invalid format. Please try again.");
					}
				}
				else
				{
					System.out.print("Invalid format. Please try again");
				}
				if (isBoardFull(board)||winner(board)==X||winner(board)==O)
				{
					finished=true;
				}
			} while (!finished);
			if (isBoardFull(board))
			{
				System.out.println("\nThe board is full.");
			}
			if (winner(board)==X||winner(board)==O)
			{
				System.out.println("\n Congrats! The winner is "+winner(board)+"!");
			}
			else
			{
				System.out.println("Stalemate. There is no winner.");
			}
		}
	}
	public static void clearBoard(char[][] board)
	{
		for (int row = 0; (row < board.length); row++)
		{
			for (int column = 0; (column < board[row].length); column++)
			{
				board[row][column] = CLEAR_SPACE;
			}
		}	
	}
	public static void printBoard (char[][] board)
	{
		for (int count = 0; (count < 7); count++)
		{
			System.out.print("\n");
			System.out.print("|");
			if (count==1||count==3||count==5)
			{
				for (int column = 0; (column < 3); column++)
				{
						System.out.print(" "+board[count/2][column]+" |");
				}
			}
			else
			{
				System.out.print("---|---|---|");
			}
		}
	}
	public static boolean canMakeMove(char[][] board, int row, int column)
	{
		if (row>=0&&row<3&&column>=0&&column<3)
		{
			if (board[row][column]==CLEAR_SPACE) 
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public static void makeMove (char[][] board, char currentPlayerPiece, int row, int column)
	{
		board[row][column]=currentPlayerPiece;
		printBoard(board);
	}
	public static boolean isBoardFull(char[][] board)
	{
		int spacesFull = 0;
		for (int row = 0; (row < 3); row++)
		{
			for (int column = 0; (column < 3); column++)
			{
				if (board[row][column] == X||board[row][column]==O)
				{
					spacesFull++;
				}
			}
		}	
		if (spacesFull>=9)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static char winner (char[][] board)
	{
		char winner='!';
		for (int row = 0; (row < board.length); row++)
		{
			if (board[row][0]==board[row][1]&&board[row][0]==board[row][2])
			{
				winner = board[row][1];
			}
		}
		for (int column = 0; (column < board.length); column++)
		{
			if (board[0][column]==board[1][column]&&board[0][column]==board[2][column])
			{
				winner = board[1][column];
			}
		}	
		char centrePiece = board[1][1];
		if ((centrePiece==board[0][0]&&centrePiece==board[2][2])||(centrePiece==board[0][2]&&centrePiece==board[2][0]))
		{
			winner = centrePiece;
		}
		return winner;
	}
}