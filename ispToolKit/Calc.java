//By: Sabrina Wasserman
//Title: Calc
//Purpose: to create a calculator using swing to perform basic calculations
//Date: April 13, 2015
package ispToolKit;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
public class Calc implements ActionListener{
	
	//creating static display
	static JTextArea display = new JTextArea();
	
	//creating static jframe and buttons
	JFrame jfrm = new JFrame("Calc");
	JButton[] buttons = new JButton[20];

	
	//Creating static variables to save numbers within the calculation
	static double first= -1;
	static double second = -1;

	
	//Creating static variable to save value for the memory button
	static double memory = 0;
	
	
	Calc(){
		
		//creating the JFrame window
				//using boreder layout to organize parts of the calculator
		jfrm.setLayout(new BorderLayout());
		jfrm.setSize(350,300);
		jfrm.setDefaultCloseOperation(jfrm.DISPOSE_ON_CLOSE);
		
		//Creating the panel for the buttons
		JPanel buttonsPanel = new JPanel();
				//panel will have 5 rows, 4 columns
		buttonsPanel.setLayout(new GridLayout(5,4,3,3));
		String[] buttonValues = {"7", "8", "9","/", 
								  "4","5","6","*",
								  "1","2","3","-",
								  ".","0","MEMORY","+",
								  "C","Pi","SQRT","="};
		
		
		//Using a for loop to create the buttons
		for(int i = 0; i<20; i++)
		{
			buttons[i] = new JButton(buttonValues[i]);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.MAGENTA);
			buttonsPanel.add(buttons[i]);					
		}
		
		//Making the calculator colourful :)
		buttonsPanel.setBackground(Color.RED);
		display.setForeground(Color.BLUE);
		display.setBackground(Color.PINK);
	
		//changing font 
		Font font = new Font("Verdana", Font.BOLD, 50);
		display.setFont(font);
		display.setSize(new Dimension(25,300));

		//adding the buttons to the calculator
		jfrm.add(buttonsPanel, BorderLayout.SOUTH);
		jfrm.add(display, BorderLayout.CENTER);
		
		//setting jframe to visible
		jfrm.setVisible(true);
		
	}
	
	//creating a method for action listener
	public void actionPerformed(ActionEvent ae)
	{
		//Updating the display
		display.append(ae.getActionCommand());
				
		//changing value and display when Pi is hit
		if (ae.getActionCommand().equalsIgnoreCase("Pi"))
		{
			for (int i = 0; i<display.getText().length(); i++)
			{
				//getting rid of the Pi and changing it to 3.14159
				int indexOfPi = display.getText().indexOf("P");
				
				if (display.getText().length() > 2)
				{
					String valuesBeforePi = (display.getText()).substring(0, indexOfPi);
					display.setText(valuesBeforePi);
				}
					//updating the display
					display.append("3.14159");
			}
		}
			
			//changing value and display when memory button is hit
		if (ae.getActionCommand().equalsIgnoreCase("MEMORY"))
			{
				for (int i = 0; i<display.getText().length(); i++)
				{
					//getting rid of the memory and changing it to it's value
				
					int indexOfMemory = display.getText().indexOf("M");
					
					//updating the display to include the remembered number
					String valuesBeforeMemory = (display.getText()).substring(0, indexOfMemory);
					display.setText(valuesBeforeMemory);
					
					//parsing memory to string 
					String memoryWord = ""+memory;
					System.out.println("memoryWord");
					
					display.append(memoryWord);
						
					
				}
			}
		
		
		
		
		
		//performing the calculation when the user hits the "=" buttons
		if (ae.getActionCommand().equalsIgnoreCase("="))
		{
			//run a new method to do the calculation
			//creating a loop to check the values of the entered number for mathematical symbols
		
			for (int i=0; i<(display.getText()).length(); i++)
			{
				
				if ((display.getText().charAt(i)+("")).equalsIgnoreCase("+"))
				{
			
					display.append(""+addition());
				}
				
				//running subtraction method
				else if ((display.getText().charAt(i)+("")).equalsIgnoreCase("-"))
				{
					
					display.append(""+subtraction());
				}
				
				//running division method
				else if ((display.getText().charAt(i)+("")).equalsIgnoreCase("/"))
				{
					
					display.append(""+division());
				}
				
				//running multiplication method
				else if ((display.getText().charAt(i)+("")).equalsIgnoreCase("*"))
				{
				
					display.append(""+multiplication());
				}
				else if ((display.getText().charAt(i)+("")).equalsIgnoreCase("S"))
				{
					display.append(""+squareRoot());
				}
	
				
			}
			
		}
			
		
		//using a loop to see if the values need to be reset
		for (int z=0; z<(display.getText()).length(); z++)
		{
			if ((display.getText().charAt(z)+("")).equalsIgnoreCase("C"))
			{
				display.setText("");
			}
		
		}
		
		}

	/*
	 * Title: addition
	 * Purpose: to perform the calculation
	 * @Param: none
	 * @Return: double answer
	 */
	public static double addition()
	{
		//getting the values in the display
		int plusLocation = (display.getText()).indexOf("+");
		int equalsLocation = (display.getText()).indexOf("=");
		String num1 = (display.getText()).substring(0,plusLocation);
		String num2 = (display.getText()).substring(plusLocation+1,equalsLocation);
		
		//parsing the number
		first = Double.parseDouble(num1);
		second = Double.parseDouble(num2);
		
		//updating memory
		memory = (first+second);
		
		return first+second;
	}
	

	/*
	 * Title: subtraction
	 * Purpose: to perform the calculation
	 * @PAram: none
	 * @Return: double answer
	 */
	public static double subtraction()
	{
		//getting the values in the display
		int minusLocation = (display.getText()).indexOf("-");
		int equalsLocation = (display.getText()).indexOf("=");
		String num1 = (display.getText()).substring(0,minusLocation);
		String num2 = (display.getText()).substring(minusLocation+1,equalsLocation);
		
		//parsing the number
		first = Double.parseDouble(num1);
		second = Double.parseDouble(num2);
		
		//updating memory
		memory = (first-second);
		
		return first-second;
	}
	
	/*
	 * Title: division
	 * Purpose: to perform the calculation
	 * @Param: none
	 * @Return: double answer
	 */
	public static double division()
	{
		//getting the values in the display
		int divisionLocation = (display.getText()).indexOf("/");
		int equalsLocation = (display.getText()).indexOf("=");
		String num1 = (display.getText()).substring(0,divisionLocation);
		String num2 = (display.getText()).substring(divisionLocation+1,equalsLocation);
		
		//parsing the number
		first = Double.parseDouble(num1);
		second = Double.parseDouble(num2);
		
		//updating memory
		memory = (first/second);
		
		return (first/second);
	}
	
	
	/*
	 * Title: multiplication
	 * Purpose: to perform the calculation
	 * @PAram: none
	 * @Return: double answer
	 */
	public static double multiplication()
	{
		//getting the values in the display
		int multiplicationLocation = (display.getText()).indexOf("*");
		int equalsLocation = (display.getText()).indexOf("=");
		String num1 = (display.getText()).substring(0,multiplicationLocation);
		String num2 = (display.getText()).substring(multiplicationLocation+1,equalsLocation);
		
		//parsing the number
		first = Double.parseDouble(num1);
		second = Double.parseDouble(num2);
		
		//updating memory value
		memory = (first*second);
		return (first*second);
	}
	
	
	/*
	 * Title: squareRoot
	 * Purpose: to perform the squareRoot calculation
	 * @PAram: none
	 * @Return: double answer
	 */
	public static double squareRoot()
	{
		//getting the values in the display
		int equalsLocation = (display.getText()).indexOf("=");
		int tLocation = (display.getText()).indexOf("T");
		String numberToSquare = display.getText().substring((tLocation+1), (equalsLocation));
		
		//parsing the number
		first = Double.parseDouble(numberToSquare);
		
		//square Rooting the number
		double squareRootedNumber = Math.sqrt(first);
		
		//updating memory
		memory = squareRootedNumber;
		
		return (squareRootedNumber);
	}
	
	
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		new Calc();
	}

}
