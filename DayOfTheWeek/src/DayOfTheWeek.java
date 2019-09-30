/* SELF ASSESSMENT
 1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       	Yes, I did use meaningful CONSTANTS in UPPERCASE.
 2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5:  5
       	Yes, I used simple variable names like date, month and year for the main piece of code, and I properly formatted other variables in functions.
 3. Did I indent the code appropriately?
       Mark out of 5: 5
       	Yes, I did indent the code appropriately.
 4. Did I define the required function correctly (names, parameters & return type) and invoke them correctly?
       Mark out of 20: 20
       	I think I did define the required functions correctly.
 5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
       Mark out of 20:  20
       	Yes, the dayOfTheWeek function was implemented correctly,
 6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
       Mark out of 20:  20
       	The other functions I implemented work correctly. I also took some code from samples on blackboard, which I credited in the comments.
 7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?
       Mark out of 10: 10
       	Yes, I did use the correct input format (dd/mm/yyyy) and I coded for invalid inputs.
 8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
       Mark out of 10:  10
       	Yes, the program does produce the correct output.
 9. How well did I complete this self-assessment?
       Mark out of 5:5
        Yes, I think I was honest about my work in this self-assessment.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Math;

public class DayOfTheWeek {
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int MAX_NUMBER_OF_MONTHS = 12;
	public static final int MIN_NUMBER_OF_MONTHS = 1;
	public static final int MIN_DAYS_IN_A_MONTH = 1;
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		boolean finished=false;
		do 
		{
			String input = JOptionPane.showInputDialog("Enter a date (in the format dd/mm/yyyy):");
			Scanner scanner = new Scanner( input );
			scanner.useDelimiter("/");
			if (scanner.hasNextInt())
			{
				
				int date = scanner.nextInt();
				int month = scanner.nextInt();
				int year = scanner.nextInt();
				if (validDate(date,month,year))
				{
					JOptionPane.showMessageDialog(null, dayOfTheWeek(date,month,year)+", "+date+numberEnding(date)+" "+monthName(month)+" "+year);
					finished=true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "The date you enter "+date+"/"+month+"/"+year+" is invalid. Please re-enter a date or click "
							+ "exit.");
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Your input is invalid. Please re-enter a date or click cancel.");
			}
			
			scanner.close();
		} while (!finished);
	}
	private static boolean validDate( int date, int month, int year )
	{
		boolean validDate = (month<=MAX_NUMBER_OF_MONTHS)&&(month>=MIN_NUMBER_OF_MONTHS)&&(date>=MIN_DAYS_IN_A_MONTH)&&(date<=daysInMonth(month, year));
		return validDate;
	}
	private static boolean isLeapYear(int year) 
	{
		boolean isLeapYear = (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));/* this line of code was extracted from line 36 in the sample 
			program DaysInTheMonth.java from week 8 
			link: https://tcd.blackboard.com/webapps/blackboard/execute/content/file?cmd=view&content_id=_870295_1&course_id=_38679_1&framesetWrapped=true */
		return isLeapYear;
	}
	private static int daysInMonth(int month, int year) 
	{
		/* the following lines of code (92-109), along with the 4 constants (line 34-39) were taken from the sample program DaysInTheMonth.java from week 8
		link: https://tcd.blackboard.com/webapps/blackboard/execute/content/file?cmd=view&content_id=_870295_1&course_id=_38679_1&framesetWrapped=true */
		int daysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			daysInMonth = isLeapYear(year) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				                                       DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			daysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			daysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return daysInMonth;
	}
	private static String dayOfTheWeek (int date, int month, int year)
	{
		String dayName = "";
		int Y = month==1||month==2 ? year-1 : year;
		int y = Y%100;
		int c = Y/100;
		int w = Math.abs((int) ((date + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + Math.floor(y/4) + Math.floor(c/4) - 2*c)%7)); /* formula taken
		 	from the assignment instructions*/
		switch (w)
		{
		case 0:
			return "Sunday";
		case 1:
			dayName =  "Monday";
			break;
		case 2: 
			dayName =  "Tuesday";
			break;
		case 3: 
			dayName =  "Wednesday";
			break;
		case 4:
			dayName =  "Thursday";
			break;
		case 5:
			dayName =  "Friday";
			break;
		case 6:
			dayName = "Saturday";
			break;
		}
		return dayName;
	}
	private static String numberEnding(int date)
	{
		switch (date)
		{
		case 1:
		case 21:
		case 31:
			return "st";
		case 2:
		case 22:
			return "nd";
		case 3:
		case 23:
			return "rd";
		default:
			return "th";
		}
	}
	private static String monthName (int month)
	{
		switch (month)
		{
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		default:
			return "December";
		}
	}
}
