import java.util.Scanner;
public class Coeffecient {
	public static final String EXIT = "exit";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finished = false;
		
		do
		{
			Scanner input = new Scanner (System.in);
			System.out.print("Enter the coefficients of your second order polynominal separated by spaces (or type 'exit'):");
			
			if (input.hasNextInt())
			{
				double a = input.nextInt();
				double b = input.nextInt();
				double c = input.nextInt();
				double root1;
				double root2;
				if (a==0)
				{
					if (b==0)
					{
						System.out.println("Invalid equation.");
					}
					else
					{
						root1 = -c/b;
						System.out.println("The root of this equation is x="+root1);
					}
				}
				else
				{
					double discriminant=b*b-4*a*c;
					if (discriminant<0)
					{
						double complexNumber = Math.sqrt(discriminant*(-1));
						double beginningOfRoot = -b/2*a;
						root1 = (complexNumber)/2*a;
						root2 = (complexNumber)/2*a;
						System.out.println("The roots to this equation are x="+beginningOfRoot+"-"+root1+"i and x="+beginningOfRoot+"+"+root2+"i.");
					}
					else
					{
						double squareRootDiscriminant = Math.sqrt(discriminant);
						root1 = (-b-squareRootDiscriminant)/2*a;
						root2 = (-b+squareRootDiscriminant)/2*a;
						System.out.println("The roots of this equation are x=" + root1 + " and x="+root2);
					}
				}
			}
			else if (input.hasNext(EXIT))
			{
				finished = true;
				System.out.println("Goodbye.");
			}
			else
			{
				System.out.println("Not a valid number. Try Again");
			}	
		} while (!finished);
	}

}
