import java.util.Scanner;
/*
SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:  5 Comment: I used meaningful variable names.
 2. Did I indent the code appropriately?
        Mark out of 5: 5 Comment: I did indent the code appropriately.
 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  15 Comment: this function works correctly.
 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  14 Comment: Im not sure about the return type.
 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  15 Comment: Yes, I invoke this function correctly in the insertScore function, rather than the main body.
 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20 Comment: yes, this function has the correct parameters, return type etc.
 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?
       Mark out of 20:  15 Comment: for some reason, every second input of new scores isn't going through.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5 Comment: I believe I completely this self-assessment honestly.
 Total Mark out of 100 (Add all the previous marks): 94

*/ 
public class HighScores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input1 = new Scanner(System.in);
		System.out.println("How many scores do you want this list to hold?");
		int sizeOfArray = (input1.hasNextInt())?input1.nextInt():0;
		if (sizeOfArray<=0)
		{
			System.out.println("Invalid input. Please re-enter your number.");
		}
		else
		{
			int[] highScores= new int[sizeOfArray];
			highScores = initialiseHighScores(highScores);
			boolean finished = false;
			while (finished==false)
			{
				Scanner input2 = new Scanner(System.in);
				System.out.println("Please enter a score (or enter Exit):");
				int newScore = (input2.hasNextInt())?input2.nextInt():0;
				if (newScore>=0)
				{
					insertScore(highScores, newScore);
					System.out.println(printHighScores(highScores));
				}
				else
				{
					System.out.println("Invalid input. Please re-enter your score.");
				}
				finished= (input2.hasNext("Exit")||input2.hasNext("exit"))?true:false;
			}
			System.out.println("Thank you for playing. \nGoodbye!");
		}
	}
	public static int[] initialiseHighScores(int highScores[])
	{
		for (int index=0;index<highScores.length;index++)
		{
			highScores[index]=0;
		}
		return highScores;
	}
	public static String printHighScores(int highScores[])
	{
		String scores= "";
		for (int index=0; index<(highScores.length); index++)
		{
			scores = scores + highScores[index] + ((index==(highScores.length-1))?". ":", ");
		}
		String message = "The high scores are " + scores;
		return message;
	}
	public static int higherThan(int highScores[], int newScore)
	{
		int index=-1;
		boolean finished=false;
		while (finished==false||index==highScores.length)
		{
			index++;
			finished = newScore>=highScores[index]?true:false;	
		}
		return index;
	}
	public static int[] insertScore(int highScores[], int newScore)
	{
		int proposedIndex = higherThan(highScores, newScore); 
		if (proposedIndex<(highScores.length-1)&&proposedIndex>=0)
		{
			int index = proposedIndex; 
			for (int count=1;count<(highScores.length-index);count++)
			{
				highScores[highScores.length-count]=highScores[highScores.length-(count+1)];
			}	
			highScores[index]=newScore;
		}
		return highScores;
	}
}
