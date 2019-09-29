import javax.swing.JOptionPane;
import java.util.Scanner;
		
public class BodyMassIndexCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String heightInput = JOptionPane.showInputDialog("What is your height in metres?");
		Scanner inputScanner = new Scanner ( heightInput );
		double height1 = inputScanner.nextDouble ();
		inputScanner.close ();
	
		double square = height1*height1;
	
		String weightInput = JOptionPane.showInputDialog("What is your weight in kgs?");
		Scanner inputScanner1 = new Scanner ( weightInput );
		double weight1 = inputScanner1.nextDouble ();
		inputScanner1.close ();
	
		double BMI = weight1/square;
	
		JOptionPane.showMessageDialog (null, "For height " + height1 + "metres and weight " + weight1 + "kgs, the BMI is " + BMI);

	}
	
}
