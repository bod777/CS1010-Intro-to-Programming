import java.util.Scanner;
import javax.swing.JOptionPane;

public class OldSterlingConverter02 {
	
	public static final int PENNIES_PER_POUND = 100;
	public static final int NEW_PENNIES_PER_OLD_PENNY = 67;
	public static final int OLD_PENNIES_PER_OLD_SHILLING = 12;
	public static final int OLD_SHILLINGS_PER_OLD_POUND = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = JOptionPane.showInputDialog ("enter the amount of old pounds, old shillings and old pence (pounds, shillings, pence) you wish to convert.");
		Scanner inputScanner = new Scanner (input);
		inputScanner.useDelimiter(", ");
		int oldPounds = inputScanner.nextInt();
		int oldShillings = inputScanner.nextInt();
		int oldPence = inputScanner.nextInt();
		inputScanner.close();
				
		int oldPoundsToShillings = oldPounds*OLD_SHILLINGS_PER_OLD_POUND;
		int totalOldShillings = oldShillings + oldPoundsToShillings;
		int shillingsToOldPence = totalOldShillings*OLD_PENNIES_PER_OLD_SHILLING;
		int totalOldPence = oldPence + shillingsToOldPence;
		int totalPennies = totalOldPence*NEW_PENNIES_PER_OLD_PENNY;
		int newPound = totalPennies / PENNIES_PER_POUND;
		int newPennies = totalPennies % PENNIES_PER_POUND;
		JOptionPane.showMessageDialog(null, oldPounds + " old pound, " + oldShillings + " old shilling and " + oldPence + " old pence = £" + newPound + "." + newPennies); 

	}

}
