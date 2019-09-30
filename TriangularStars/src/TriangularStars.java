/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5        Comment: Yes I did use easy-to-understand variable names, including the name variable starIndex, which was a name to 
         						differientate it from the index variable in the main piece of code, making it clear they are too different variables.
 2. Did I indent the code appropriately?
        Mark out of 5:  5       Comment: Yes, I did, accounting for all the different loops and functions.
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20        Comment: I wrote determineTriangleNumber correctly, using the index parameter and an int return type. 
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20        Comment: This boolean return type was the hardest code to write because of the loop but it is functioning correctly 
       								and I invoke it correctly. 
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15: 15         Comment: I calculated my triangle numbers through the determineStarNumber correctly.
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10: 10         Comment: I used the constant Integer.MAX_VALUE in my first loop, ensuring the program will stop when the numbers being 
       								output reach the maximum int type value.
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20: 20       Comment: Yes, the program did.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5       Comment: I was honest in this assessment.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 

public class TriangularStars {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int triangleNumber=0;
		for (int index=0; (triangleNumber<=Integer.MAX_VALUE); index++)
		{
			triangleNumber = determineTriangleNumber(index);
			if (isStarNumber(triangleNumber))
			{
				System.out.println(triangleNumber);
			}
		}
	}
	public static int determineTriangleNumber(int index)
	{
		int triangleNumber=0;
		for (int count=1; count<=index; count++)
		{
			triangleNumber= triangleNumber+count;
		}
		return triangleNumber;
	}
	public static boolean isStarNumber(int triangleNumber)
	{
		boolean isItStarNumber = false;
		
		for (int starIndex=1;starIndex<=triangleNumber;starIndex++)
		{
			int starNumber=6*starIndex*(starIndex-1) + 1;
			if (triangleNumber==starNumber)
			{
				isItStarNumber=true;
			}
		}
		return isItStarNumber;
	}
}
