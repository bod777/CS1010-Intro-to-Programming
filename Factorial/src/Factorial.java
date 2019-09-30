import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		System.out.print("Enter a number:");
		int number = inputScanner.nextInt();
		inputScanner.close();
//		int factorial = computeFactorial(number);
	//	System.out.print("The factorial of "+number+" is "+factorial);
		if (isFactorian(number))
		{
			System.out.println("The number "+number+" is a factorian number.");
		}
		else
		{
			System.out.println("The number "+number+" is not a factorian number.");
		}
	}
	public static int computeFactorial(int number)
	{
		int result = 1;
		int count = 2;
		while (count<=number)
		{
			result = result*count;
			count++;
		}
		return result;
	}
	public static boolean isFactorian(int number)
	{
		int testNumber = number;
		int result = 0;
		while (number>0)
		{
			int digitI = number%10;
			result += computeFactorial(digitI);
			number/=10;
		}
		return (testNumber==result);
	}
}
