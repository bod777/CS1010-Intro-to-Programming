package rational;
import java.util.Scanner;
public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a rational number (numerator denominator):");
		Scanner input1 = new Scanner(System.in);
		Rational fraction1 = new Rational(input1.nextInt(), input1.nextInt());
		System.out.println("Please enter another rational number (numerator denominator):");
		Scanner input2 = new Scanner(System.in);
		Rational fraction2 = new Rational(input2.nextInt(), input2.nextInt());
		input1.close();
		input2.close();
				
		System.out.println(fraction1.toString()+" + "+fraction2.toString()+" = "+fraction1.add(fraction2).toString());
		System.out.println(fraction1.toString()+" - "+fraction2.toString()+" = "+fraction1.subtract(fraction2).toString());
		System.out.println(fraction1.toString()+" x "+fraction2.toString()+" = "+fraction1.multiply(fraction2).toString());
		System.out.println(fraction1.toString()+" / "+fraction2.toString()+" = "+fraction1.divide(fraction2).toString());
			
		System.out.println(fraction1.toString()+" can be simplified to "+fraction1.simplify().toString());
		System.out.println(fraction2.toString()+" can be simplified to "+fraction2.simplify().toString());
		if (fraction1.equal(fraction2))
		{
			System.out.println(fraction1.toString()+" is equal to "+fraction2.toString());
		}
		else
		{
			System.out.println(fraction1.toString()+" is not equal to "+fraction2.toString());
		}
		if (fraction1.isLessThan(fraction2))
		{
			System.out.println(fraction1.toString()+" is less than "+fraction2.toString());
		}
		else
		{
			System.out.println(fraction1.toString()+" is not less than "+fraction2.toString());
		}
	}
}
