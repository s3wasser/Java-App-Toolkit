//By: Sabrina Wasserman
//Date: April 30, 2015
//Title: Change Counter
//Purpose: to count the dollar value of the user's change
package ispToolKit;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class ChangeCounter implements ActionListener{

	//Creating static variables for the JTextAreas to be manipulated later
	static JTextArea enterPennies;
	static JTextArea enterNickels;
	static JTextArea enterDimes;
	static JTextArea enterQuarters;
	static JTextArea enterLoonies;
	static JTextArea enterToonies;
	
	//Creating a static display to update the total
	static JLabel totalDisplay;
	
	//creating global counter variable to see if all the values are correct
	static boolean calculateOkay = false;
	
	//creating global variables to save all of the parsed values for the numbers
	static int totalPennies;
	static int totalNickels;
	static int totalDimes;
	static int totalQuarters;
	static int totalLoonies;
	static int totalToonies;
	
	
	ChangeCounter()
	{
		//Creating the JFrame
		JFrame jframe = new JFrame();
		jframe.setSize(500,300);
		jframe.setLayout(new GridLayout(10,1, 5, 5));
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setResizable(false);
		
		//creating the JLabel with the Welcome message
		JLabel welcome = new JLabel("Welcome to the Change Counter!");
		welcome.setForeground(Color.darkGray);
		Font font = new Font("Verdana", Font.BOLD, 20);
		welcome.setFont(font);
		
		//creaing the JLabel with the instructions
		JLabel instructions = new JLabel("Enter the number of coins in the provided boxes. If there are none, enter a 0");
		instructions.setBackground(Color.RED);

		
		//creating the pennies JPanel
		JPanel pennies = new JPanel();
		pennies.setLayout(new BorderLayout());
	
		//creating the jlabel to ask the user to enter the number of pennies	
		JLabel howManyPennies = new JLabel("Please enter the amount of pennies:");
		pennies.add(howManyPennies, BorderLayout.WEST);
		
		//creating the jtext area for the user to add the number of pennies
		enterPennies = new JTextArea("Enter the number of pennies here");
		enterPennies.setBackground(Color.LIGHT_GRAY);
		pennies.add(enterPennies, BorderLayout.CENTER);
		

		//creating the nickels JPanel
		JPanel nickels = new JPanel();
		nickels.setLayout(new BorderLayout());
	
		//creating the jlabel to ask the user to enter the number of dimes
		JLabel howManyNickels = new JLabel("Please enter the amount of nickels: ");
		nickels.add(howManyNickels, BorderLayout.WEST);
		
		//creating the jtext area for the user to add the number of pennies
		enterNickels = new JTextArea("Enter the number of nickels here");
		enterNickels.setBackground(Color.LIGHT_GRAY);
		nickels.add(enterNickels, BorderLayout.CENTER);
		

		//creating the dimes JPanel
		JPanel dimes = new JPanel();
		dimes.setLayout(new BorderLayout());
	
		//creating the jlabel to ask the user to enter the number of dimes
		JLabel howManyDimes = new JLabel("Please enter the amount of dimes:   ");
		dimes.add(howManyDimes, BorderLayout.WEST);
		
		//creating the jtext area for the user to add the number of dimes
		enterDimes = new JTextArea("Enter the number of dimes here");
		enterDimes.setBackground(Color.LIGHT_GRAY);
		dimes.add(enterDimes, BorderLayout.CENTER);
		
		
		//creating the quarters JPanel
		JPanel quarters = new JPanel();
		quarters.setLayout(new BorderLayout());
			
		//creating the jlabel to ask the user to enter the number of quarters
		JLabel howManyQuarters = new JLabel("Please enter the amount of quarters:");
		quarters.add(howManyQuarters, BorderLayout.WEST);
		
		//creating the jtext area for the user to add the number of quarters
		enterQuarters = new JTextArea("Enter the number of quarters here");
		enterQuarters.setBackground(Color.LIGHT_GRAY);
		quarters.add(enterQuarters, BorderLayout.CENTER);
		
		
		//creating the loonies JPanel
		JPanel loonies = new JPanel();
		loonies.setLayout(new BorderLayout());
					
		//creating the jlabel to ask the user to enter the number of loonies
		JLabel howManyLoonies = new JLabel("Please enter the amount of loonies: ");
		loonies.add(howManyLoonies, BorderLayout.WEST);
				
		//creating the jtext area for the user to add the number of loonies
		enterLoonies = new JTextArea("Enter the number of loonies here");
		enterLoonies.setBackground(Color.LIGHT_GRAY);
		loonies.add(enterLoonies, BorderLayout.CENTER);
		
		//creating the toonies JPanel
		JPanel toonies = new JPanel();
		toonies.setLayout(new BorderLayout());
					
		//creating the jlabel to ask the user to enter the number of loonies
		JLabel howManyToonies = new JLabel("Please enter the amount of toonies: ");
		toonies.add(howManyToonies, BorderLayout.WEST);
				
		//creating the jtext area for the user to add the number of loonies
		enterToonies = new JTextArea("Enter the number of toonies here");
		enterToonies.setBackground(Color.LIGHT_GRAY);
		toonies.add(enterToonies, BorderLayout.CENTER);
		
		
		//creating the JButton to generate the coin values
		JButton calculateMoney = new JButton("Calculate Amount!");
		calculateMoney.addActionListener(this);
		
		//creating a JLabel to display the total ammount of money
		totalDisplay = new JLabel("Your Total Amount is: ");
		totalDisplay.setForeground(Color.RED);
	
		
		
		
		//adding all of the panels to the jframe
		jframe.add(welcome);
		jframe.add(instructions);
		jframe.add(pennies);
		jframe.add(nickels);
		jframe.add(dimes);
		jframe.add(quarters);
		jframe.add(loonies);
		jframe.add(toonies);
		jframe.add(calculateMoney);
		jframe.add(totalDisplay);
		jframe.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//Will run once the user is ready to calculate
		if (ae.getActionCommand().equalsIgnoreCase("Calculate Amount!"))
		{
			//resetting the calculation okay value to have the computer recheck if the calculation can occur
			calculateOkay = false;
			
			//calling the calculation method
			calculateAmount();
		}
	}
	
	/*
	 * Title: calculateAmmount
	 * Purpose: to calculate the total monetary value of the coins entered
	 * @Param: none
	 * @Return: none
	 */
	
	public static void calculateAmount()
	{
		
		//using a try box incase the user enters a double or a string instead of a number
		try
		{
		//parsing the pennies to an integer
		String pennieString = enterPennies.getText();
		totalPennies = Integer.parseInt(pennieString);
		
		//parsing the nickels to an integer
		String nickelString = enterNickels.getText();
		totalNickels = Integer.parseInt(nickelString);
		
		//parsing the dimes to an integer
		String dimeString = enterDimes.getText();
		totalDimes = Integer.parseInt(dimeString);
		
		//parsing the quarters to an integer
		String quarterString = enterQuarters.getText();
		totalQuarters = Integer.parseInt(quarterString);
		
		//parsing the loonies to an integer
		String loonieString = enterLoonies.getText();
		totalLoonies = Integer.parseInt(loonieString);
		
		//parsing the toonies
		String toonieString = enterToonies.getText();
		totalToonies = Integer.parseInt(toonieString);
		
		//updating the check complete variable to check if the calculations can be performed
		calculateOkay = true;
		
		}
		catch (InputMismatchException e)
		{
			totalDisplay.setText("You have entered a letter or symbol in place of a number. Please reenter your numbers and resubmit.");
		}
		
		catch (Exception e)
		{
			totalDisplay.setText("You have entered an invalid value. Please reenter your numbers and resubmit.");
		}
		
		
		//performing the calculations if all the values were parsed correctly
		if (calculateOkay ==true)
		{
		double totalMoney = (totalPennies * 0.01) + (totalNickels * 0.05) + (totalDimes * 0.10) + (totalQuarters * 0.25) + (totalLoonies * 1.00) + (totalToonies * 2.00);
		totalDisplay.setText("Your Total Amount is: $" +totalMoney);
		
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ChangeCounter();
		
		
	}


}
