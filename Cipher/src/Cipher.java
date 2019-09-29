/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5 Comment: Yes, I did use meaning variable names like encryptedPhrase and plainTextArray.
 2. Did I indent the code appropriately?
        Mark out of 5: 5 Comment: Yes, I did indent the code appropriately.
 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20  Comment: Yes, I write and invoke this function correctly as it takes the plain text of the parameter array (which is a clone of the ALPHABET_ARRAY constant) 
       						and randomizes the order of the array before returning it.
 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20 Comment: I used the correct parameters and return type in this function, which was invoked correctly.
 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20 Comment: I did write the decrypt function with the correct parameters and return type and I invoked it correctly.
 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?
       Mark out of 25: 25  Comment: Yes, I correctly wrote the main function body, including error-handling and a loop. 
 7. How well did I complete this self-assessment?
        Mark out of 5:5 Comment: I completed this self-assessment honestly and fairly.
 Total Mark out of 100 (Add all the previous marks):100
*/ 

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class Cipher {
	final static String ALPHABET =" abcdefghijklmnopqrstuvwxyz";
	final static char[] ALPHABET_ARRAY=ALPHABET.toCharArray();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] cipherMapping = ALPHABET_ARRAY.clone();
		createCipher(cipherMapping);
		boolean finished = true;
		while (finished)
		{
			String input = JOptionPane.showInputDialog ("Enter a phrase you want to encrypt:");
		    try
			{
			    Scanner inputScanner = new Scanner (input);
			    if (inputScanner.hasNextLine())
			    {
					String userInput= inputScanner.nextLine();
					String plainText=userInput.toLowerCase();
					char[] plainTextArray = plainText.toCharArray();
					String encryptedPhrase = encrypt(plainTextArray, cipherMapping);
					JOptionPane.showMessageDialog(null,encryptedPhrase);
					inputScanner.close();
					int decryptConfirm = JOptionPane.showConfirmDialog(null, "Do you want to decrypt your phrase?", "Do you want to decrypt your phrase?", JOptionPane.YES_NO_OPTION);
					boolean decryptCommand = (decryptConfirm ==JOptionPane.YES_OPTION);
					if (decryptCommand)
					{
						JOptionPane.showMessageDialog(null, decrypt(encryptedPhrase, cipherMapping));
					}
				}
			    else if (input==null)
			    {
			    	JOptionPane.showMessageDialog(null, "Invalid Input. Please try again.");
			    }
			}
		    catch(NullPointerException exception)
			{
			   	JOptionPane.showMessageDialog(null, "Goodbye!");
		    	finished = false;
			}
		    catch(ArrayIndexOutOfBoundsException exception)
		    {
		    	JOptionPane.showMessageDialog(null, "Invalid Input. Please try again.");
		    }
		}
	}
	public static char[] createCipher (char[] array)
	{
		Random generator = new Random();
	    for (int index1 = array.length - 1; index1 > 0; index1--)
	    {
	    	int index2 = generator.nextInt(index1 + 1);
	    	char temp = array[index2];
	    	array[index2] = array[index1];
	    	array[index1] = temp;
		}
		return array;
	}
	public static String encrypt(char[] phraseArray, char[] cipherMapping)
	{
		String encryptedPhrase="";
		for (int index=0; index<phraseArray.length;index++)
		{
			int count=0;
			boolean finished=count<ALPHABET_ARRAY.length?true:false;
			while(finished)
			{
				if (ALPHABET_ARRAY[count]==phraseArray[index])
				{
					encryptedPhrase += cipherMapping[count];
					finished=false;
				}
				count++;
			}
		}
		return encryptedPhrase;
	}
	public static String decrypt(String encryptedPhrase, char[] cipherMapping)
	{
		String decryptedPhrase=" ";
		char[] encryptedArray = encryptedPhrase.toCharArray();
		for (int letter=0; letter<encryptedArray.length;letter++)
		{
			int index=0;
			boolean finished=index<cipherMapping.length?true:false;
			while(finished)
			{
				if (cipherMapping[index]==encryptedArray[letter])
				{
					decryptedPhrase += ALPHABET_ARRAY[index];
					finished=false;
				}
				index++;
			}
		}
		return decryptedPhrase;
	}
}
