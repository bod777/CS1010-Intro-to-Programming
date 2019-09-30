
/* SELF ASSESSMENT 
   1. createSequence:
Did I use the correct method definition?
	Mark out of 5: 5 Comment:Yes, the method returned an int 2D array and its parameters were the positive int N.
Did I create an array of size n (passed as the parameter) and initialise it?
	Mark out of 5: 5 Comment: I did create an array of size n and initialised.
Did I return the correct item?
	Mark out of 5:5 Comment:The method did return an array.
   2. crossOutMultiples
Did I use the correct method definition?
	Mark out of 5:5 Comment:Yes, I used the correct method definition.
Did I ensure the parameters are not null and one of them is a valid index into the array
	Mark out of 2:2 Comment: Yes, I did
Did I loop through the array using the correct multiple?
	Mark out of 5:5 Comment:I did loop through the array using a correct multiple.
Did I cross out correct items in the array that were not already crossed out?
	Mark out of 3:3 Comment: Yes, the array was updated each time.
   3. sieve   
Did I have the correct function definition?
	Mark out of 5:5 Comment:Yes, it does have the correct function definition.
Did I make calls to other methods?
	Mark out of 5:5 Comment:Yes it made calls to every single other method.
Did I return an array with all non-prime numbers are crossed out?
	Mark out of 2:2 Comment: Yes, I did return an array with all the non-prime numbers closed out.
   4. sequenceTostring  
Did I have the correct function definition?
	Mark out of 5: 5 Comment:Yes, it does have the correct function definition.
Did I ensure the parameter to be used is not null?
	Mark out of 3:3 comment: By using the createSequence method, none of the arrays are null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
	Mark out of 10: 10 Comment: I did use a loop to update the String variable.
   5. nonCrossedOutSubseqToString  
Did I have the correct function definition
	Mark out of 5:5 Comment: Yes, it does have the correct function definition.
Did I ensure the parameter to be used is not null?  
	Mark out of 3:3 Comment:By using the createSequence method, none of the arrays are null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
	Mark out of 5:5 Comment: Yes, I did use a loop to update the String variable.
   6. main  
Did I ask  the user for input n and handles input errors?  
	Mark out of 5:5 Comments:It does ask the user for the input and handle errors.
Did I make calls to other methods (at least one)?
	Mark out of 5:5 Comment:  I made a call to the sieve function.
Did I print the output as shown in the question?  
	Mark out of 5:5 Comment: THe program did print the same output as in the question.
   7. Overall
Is my code indented correctly?
	Mark out of 4:4 Comments:Yes, my code is indented correctly
Do my variable names make sense?
	Mark out of 4:4 Comments: I did choose understandable variable names.
Do my variable names, method names and class name follow the Java coding standard
	Mark out of 4:4 Comments: Yes, my code follows the Java coding standard
      Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter an integer greater than or equal to 2 (or else type Exit): ");
		if (input.hasNextInt())
		{
			int userInput = input.nextInt();
			if (userInput>=2)
			{
				System.out.println(nonCrossedOutSubseqToString(sieve(userInput)));
			}
			else
			{
				System.out.print("Invalid format.");
			}
		}
		else
		{
			System.out.print("Invalid format.");
		}
		input.close();
	}
	public static int[][] createSequence(int userInput) 
	{
		int[][] sequenceArray = new int[userInput-1][2];
		for (int index=0; index<userInput-1; index++)
		{
			sequenceArray[index][0]=index+2;
			sequenceArray[index][1]=index+2;
		}
		System.out.println(sequenceToString(sequenceArray));
		return sequenceArray;
	}
	public static int[][] crossOutHigherMultiples(int multiple, int[][] sequenceArray)
	{
		for (int index=0; index<sequenceArray.length; index++)
		{
			for (int count=2; count*multiple<=sequenceArray.length+1; count++)
			{
				if (sequenceArray[index][0]==count*multiple)
				{
					sequenceArray[index][1]=0;
				}
			}
		}
		return sequenceArray;
	}
	public static int[][] sieve(int userInput)
	{
		int[][] sequenceArray = createSequence(userInput);
		for (int multiple=2; multiple<userInput; multiple++)
		{
			if (sequenceArray[multiple-2][1]!=0&&multiple<Math.sqrt(userInput))
			{
				sequenceArray = crossOutHigherMultiples(multiple, sequenceArray);
				System.out.println(sequenceToString(sequenceArray));				
			}
		}
		return sequenceArray;
	}
	public static String sequenceToString(int[][] sequenceArray)
	{
		String outputString="";
		String item = "";
		for (int index=0; index<sequenceArray.length; index++)
		{
	        if (sequenceArray[index][1]==0)
	        {
	        	int number = sequenceArray[index][0];
	        	item = (index!=0?",":" ")+"["+String.valueOf(number)+"]";
	        }
	        else
	        {
	        	int number = sequenceArray[index][0];
	        	item = (index!=0?",":" ")+String.valueOf(number);
	        }
	        outputString=outputString+item;
		}
		return outputString;
	}
	public static String nonCrossedOutSubseqToString(int[][] sequenceArray)
	{
		String outputString="";
		String item="";
		for (int index=0; index<sequenceArray.length; index++)
		{
			if (sequenceArray[index][1]!=0)
			{
				int number = sequenceArray[index][0];
				item = (index!=0?",":" ")+String.valueOf(number);
			}
			else
			{
				item="";
			}
			outputString=outputString+item;
		}
		return outputString;
	}
}
