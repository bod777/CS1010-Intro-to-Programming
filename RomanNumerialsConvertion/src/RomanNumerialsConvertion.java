import javax.swing.JOptionPane;
import java.util.Scanner;

public class RomanNumerialsConvertion {
	public static final int MAX_ROMAN_NUMBER = 4999;
	public static final int MIN_ROMAN_NUMBER = 1;
	public static final int MAX_ROMAN_DIGITS = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finished =false;
		while (finished==false)
		{
			Scanner inputScanner = new Scanner (System.in);
			System.out.print("Enter the Arabic number to be converted>");
			if (inputScanner.hasNextInt())
			{
				int number = inputScanner.nextInt();
				if (canBeConvertedToRoman(number))
				{
					System.out.println("In Roman form, "+number+" is "+convertToRoman(number)+".");
				}
				else
				{
					System.out.println("The number "+ number+" cannot be converted into Roman form.");
				}
			}
			else
			{
				System.out.println("Invalid input. Please re-enter your number.");
			}
		}
	}
	public static boolean canBeConvertedToRoman(int number)
	{
		return (number<=MAX_ROMAN_NUMBER&&number>=MIN_ROMAN_NUMBER);
	}
	public static String convertToRoman(int number)
	{
		int[] array = new int [MAX_ROMAN_DIGITS];
		for (int index=(array.length-1);index>=0;index--)
		{
			array[index]=number%10;
			number/=10;
		}
		String romanNumbers = "";
		String lastDigitRomanNumbers = "";
		String thirdDigitRomanNumbers = "";
		String secondDigitRomanNumbers = "";
		if (array[0]>0)
		{
			for (int count=1;count<=array[0]; count++)
			{
				romanNumbers = romanNumbers +"M";
			}
		}
		if (array[1]>0)
		{
			if (array[1]>=5&&array[1]<9)
			{
				for (int count=1; count<=array[1]%5;count++)
				{
					secondDigitRomanNumbers = secondDigitRomanNumbers + "C";
				}
				secondDigitRomanNumbers = "D"+secondDigitRomanNumbers;
			}
			else if (array[1]==9)
			{
				secondDigitRomanNumbers="CM";
			}
			else if (array[1]==4)
			{
				secondDigitRomanNumbers="CD";
			}
			else if (array[1]<4)
			{
				for (int count=1; count<=array[1]%5;count++)
				{
					secondDigitRomanNumbers = secondDigitRomanNumbers + "C";
				}
			}
		}
		if (array[2]>0)
		{
			if (array[2]>=5&&array[2]<9)
			{
				for (int count=1; count<=array[2]%5;count++)
				{
					thirdDigitRomanNumbers = thirdDigitRomanNumbers + "X";
				}
				thirdDigitRomanNumbers = "L"+thirdDigitRomanNumbers;
			}
			else if (array[2]==9)
			{
				thirdDigitRomanNumbers="XC";
			}
			else if (array[2]==4)
			{
				thirdDigitRomanNumbers="XL";
			}
			else if (array[2]<4)
			{
				for (int count=1; count<=array[2]%5;count++)
				{
					thirdDigitRomanNumbers = thirdDigitRomanNumbers + "X";
				}
			}
		}
		if (array[3]>0)
		{
			if (array[3]>=5&&array[3]<9)
			{
				for (int count=1; count<=array[3]%5;count++)
				{
					lastDigitRomanNumbers = lastDigitRomanNumbers + "I";
				}
				lastDigitRomanNumbers = "V"+lastDigitRomanNumbers;
			}
			else if (array[3]==9)
			{
				lastDigitRomanNumbers="IX";
			}
			else if (array[3]==4)
			{
				lastDigitRomanNumbers="IV";
			}
			else if (array[3]<4)
			{
				for (int count=1; count<=array[3]%5;count++)
				{
					lastDigitRomanNumbers = lastDigitRomanNumbers + "I";
				}
			}
		}
		romanNumbers=romanNumbers+secondDigitRomanNumbers+thirdDigitRomanNumbers+lastDigitRomanNumbers;
		return romanNumbers;
	}
}