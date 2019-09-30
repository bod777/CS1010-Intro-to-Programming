import java.util.Scanner;
public class Frequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finished=false;
		while (finished==false)
		{
			Scanner input= new Scanner(System.in);
			System.out.print("\nEnter a number>");
			int number = input.nextInt();
			int count=1;
			while (number>1)
			{
				number /= 10;
				count++;
			}
			int[][] array = new int[count][2];
			countDigitFrequencies(number, array);
			printDigitFrequencies(array);
			input.close();
		}
	}
	public static void countDigitFrequencies( int number, int[][] frequencies)
	{
		for (int index=(frequencies.length-1);index>=0;index--)
		{
			frequencies[index][0]=number%10;
			frequencies[index][1]=1;
		}
		for (int index=0; index<frequencies.length; index++) // e.g. 1112
		{
			int count=1;
			while ((index+count)<(frequencies.length)) 
			{
				if (frequencies[index][0]==frequencies[index+count][0]) 
				{
					frequencies[index][1]+=frequencies[index+count][1];
					frequencies[index+count][1]=0;
					frequencies[index+count][0]=(-count);
				}
				count++;
			}
		}
	}
	public static void printDigitFrequencies(int[][] frequencies)
	{
		System.out.print("Digit frequencies: ");
		for (int index=0; index<frequencies.length;index++)
		{
			if (frequencies[index][0]>=0&&frequencies[index][1]>0)
			{
				System.out.print(frequencies[index][0]);
				System.out.print("("+frequencies[index][1]+") ");
			}
		}
	}
}
