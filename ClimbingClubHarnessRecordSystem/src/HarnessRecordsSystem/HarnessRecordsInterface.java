/* SELF ASSESSMENT

Harness Class: Member variables (8 marks)
All my data members are declared, private and the ones that don't change are marked as private. 
I also have a constant for the maximum number of uses of a harness.
Marks:8 Comment:Yes, I do have all my data members declared private etc. I do have a constant for the maximum uses.

Harness Class: Harness constructor 1 & constructor 2 (6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Marks:6 Comment:Yes, my constuctors are correct.

Harness Class: checkHarness method (5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value 
(assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Marks:5 Comment:Yes, my checkMethod should set the instructor variable and resets the number of times the harness was used.

Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Marks: 2 Comment:Yes, my method works the same way as is outlined above.

Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number
 of times.
Marks: 4 Comment:Yes, this method works correctly.

Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member 
value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Marks: 6 Comment:Yes, this method call the canHarnessBeLoaned method and does its tasks as outlined above correctly.
 
Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Marks: 5 Comment:Yes, this method is designed as outlined above.

Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Marks: 3 Comment:Yes, this method works correctly.

HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses 
Marks:3 Comment:Yes, I do do that.

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. 
In the second constructor, I use the Java I/O to read data from a text file I created containing sets of Harness characteristics. 
I use these set of characteristics to create Harness objects and add them to the collection. 
Marks: 9 Comment:Yes, I correctly created two constructors, one created a null arraylist, the other using input from a text file.

HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Marks: 1 Comment:Yes, this method works correctly.

HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Marks: 5 Comment:Yes, this method works correctly.

HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. 
It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Marks: 4 Comment:The method is designed as outlined but unfortunately, it is not working in the test class.

HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. 
If a harness with the make and model number exists by using the findHarness method and is not on loan, 
the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. 
If the harness is not available returns null.
Marks:4 Comment:Unfortunately, it is not working in the test class but it is designed as outlined above.

HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. 
If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. 
If there's no available harness null is returned.
Marks: 7 Comment: Yes, the method works correctly as outlined above.

HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. 
If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Marks:4 Comment:Unfortunately, it is not working in the test class but it is designed as outlined above.

HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. 
It returns the harness object if it is found, otherwise returns null.
Marks:4 Comment:Unfortunately, it is not working in the test class but it is designed as outlined above.

GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Marks: 3 Comment: Yes, I do have a test class with a working menu with methods from HarnessRecords.
*/

package HarnessRecordsSystem;

import java.util.Scanner;

public class HarnessRecordsInterface {
	public static int MAKE_INDEX = 0;
	public static int MODEL_NUMBER_INDEX = 1;
	public static int CHECKED_BY_INDEX = 2;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HarnessRecords clubRecord = new HarnessRecords();
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		
		while(!quit)
		{
			System.out.print("\nPlease select: \n1 to add a record for a newly purchased harness, \n2 to remove a climbing harness, "
					+ "\n3 to record a safety check, \n4 to loan a harness, \n5 to return a harness, \n6 to read details on all the harnesses,"
					+ "\n7 to quit.\n >");
			int choice = input.nextInt();
			switch (choice)
			{
			case 1:
				Scanner inputH = new Scanner(System.in);
				System.out.print("\nPlease enter the make, model number and the instructor who performed its mandatory safety "
						+ "\ncheck for the Harness you would like to add (please use commas to separate them)>");
				String harnessInfo = inputH.nextLine();
        		if (harnessInfo != null) {
        			String[] harnessData = harnessInfo.split(",");
        			String make = harnessData[MAKE_INDEX];
        			int modelNumber = Integer.parseInt (harnessData[MODEL_NUMBER_INDEX]);
        			String checkedBy = harnessData[CHECKED_BY_INDEX];
        			Harness harness = new Harness(make, modelNumber, checkedBy);
        			clubRecord.addHarness(harness);
        		}
				break;
			case 2:
				Scanner inputR = new Scanner(System.in);
				System.out.println("Please enter the make and model number of the Harness you would like to remove "
						+ "\n(please use commas to separate them)>");
				String harnessDetails = inputR.nextLine();
        		if (harnessDetails != null) {
        			String[] harnessData = harnessDetails.split(",");
        			String make = harnessData[MAKE_INDEX];
        			int modelNumber = Integer.parseInt (harnessData[MODEL_NUMBER_INDEX]);
        			clubRecord.removeHarness(make, modelNumber);
        		}
				break;
			case 3:
				Scanner inputS = new Scanner(System.in);
				System.out.println("Please enter the make, model number and the instructor who performed its mandatory safety "
						+ "\ncheck on the Harness you would like to add (please use commas to separate them)>");
				String harnessInput = inputS.nextLine();
        		if (harnessInput != null) {
        			String[] harnessData = harnessInput.split(",");
        			String make = harnessData[MAKE_INDEX];
        			int modelNumber = Integer.parseInt (harnessData[MODEL_NUMBER_INDEX]);
        			String instructor = harnessData[CHECKED_BY_INDEX];
        			clubRecord.checkHarness(instructor, make, modelNumber);
        		}
				break;
			case 4: 
				Scanner inputL = new Scanner(System.in);
				System.out.println("Please enter the name of the club member who wants to loan out a harness>");
        		String borrower = inputL.nextLine();
        		clubRecord.loanHarness(borrower);
				break;
			case 5:
				Scanner inputRH = new Scanner(System.in);
				System.out.println("Please enter the make and model number of the Harness you would like to return "
						+ "\n(please use commas to separate them)>");
				String harnessString = inputRH.nextLine();
        		if (harnessString != null) {
        			String[] harnessData = harnessString.split(",");
        			String make = harnessData[MAKE_INDEX];
        			int modelNumber = Integer.parseInt (harnessData[MODEL_NUMBER_INDEX]);
        			clubRecord.returnHarness(make, modelNumber);
        		}
				break;
			case 6:
				clubRecord.printHarnessRecords();
				break;
			case 7:
				System.out.println("Thank you. Goodbye.");
				quit = true;
			}
		}
		input.close();
	}
}
