import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment:  Yes, I used the correct method definition
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: Yes, it did read the text file
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: Yes, it return a ArrayList.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I used the correct method definition, using the user inputted data.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Yes, I separated them by commas and saved them as a ArrayList.

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I used a correct method definition with a boolean return type.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: Yes, my method does compare each word with all the others on the list.
- Exits the loop when a non-unique word is found. [Mark out of 5:2]
- Comment: No, my method completes the for loop but adds to a counter if a non-unique word is found. If the counter is >0 after the loop is complete, then it returns false.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Yes, it does fulfill its purpose.

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I used the correct method definition, with the boolean return type and a String parameter.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Yes, I used the binarySearch in the Arrays library class.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Yes, the function works correctly.

^^ This function works fine normally (I even have an example of how the method works perfectly normally outside a loop down below), but when in a loop, it only correctly labels the first 
string in the loop, after which it labels everything else false, meaning in the isWordChain, the only output is as invalid one. I have no explanation as to why it doesn't work in a loop.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I do have the correct definition.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yes, the above is how my method operates.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I use the correct method definition for isWordChain.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:5]
- Comment: it does call upon the above methods, however, due to a problem with the isEnglishWord function, it does not print the appropriate message.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Yes, it does.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Yes, it does correctly asks the user for input and calls isWordChain.

 Total Mark out of 100 (Add all the previous marks):95
*/
public class WordLinksPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finished=false;
		while (!finished){
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a comma separated list of words (or type in Exit to quit):");
			if (input.hasNext("Exit"))
			{
				System.out.println("Goodbye.");
				finished=true;
			}
			else
			{
				String stringOfWords = input.nextLine();
				ArrayList<String> listOfWords = readWordList(stringOfWords);
				isWordChain(listOfWords);
				input.close();
				
	/*  		ArrayList<String> obj = new ArrayList<String>();
		 		obj.add("hello");
				obj.add("dkadkakdj");
				obj.add("goodbye");
				if(isEnglishWord(obj.get(0)))
				{
					System.out.println(obj.get(0) + ">> YES");
				}
				else
				{
					System.out.println(obj.get(0) + ">> NO");
				}
				if(isEnglishWord(obj.get(1)))
				{
					System.out.println(obj.get(1) + ">> YES");
				}
				else
				{
					System.out.println(obj.get(1) + ">> NO");
				}
				
				if(isEnglishWord(obj.get(2)))
				{
					System.out.println(obj.get(2) + ">> YES");
				}
				else
				{
					System.out.println(obj.get(2) + ">> NO");
				}*/
			}
		}
	}
	public static ArrayList<String> readDictionary(){
		ArrayList<String> dictionary = new ArrayList<String>();
        File textFile=new File("words.txt");
        try {    
        	Scanner input = new Scanner(textFile);
            while (input.hasNextLine()) {
                dictionary.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return dictionary;
	}
	public static ArrayList<String> readWordList(String stringOfWords){
		String[] array = stringOfWords.split(",");
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));
		return arrayList;
	}
	public static boolean isUniqueList(ArrayList<String> arrayList){
		int sameWordCounter=0;
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = i+1; j < arrayList.size()-1; j++) {
				if ((arrayList.get(i).equals(arrayList.get(j))))
				{
					sameWordCounter++;
				}	
			}
		}
		if (sameWordCounter>0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static boolean isEnglishWord(String testWord){
		ArrayList<String> dictionary = readDictionary();
		Object[] words = dictionary.toArray();
		if (Arrays.binarySearch(words, testWord)<0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static boolean isDifferentByOne(String st1, String st2)
	{
		int difference=0;
		char[] array1 = st1.toCharArray();
		char[] array2 = st2.toCharArray();
		if (array1.length == array2.length) 
		{
			for (int index = 0; index < array1.length; index++) 
			{
				if (array1[index]!=array2[index])
				{
					difference++;
				}
			}
			if (difference==1)
			{
				return true;
			}	
			else 
			{
				return false;
			}
		}
		else{
			return false;
		}
	}
	public static void isWordChain(ArrayList<String> listOfWords)
	{
		
		if (isUniqueList(listOfWords))
		{
			int wordsInTheChain=1;
			for (int counter = 0; counter < listOfWords.size()-1; counter++) 
			{
				String test1= listOfWords.get(counter);
				String test2= listOfWords.get(counter+1);
				if(isEnglishWord(test1))
					{
						if (isDifferentByOne(test1, test2))
						{
							wordsInTheChain++;
							System.out.println("counter "+counter+" and "+(counter+1));
						}
					}
			} 
			if (wordsInTheChain == listOfWords.size()-1)
			{
				System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
			}
			else
			{
				System.out.println("Invalid chain of words from Lewis Carroll's word-links game.");
			}	
		}
		else
		{
			System.out.println("Invalid chain of words from Lewis Carroll's word-links game.");
		}
	}
}
