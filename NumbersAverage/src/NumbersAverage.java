import java.util.Scanner;
import javax.swing.JOptionPane;

public class NumbersAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = JOptionPane.showInputDialog ("Enter three numbers (a,b,c) :");
		Scanner inputScanner = new Scanner (input);
		inputScanner.useDelimiter(",");
		double number1 = inputScanner.nextDouble();
		double number2 = inputScanner.nextDouble();
		double number3 = inputScanner.nextDouble();
		inputScanner.close();
		
		double averageNumber = (number1 + number2 + number3)/3.0;

		JOptionPane.showMessageDialog(null, "The average of the three numbers is " + averageNumber);

		double sumLessAverages = (number1-averageNumber) + (number2-averageNumber) + (number3-averageNumber);
		double sumSquared = sumLessAverages*sumLessAverages;
		double standardDeviation = Math.sqrt(sumSquared/3.0);

		JOptionPane.showMessageDialog (null, "The Standard Deviation of the three numbers is " +standardDeviation);

	}

}
