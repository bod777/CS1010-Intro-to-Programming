import java.util.Scanner;
public class WholeSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finished=false;
		System.out.println("This Java program displays all whole numbers whose squares are less than or equal to a user supplied limit.");
		do
		{
			int unsquaredNumber=0;
			int squaredNumber = 0;
			Scanner input = new Scanner(System.in);
			
			System.out.print("\nEnter a whole number you wish to see the squares less than or equal to (or type exit):");
			if (input.hasNextInt())
			{
				
				int maximumNumber = input.nextInt();
				if (maximumNumber>=0)
				{
					System.out.print("The numbers whose squares are less than or equal to "+maximumNumber+" are 0");
					while (maximumNumber>=squaredNumber)
					{
						unsquaredNumber++;
						squaredNumber=unsquaredNumber*unsquaredNumber;
						if (squaredNumber<maximumNumber)
						{
							System.out.print(", "+unsquaredNumber);
						}
					}
				System.out.print(".");
				}
				else if (maximumNumber<0)
				{
					System.out.print("A squared number cannot be negative, please enter a valid input.");
				}
			}
			else if (input.hasNext("exit"))
			{
				System.out.println("Goodbye");
				finished=true;
			}
			else
			{
				System.out.print("Invalid input.");
			}
		}while(!finished);
	}
}
	
