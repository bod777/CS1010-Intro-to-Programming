/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10:  10
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10:  10
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20:  19
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30:  29
   8. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 
*/
import java.util.Scanner;
public class IncrementalStatistics {
	public static final String EXIT = "exit";
	public static final String QUIT = "quit";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double average=0;
		double variance=0;
		double newNumber=0;
		int count=0;
		boolean finished=false;
		System.out.println("This program computes the average and variance of all numbers entered.");
		
		do
		{
			Scanner input = new Scanner (System.in);
			System.out.print("Enter a number (or type 'exit' or 'quit'):");
			if (input.hasNextInt())
			{
				count += 1; 
				newNumber = input.nextInt();
				double previousAverage =average;
				double previousVariance = variance;
				average = previousAverage+(newNumber-previousAverage)/count;
				variance = ((previousVariance*(count-1))+((newNumber-previousAverage)*(newNumber-average)))/count;
				System.out.println("So far the average is " + average + " and the variance is "+variance);
			}
			else if (input.hasNext(EXIT))
			{
				finished = true;
				System.out.println("Goodbye.");
			}
			else if (input.hasNext(QUIT))
			{
				finished = true;
				System.out.println("Goodbye.");
			}
			else System.out.println("Not a valid number. Try Again");
		} while (!finished);
	}

}
