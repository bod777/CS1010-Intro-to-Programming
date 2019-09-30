import java.util.Scanner; // NOT WORKING, TEST VERSION IN ONE NOTE

public class NumberConvertion {
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
		String singles = "";
		String five = "";
		String nine = "";
		String four = "";
		if (array[0]>0)
		{
			for (int count=1;count<=array[0]; count++)
			{
				romanNumbers = romanNumbers +"M";
			}
		}
		for (int index=1; index<array.length;index++)
		{
			switch (index)
			{
			case 1:
				singles = "C";
				five = "D";
				nine = "CM";
				four = "CD";
			case 2:
				singles = "X";
				five = "L";
				nine = "XC";
				four = "XL";
			case 3:
				singles = "I";
				five = "V";
				nine = "IX";
				four = "IV";
			}
			if (array[index]>0)
			{
				if (array[index]!=9||array[index]!=4)
				{
					if (array[index]>=5)
					{
						romanNumbers = romanNumbers + five;
					}
					for (int count=1; count<=array[index]%5;count++)
					{
						romanNumbers = romanNumbers + singles;
					}
				}
				else if (array[index]==9)
				{
					romanNumbers=romanNumbers+nine;
				}
				else if (array[index]==4)
				{
					romanNumbers=romanNumbers+four;
				}
			}
		}
		return romanNumbers;
	}
}
