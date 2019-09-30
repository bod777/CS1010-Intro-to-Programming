import java.util.Scanner;
import javax.swing.JOptionPane;
/*
	 * Using dialog boxes, write a program which takes a date (1-31),
	 * month (1-12) and year and outputs the date in a proper format
	 * (e.g. 3rd April 2015).
	 * You must
	 *  - Use dialog boxes for the input and output
	 *  - Use switch statements when deciding the ending for the date
	 *    (st/nd/rd/th).
	 *  - Ensure that any possible exceptions are handled.
	 */
public class FortmatDate2 {
	
	public static final String[] MONTHS = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		
		public static void main(String[] args) {

		try
		{
			String input = JOptionPane.showInputDialog("Enter year:");
			Scanner scanner = new Scanner( input );
			int year = scanner.nextInt();
			input = JOptionPane.showInputDialog("Enter month (1-12):");
			scanner = new Scanner( input );
			int month = scanner.nextInt();
			input = JOptionPane.showInputDialog("Enter day (1-31):");
			scanner = new Scanner( input );
			int day = scanner.nextInt();
			if ((year <= 0) || (month < 1) || (month > 12) ||
						(day < 1) || (day > 31))
			{
				JOptionPane.showMessageDialog(null, "" + day + "/" + month + "/" + year + " is not a valid date.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				String numberEnding = "th";
				if (day / 10 != 1)
				{
					switch (day%10)
					{
					case 1:
						numberEnding = "st";
						break;
					case 2:
						numberEnding = "nd";
						break;
					case 3:
						numberEnding = "rd";
						break;
						default:
					}
				}
				String monthString = MONTHS[month-1];
				JOptionPane.showMessageDialog(null, "" + day +
					numberEnding + " " + monthString + " " + year );
			}
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "No number entered.");
		}
	}
}
