/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
   4. Did I read the input correctly from the user using appropriate questions? 
       Mark out of 20: 20
   5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
       Mark out of 30: 29
   6. Did I output the correct answer for each possibility in an easy to read format? 
       Mark out of 15: 14
   7. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 98
*/
import javax.swing.JOptionPane;
public class Umbrella {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String umbrellaCommands = "";
		int answer1 = JOptionPane.showConfirmDialog(null, "Is it raining outside?");
		boolean itIsRaining = (answer1 == JOptionPane.YES_OPTION);
				
		if(itIsRaining)
		{
			umbrellaCommands = "You should bring your umbrella and put it up.";
		}
		else
		{
			int answer2 =JOptionPane.showConfirmDialog(null, "Does it look like its going to rain?");
			boolean looksLikeRain = (answer2 == JOptionPane.YES_OPTION);
			
			if (looksLikeRain)
			{
				umbrellaCommands ="You should bring your umbrella.";
			}
			else
			{
				umbrellaCommands ="Don't bring your umbrella.";
			}
		}
		JOptionPane.showMessageDialog(null, umbrellaCommands );
	}

}