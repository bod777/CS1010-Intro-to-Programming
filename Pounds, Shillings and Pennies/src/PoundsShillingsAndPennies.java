/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:   10
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  5
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  9
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
   6. Did I indent the code appropriately?
       Mark out of 10:  10
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  10
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  18
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
   10. How well did I complete this self-assessment?
       Mark out of 10:  9
   Total Mark out of 100 (Add all the previous marks):  96
*/

import java.util.Scanner;
import javax.swing.JOptionPane;
		
public class PoundsShillingsAndPennies {

	public static final int PENCE_PER_POUND = 100;
	public static final int NEW_PENCE_PER_OLD_PENNY = 67;
	public static final int OLD_PENCE_PER_OLD_SHILLING = 12;
	public static final int OLD_SHILLINGS_PER_OLD_POUND = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = JOptionPane.showInputDialog ("Enter the amount of old pounds you wish "
				+ "to convert:");
		Scanner inputScanner = new Scanner (input);
		int oldPounds = inputScanner.nextInt();
		inputScanner.close();
		input = JOptionPane.showInputDialog ("Enter the amount of old shillings you wish "
				+ "to convert:");
		inputScanner = new Scanner (input);
		int  oldShillings = inputScanner.nextInt();
		inputScanner.close();
		input = JOptionPane.showInputDialog("Enter the amount of old pennies you wish "
				+ "to convert:");
		inputScanner = new Scanner (input);
		int oldPence = inputScanner.nextInt();
		inputScanner.close();
				
		int oldPoundsToShillings = oldPounds*OLD_SHILLINGS_PER_OLD_POUND;
		int totalShillings = oldShillings + oldPoundsToShillings;
		int shillingsToOldPence = totalShillings*OLD_PENCE_PER_OLD_SHILLING;
		int totalOldPence = oldPence + shillingsToOldPence;
		int totalPence = totalOldPence*NEW_PENCE_PER_OLD_PENNY;
		int newPound = totalPence / PENCE_PER_POUND;
		int newPence = totalPence % PENCE_PER_POUND;
		JOptionPane.showMessageDialog(null, oldPounds + " old pound, " + oldShillings + 
				" old shilling and " + oldPence + " old pence = £" + newPound + "." + newPence);
	}
	
}
