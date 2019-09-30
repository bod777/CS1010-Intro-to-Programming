import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finished=false;
		do
		{
		Scanner input = new Scanner(System.in);
		System.out.print("What number would you like closest Fibonacci number for (or type exit):");
		if (input.hasNextInt())
		{
			int userNumber = input.nextInt();
			double userInput=input.nextDouble();
			int lastNumber = 0;
			int currentNumber=1;
			int nextNumber=0;
			int closestNumber=0;
			boolean answerFound=false;
			if(userNumber<=0) 
			{
				closestNumber=0;
				System.out.println("The closest Fibonacci number to "+userNumber+" is "+closestNumber+".");	
			}
			else if (userNumber==1)
			{
				closestNumber=1;
				System.out.println("The closest Fibonacci number to "+userNumber+" is "+closestNumber+".");
			}
			else
			{
				while (answerFound==false)
				{
					nextNumber=lastNumber+currentNumber;
					lastNumber=currentNumber;
					int lastDifference = Math.abs(userNumber-lastNumber);
					int nextDifference = Math.abs(userNumber-nextNumber);
					double lastDifference1= Math.abs(userInput-lastNumber);
					double nextDifference2= Math.abs(userInput-nextNumber);
					if (lastDifference>=nextDifference)
					{
						closestNumber=nextNumber;
					}
					else if (lastDifference1>=nextDifference2)
					{
						closestNumber=nextNumber;
					}
					else if (lastDifference1<=nextDifference2)
					{
						closestNumber=lastNumber;
						System.out.println("The closest Fibonacci number to "+userNumber+" is "+closestNumber+".");
						answerFound=true;
					}
					else
					{
						closestNumber=lastNumber;
						System.out.println("The closest Fibonacci number to "+userNumber+" is "+closestNumber+".");
						answerFound=true;
					}
					currentNumber=nextNumber;
				}
			}
		}
		else if (input.hasNextDouble())
		{	
			double userInput=input.nextDouble();
			int lastNumber = 0;
			int currentNumber=1;
			int nextNumber=0;
			int closestNumber=0;
			boolean answerFound=false;
			if(userInput<=0) 
			{
				closestNumber=0;
				System.out.println("The closest Fibonacci number to "+userInput+" is "+closestNumber+".");	
			}
			else if (userInput==1)
			{
				closestNumber=1;
				System.out.println("The closest Fibonacci number to "+userInput+" is "+closestNumber+".");
			}
			else
			{
				while (answerFound==false)
				{
					nextNumber=lastNumber+currentNumber;
					lastNumber=currentNumber;
					double lastDifference1= Math.abs(userInput-lastNumber);
					double nextDifference2= Math.abs(userInput-nextNumber);
					if (lastDifference1>=nextDifference2)
					{
						closestNumber=nextNumber;
					}
					else
					{
						closestNumber=lastNumber;
						System.out.println("The closest Fibonacci number to "+userInput+" is "+closestNumber+".");
						answerFound=true;
					}
					currentNumber=nextNumber;
				}
			}
		}
		else if (input.hasNext("exit"))
		{
			System.out.println("Goodbye!");
			finished=true;
		}
		else
		{
			System.out.println("Invalid input.");
		}
		}while(!finished);
	}

}
