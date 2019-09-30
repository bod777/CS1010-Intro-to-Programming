import java.util.Scanner;

public class PrimeNumberPrizes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		System.out.print("Enter the amount of competitors:");
		int numberOfCompetitors = inputScanner.nextInt();
		inputScanner.close();
		System.out.println("Prizes should be given to the competitors who come");
		int count=0;
		while (numberOfCompetitors<count)
		{
			count++;
			int placeNumber=4;
			boolean finished=false;
			do  
			{
				int number=2;
				int check = placeNumber%number;
				if (check==0)
				{
					placeNumber=0;
					finished=true;
				}
				number++;
			} while (!finished);
			placeNumber++;
			System.out.print(placeNumber +"th");
		}
	}
}
