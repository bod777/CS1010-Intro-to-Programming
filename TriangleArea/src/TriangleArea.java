import java.util.Scanner;
import javax.swing.JOptionPane;

public class TriangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = JOptionPane.showInputDialog ("Enter the coordinates (x,y) of one of the vertex of your triangle.");
		Scanner inputScanner = new Scanner (input);
		inputScanner.useDelimiter(",");
		double Ax = inputScanner.nextDouble();
		double Ay = inputScanner.nextDouble();
		inputScanner.close();

		input = JOptionPane.showInputDialog ("Enter the coordinates (x,y) of another vertex of your triangle.");
		inputScanner = new Scanner (input);
		inputScanner.useDelimiter(",");
		double Bx = inputScanner.nextDouble();
		double By = inputScanner.nextDouble();
		inputScanner.close();
		
		input = JOptionPane.showInputDialog("enter the coordinates (x,y) of the final vertex of your triangle.");
		inputScanner = new Scanner (input);
		inputScanner.useDelimiter(",");
		double Cx = inputScanner.nextDouble();
		double Cy = inputScanner.nextDouble();
		inputScanner.close();
		
		Ax *= By-Cy;
		Bx *= Cy-Ay;
		Cx *= Ay-By;

		double sum = Ax + Bx + Cx;
		double faction = sum/2.0;

		double squaredArea = faction*faction;
		double area = Math.sqrt(squaredArea);

JOptionPane.showMessageDialog(null, "The area of your triangle is " + area);

	}

}
