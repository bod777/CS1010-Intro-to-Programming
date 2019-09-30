import javax.swing.JOptionPane;

public class Vertebrate_YesOrNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String correctVertebrate = "";
		int bloodAnswer = JOptionPane.showConfirmDialog(null, "Is the vertebrate warm blooded?");
		boolean warmBlooded = (bloodAnswer ==JOptionPane.YES_OPTION);
		
		if(warmBlooded==true)
		{
			int featherAnswer = JOptionPane.showConfirmDialog(null, "Does the vertebrate have "
					+ "feathers?");
			boolean hasFeathers = (featherAnswer==JOptionPane.YES_OPTION);
			
			if(hasFeathers==true)
			{
				correctVertebrate ="bird";
			}
			else
			{
				correctVertebrate = "mammal";
			}
		}
		else
		{
			int finAnswer=JOptionPane.showConfirmDialog(null, "Does the vertabrate have fins?" );
			boolean hasFins = (finAnswer == JOptionPane.YES_OPTION);
			
			if(hasFins==true)
			{
				correctVertebrate = "fish";
			}
			else
			{
				int scaleAnswer=JOptionPane.showConfirmDialog(null,  "Does the vertabrate have "
						+ "scales?");
				boolean hasScales=(scaleAnswer==JOptionPane.YES_OPTION);
				if (hasScales==true)
				{
					correctVertebrate="Reptile";
				}
				else
				{
					correctVertebrate="Amphibian";
				}
			}
		}
		JOptionPane.showMessageDialog(null, "The vertebrate you are describing is a " + 
			correctVertebrate) ;
	}

}
