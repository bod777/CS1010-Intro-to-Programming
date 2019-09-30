/* SELF ASSESSMENT 

Class Rational 
I declared two member variables: numerator and denominator (marks out of 4:4 ).
Comment:Yes I did declare two member variables

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the 
corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5:5 ).
Comment: Yes, I do take two ints as parameters for this constructor and I have an exception.

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this 
case, as the resulting rational number in this case is an integer (marks out of 3:3 ).
Comment: I have a correct and working constructor.

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which 
the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks 
out of 8:8 ).
Comment: Yes, my program has a working add method.

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8:8 ).
Comment: Yes, my program has a working subtraction method.

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8:8 ).
Comment: Yes, my program has a working multiply method.

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8:8 ).
Comment: Yes, my program has a working divide method.

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between 
numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value 
((marks out of 8:7 ).
Comment: I have a working, correct equals method, however I used subtraction rather than multiplication to compare the rationals.

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division
 will lead to incorrect results. I return a boolean value (marks out of 8:7 ).
Comment: I have a working, correct equals method, however I used subtraction rather than multiplication to compare the rationals.

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't 
take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator 
and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8:8 ).
Comment: Yes, I have a working simplify method.

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6:6 ).
Comment: Yes, I do have a working GCD function.

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4:4 ).
Comment: Yes, I have a working toString method.

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided 
values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results 
(marks out of 22:22 ).
Comment: Yes, my program does do all the above.
*/
package rational;

public class Rational {
	int numerator;
	int denominator;
	Rational(int num, int den){
		numerator = num;
		denominator = den;
		if (denominator == 0) 
		{
		    throw new IllegalArgumentException("Argument 'denominator' is 0");
		}
	}
	Rational(int num){
		numerator=num;
		denominator=1;
	}
	Rational add(Rational input){
		return new Rational((input.numerator*denominator+numerator*input.denominator), denominator*input.denominator).simplify();
	}
	Rational subtract(Rational input){
		return new Rational(((numerator*input.denominator)-(input.numerator*denominator)), denominator*input.denominator).simplify();
	}
	Rational multiply(Rational input){
		return new Rational(numerator*input.numerator, denominator*input.denominator).simplify();
	}
	Rational divide(Rational input){
		return new Rational(numerator*input.denominator, denominator*input.numerator).simplify();
	}
	boolean equal(Rational input){
		Rational temp = this.subtract(input);
		if (temp.numerator==0)
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
	boolean isLessThan(Rational input){
		Rational temp = this.subtract(input);
		if (temp.numerator < 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	Rational simplify(){
		return new Rational(numerator/this.GCD(),denominator/this.GCD());
	}
	public int GCD() {
		int highestNumber = 0;
		if (numerator>=denominator)
		{
			highestNumber = numerator;
		}
		else if (denominator>numerator)
		{
			highestNumber = denominator;
		}
		for (int index=highestNumber; index>=1; index--)
		{
			if (denominator%index==0 && numerator%index==0)
			{
				return index;
			}
		}
		return 1;
	}
	public String toString(){
		String rationalString = numerator+"/"+denominator;
		return rationalString;
	}
}
