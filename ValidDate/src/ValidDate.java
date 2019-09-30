import java.util.Scanner;
import javax.swing.JOptionPane;

public class ValidDate {
	
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int MAX_NUMBER_OF_MONTHS = 12;
	public static final int MIN_NUMBER_OF_MONTHS = 1;
	public static final int MIN_DAYS_IN_A_MONTH = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = JOptionPane.showInputDialog("Enter a date (in the format dd/mm/yyyy:");
		Scanner scanner = new Scanner( input );
		scanner.useDelimiter("/");
		int date = scanner.nextInt();
		int month = scanner.nextInt();
		int year = scanner.nextInt();
		scanner.close();
		if (validDate(date, month, year))
		{
			JOptionPane.showMessageDialog(null, "The date "+date+"/"+month+"/"+year+" is a valid date.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The date "+date+"/"+month+"/"+year+" is an invalid date.");
		}
	}
	private static boolean validDate( int date, int month, int year )
	{
		boolean validDate = (month<=MAX_NUMBER_OF_MONTHS)&&(month>=MIN_NUMBER_OF_MONTHS)&&(date>=MIN_DAYS_IN_A_MONTH)&&(date<=daysInMonth(month, year));
		return validDate;
	}
	private static boolean isLeapYear(int year)
	{
		boolean isLeapYear = (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
		return isLeapYear;
	}
	private static int daysInMonth(int month, int year)
	{
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
}