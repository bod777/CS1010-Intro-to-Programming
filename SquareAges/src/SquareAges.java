/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code?  
       Mark out of 5: 5
   2. Did I use easy-to-understand, meaningful CONSTANT names? 
       Mark out of 5: 5
   3. Did I format the CONSTANT names properly (in UPPERCASE)? 
       Mark out of 5: 5
   4. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
   5. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
   6. Did I indent the code appropriately? 
       Mark out of 10: 10
   7. Did I use an appropriate for loop to test all possibilities?  There should be only one. 
       Mark out of 20:  20
   8. Did I correctly check if people alive today were or could be alive in a year that is the square of their age in that year. 
       Mark out of 30:  30
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Calendar;

public class SquareAges {
	
	public static final int MAX_AGE = 123;
	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	public static final int MIN_YEAR = CURRENT_YEAR-MAX_AGE;
	public static final int MAX_YEAR = CURRENT_YEAR+MAX_AGE;
	
	public static void main(String[] args) {
	
		for (int age = 0; age < MAX_AGE; age++) 
		{
			int squaredAge = age*age;
			if ((squaredAge-age)>MIN_YEAR && (squaredAge-age)<MAX_YEAR && ((squaredAge-age)<CURRENT_YEAR))
				{
					if (squaredAge<CURRENT_YEAR)
					{
						System.out.println("Someone aged " + age + " in " + squaredAge + " lived through a year "
								+ "where their age was the square root of that year." );	
					}
					else if (squaredAge==CURRENT_YEAR) 
					{
						System.out.println("Someone aged " + age + " in " + squaredAge + "is alive during a year "
								+ "where their age is the square root of that year.");
					}
					else
					{
						System.out.println("Someone aged " + age + " in " + squaredAge + " will be alive during a "
								+ "year where their age will be the square root of that year.");
					}
				}
		}
	}
}
