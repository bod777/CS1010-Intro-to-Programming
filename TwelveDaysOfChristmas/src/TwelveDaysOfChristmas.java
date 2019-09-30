/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5:  5
    	I used constants instead of lines of lyrics within the code.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
      	I correctly formatted them in UPPERCASE and I gave them short names, differentiating them by number.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)? 
       Mark out of 10: 10
       	I definitely think my four variable names (verse, newLine, repeatedLines, dayOfChristmas) are easy-to-understand and in the correct format.
   4. Did I indent the code appropriately? 
       Mark out of 10: 10
       	This includes not indenting for the <case: > in the switch.
   5. Did I use an appropriate loop (or loops) to produce the different verses? 
       Mark out of 20:  20
       	I used just one for-loop, because there is a very clear set amount of the times the loop needs to be repeat, that is 12 verses.
   6. Did I use a switch to build up the verses? 
       Mark out of 25:  25
       	Yes, I used a switch to not only change the nominal number of the verse (i.e. first day, second day... etc) but to also add the new line for
       	the verse.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))? 
       Mark out of 10: 10
       	I referred to the constant LINE1 ("A Partridge in a Pear Tree") twice in order to add the "and" in for the verses after verse 1. Other than 
       	that, i only referred to the constants (i.e. the lines which make up the verses) once each.
   8. Does the program produce the correct output? 
       Mark out of 10:  10
       	Yes, the program did produce the entire lyrics of Twelve Days of Christmas
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 100
*/
public class TwelveDaysOfChristmas {
	public static final String LINE1 = "A Partridge in a Pear Tree";
	public static final String LINE2 = "\n2 Turtle Doves";
	public static final String LINE3 = "\n3 French Hens";
	public static final String LINE4 = "\n4 Calling Birds";
	public static final String LINE5 = "\n5 Golden Rings";
	public static final String LINE6 = "\n6 Geese a Laying";
	public static final String LINE7 = "\n7 Swans a Swimming";
	public static final String LINE8 = "\n8 Maids a Milking";
	public static final String LINE9 = "\n9 Ladies Dancing";
	public static final String LINE10 = "\n10 Lords a Leaping";
	public static final String LINE11 = "\n11 Pipers Piping";
	public static final String LINE12 = "\n12 Drummers Drumming";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String newLine = "";
		String repeatedLines = "";
		for (int verse=1;(verse<13);verse++)
		{
			String dayOfChristmas = "";

			switch (verse)
			{
			case 12:
				dayOfChristmas = "twelfth";
				newLine = LINE12;
				break;
			case 11:
				dayOfChristmas = "eleventh";
				newLine = LINE11;
				break;
			case 10:
				dayOfChristmas = "tenth";
				newLine = LINE10;
				break;
			case 9:
				dayOfChristmas = "ninth";
				newLine = LINE9;
				break;
			case 8:
				dayOfChristmas = "eighth";
				newLine = LINE8;
				break;
			case 7:
				dayOfChristmas = "seventh";
				newLine = LINE7;
				break;
			case 6:
				dayOfChristmas = "sixth";
				newLine = LINE6;
				break;
			case 5:
				dayOfChristmas = "fifth";
				newLine = LINE5;
				break;
			case 4: 
				dayOfChristmas = "fourth";
				newLine = LINE4;
				break;
			case 3:
				dayOfChristmas = "third";
				newLine = LINE3;
				break;
			case 2:
				dayOfChristmas = "second";
				newLine =LINE2;
				break;
			case 1:
				dayOfChristmas = "first";
				break;
			}
			
			System.out.println("\nOn the " + dayOfChristmas + " day of christmas");
			System.out.print("my true love sent to me:");
			System.out.print(newLine);
			System.out.print(repeatedLines);
			if (verse==1)
			{
				System.out.println("\n"+ LINE1);
			}
			else
			{
				System.out.println("\nAnd "+LINE1);
			}
			repeatedLines = newLine + repeatedLines;
		}
	}
}
