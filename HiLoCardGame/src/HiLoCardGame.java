/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5:5
       Comment: 
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5:5
       Comment: 
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10:10
       Comment:  
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5:5
       Comment:  
   5. Did I indent the code appropriately? 
       Mark out of 10:10
       Comment:  
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20:20
       Comment:  
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10:10
       Comment:  
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 9
       Comment:  
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 10
       Comment:  
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10:9
       Comment: I did report whether the user won but as the loop keeps repeating until the user wins, there's no way to lose, therefore I can't exactly report they lost.
   11. How well did I complete this self-assessment? 
       Mark out of 5:5
       Comment:  
   Total Mark out of 100 (Add all the previous marks): 98
*/
import java.util.Random;
import java.util.Scanner;
public class HiLoCardGame {
	
	public static final int MIN_NUMBER = 2;
	public static final int MAX_NUMBER = 12;
	public static final String HIGHER = "higher";
	public static final String LOWER = "lower";
	public static final String EQUAL = "equal";
	public static final String ACE = "ace";
	public static final String KING = "king";
	public static final String QUEEN = "queen";
	public static final String JACK = "jack";
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
				int count = 0;
				int score = 0;
				int currentCard=0;

				while (score!=4)
				{
					count++;
					Random generator = new Random();
					int nextCard = MIN_NUMBER+generator.nextInt(MAX_NUMBER);
					
					if(count>1)
					{
						Scanner input= new Scanner(System.in);
						System.out.print("Do you think the next card will be higher, lower or equal?");
						input.close();
						if (input.hasNext(HIGHER))
						{
							if (nextCard>currentCard)
							{
								score++;
							}
							else
							{
								score=0;
							}
						}
						else if (input.hasNext(EQUAL))
						{
							if (nextCard==currentCard)
							{
								score++;
							}
							else
							{
								score=0;
							}
						}
						else if (input.hasNext(LOWER))
						{
							if(nextCard<currentCard)
							{
								score++;
							}
							else
							{
								score=0;
							}
						}
						else
						{
							System.out.println("Invalid input");
						}		
					}	

					if(nextCard==14)
					{
						 String nextNameCard = ACE;
						 System.out.println("The card is a "+nextNameCard);
					}
					else if (nextCard==13)
					{
						String nextNameCard = KING;
						System.out.println("The card is a "+nextNameCard);
					}
					else if (nextCard==12)
					{
						String nextNameCard = QUEEN;
						System.out.println("The card is a "+nextNameCard);
					}
					else if (nextCard==11)
					{
						String nextNameCard = JACK;
						System.out.println("The card is a "+nextNameCard);
					}
					else
					{
						System.out.println("The card is a "+nextCard);
					}
					currentCard =nextCard;
				}
				System.out.println("Congratulations! You got four correct.");
	}
}


