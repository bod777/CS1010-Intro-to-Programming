/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7:7 ].
Comment: Yes, I have correctly defined ResolveBet in the way you outlined.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8:8 ].
Comment: Yes, ResolveBet does present the amount of cash and then asks the user for the bet input.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5:5 ].
Comment: Yes, I do check to make sure the amount is not greater than the cash in the wallet.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15:15 ]..
Comment: I do correctly create and roll three dice and I do create a sum variable.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20:19].
Comment: Yes, I do determine the winnings by comparing the bet type with the total, however, instead of topFace(), I use a variable I created for the triple bet.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10:10 ].
Comment: Yes, my program does do that.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15:15 ]
Comment:I do correctly ask for, create and set a wallet object.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5:4 ]
Comment: Yes, my program does continuously loop but instead of quit, the user can click cancel.
I ask the user to enter any of the four bet types or quit [Mark out of 5:5 ].
Comment: Yes, the user can choose any four bet types or leave the game.
My program calls resolveBet for each bet type entered [Mark out of 5:5 ].
Comment: Yes, my program does do that.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5:5 ]
Comment: Yes, my program does present a summary message.

 Total Mark out of 100 (Add all the previous marks): 97
*/
package chucALuck;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChucALuck {
	public static final String[] typesOfBets = { "Triple", "Field", "High", "Low" };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finished = false;
		while(!finished)
		{
			String walletInput = JOptionPane.showInputDialog(null, "How much money do you want to place in your wallet?");
			Scanner input1 = new Scanner(walletInput);
			if (walletInput==null)
	    	{
	    		JOptionPane.showMessageDialog(null, "Thanks for playing!");
	    		
	    	}
			else if (input1.hasNextDouble())
			{
				Wallet usersWallet = new Wallet();
				Double initialWallet = input1.nextDouble();
				usersWallet.put(initialWallet);
				input1.close();
				
				while(!finished)
				{
					if (usersWallet.check()>0)
					{
						JFrame frame = new JFrame("Input Dialog");
						String whichBet = (String) JOptionPane.showInputDialog(frame, "Which bet would you like to place?", "Type Of Bet", 
								JOptionPane.QUESTION_MESSAGE, null,  typesOfBets, typesOfBets[0]);
						if (whichBet==null)
						{
							JOptionPane.showMessageDialog(null, "Thanks for playing!");
							finished = true;	
						}
						else 
						{
							ResolveBet(whichBet, usersWallet);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You have no more cash in your wallet.");
						finished = true;
					}
				}
				
				JOptionPane.showMessageDialog(null, "You initially had €"+initialWallet+" in your Wallet. Now you have €"+usersWallet.check());
				JOptionPane.showMessageDialog(null, (initialWallet>=usersWallet.check())?("Therefore you have lost €"+(initialWallet-usersWallet.check())):
					("Therefore you have won €"+(usersWallet.check()-initialWallet))+". Goodbye!");
				finished=true;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid input. Please try again.");
			}
		}
	}
	public static void ResolveBet(String whichBet, Wallet usersWallet)
	{
		String cashQuestion = JOptionPane.showInputDialog("You have €"+usersWallet.check()+" in your wallet. How much money would you like to bet?");
		Scanner input2 = new Scanner(cashQuestion);
		Double cash = input2.nextDouble();
		if (cash<=usersWallet.check()) 
		{
			Dice dice1 = new Dice();
			Dice dice2 = new Dice();
			Dice dice3 = new Dice();
			int value1 = dice1.roll();
			int value2 = dice2.roll();
			int value3 =dice3.roll();
			int sum = value1+value2+value3;
			if (whichBet==typesOfBets[0])
			{
				if (value1==value2 && value1==value3 && (value1!=1 || value1!=6))
				{
					Double winnings = cash*30;
					JOptionPane.showMessageDialog(null, "You've won! Congrats. Your winnings are €"+winnings+".");
					usersWallet.put(winnings);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sadly, you've lost!");
					usersWallet.get(cash);
				}
			}
			else if (whichBet==typesOfBets[1])
			{
				if (sum<8||sum>12)
				{
					Double winnings = cash;
					JOptionPane.showMessageDialog(null, "You've won! Congrats. Your winnings are €"+winnings+".");
					usersWallet.put(winnings);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sadly, you've lost!");
					usersWallet.get(cash);
				}
			}
			else if (whichBet==typesOfBets[2])
			{
				if (sum>10 && !(value1==value2 && value1==value3 && (value1!=1 || value1!=6)))
				{
					Double winnings = cash;
					JOptionPane.showMessageDialog(null, "You've won! Congrats. Your winnings are €"+winnings+".");
					usersWallet.put(winnings);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sadly, you've lost!");
					usersWallet.get(cash);
				}
			}
			else
			{
				if (sum<11 && (value1==value2 && value1==value3 && (value1!=1 || value1!=6)))
				{
					Double winnings = cash;
					JOptionPane.showMessageDialog(null, "You've won! Congrats. Your winnings are €"+winnings+".");
					usersWallet.put(winnings);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sadly, you've lost!");
					usersWallet.get(cash);
				}
			}
		}
		else if (cash>usersWallet.check())
		{
			JOptionPane.showMessageDialog(null, "You do not have enough cash in your wallet to make this bet.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Input.");
		}
		input2.close();
	}
}
