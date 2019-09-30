
public class TwelveDaysOfChristmasCarol {
	public static final String line1 = "A Partridge in a Pear Tree";
	public static final String line2 = "\n2 Turtle Doves";
	public static final String line3 = "\n3 French Hens";
	public static final String line4 = "\n4 Calling Birds";
	public static final String line5 = "\n5 Golden Rings";
	public static final String line6 = "\n6 Geese a Laying";
	public static final String line7 = "\n7 Swans a Swimming";
	public static final String line8 = "\n8 Maids a Milking";
	public static final String line9 = "\n9 Ladies Dancing";
	public static final String line10 = "\n10 Lords a Leaping";
	public static final String line11 = "\n11 Pipers Piping";
	public static final String line12 = "\n12 Drummers Drumming";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int verse=1;(verse<13);verse++)
		{
			String ordinalNumber = "";
			switch (verse)
			{
			case 1:
				ordinalNumber = "first";
				break;
			case 2:
				ordinalNumber = "second";
				break;
			case 3:
				ordinalNumber = "third";
				break;
			case 4: 
				ordinalNumber = "fourth";
				break;
			case 5:
				ordinalNumber = "fifth";
				break;
			case 6:
				ordinalNumber = "sixth";
				break;
			case 7:
				ordinalNumber = "seventh";
				break;
			case 8:
				ordinalNumber = "eighth";
				break;
			case 9:
				ordinalNumber = "ninth";
				break;
			case 10:
				ordinalNumber = "tenth";
				break;
			case 11:
				ordinalNumber = "eleventh";
				break;
			case 12:
				ordinalNumber = "twelfth";
				break;
			}
			System.out.println("\nOn the " + ordinalNumber + " day of christmas");
			System.out.print("my true love sent to me:");
			if (verse==1)
			{
				System.out.println("\n"+ line1);
			}
			else
			{
				while (verse>11)
				{
					System.out.print(line12);
					break;
				}
				while (verse>10)
				{
					System.out.print(line11);
					break;
				}
				while (verse>9)
				{
					System.out.print(line10);
					break;
				}
				while (verse>8)
				{
					System.out.print(line9);
					break;
				}
				while (verse>7)
				{
					System.out.print(line8);
					break;
				}
				while (verse>6)
				{
					System.out.print(line7);
					break;
				}
				while (verse>5)
				{
					System.out.print(line6);
					break;
				}
				while (verse>4)
				{
					System.out.print(line5);
					break;
				}
				while (verse>3)
				{
					System.out.print(line4);
					break;
				}
				while (verse>2)
				{
					System.out.print(line3);
					break;
				}
				while (verse>1)
				{
					System.out.println(line2);
					break;
				}
				System.out.println("And "+line1);
			}
		}
	}

}
