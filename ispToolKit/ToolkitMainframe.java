//By: Sabrina Wasserman
//Date: April 30, 2015
//Title: Toolkit Mainframe
//Purpose: to act as a launcher for all of the ISP applications

package ispToolKit;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ToolkitMainframe implements ActionListener{
//creating static jframe
	static JFrame jframe;

	ToolkitMainframe () throws IOException
	{
		//Creating the JFrame
		jframe = new JFrame();
		jframe.setSize(630, 350);
		jframe.setLayout(new BorderLayout());
		jframe.setResizable(false);
		jframe.setBackground(Color.white);
		
		
		//creating a display to instruct the user to click an application
		JLabel instructions = new JLabel("Welcome! Please choose an application to begin");
		instructions.setForeground(Color.BLUE);
		instructions.setBackground(Color.WHITE);
		instructions.setOpaque(true);
		jframe.add(instructions, BorderLayout.NORTH);
		Font font = new Font("Verdana", Font.BOLD, 22);
		instructions.setFont(font);
		instructions.setSize(new Dimension(25,50));
		
		
		//creating a JPanel to have the buttons with the list of applications
		JPanel applicationButtons = new JPanel();
		applicationButtons.setLayout(new GridLayout(4,2,10,5));
		applicationButtons.setBackground(Color.WHITE);
		
		//creating an array to store and print the buttons
		JButton [] applications = new JButton [6];
		
		String[] buttonApplicationValues = {"Change Counter", "Calculator", "Tic-Tac-Toe", 
				  "Crystal Ball","To-Do Lists", "Exit Toolkit"};
		
		//using a loop to add the applicaiton values into buttons, and add them to the jpanel
		for(int i = 0; i<buttonApplicationValues.length; i++)
		{
			applications[i] = new JButton(buttonApplicationValues[i]);
			applications[i].addActionListener(this);
			applications[i].setForeground(Color.BLUE);
			applicationButtons.add(applications[i]);					
		}
		
		//setting the jpanel visible to true
		
		jframe.add(applicationButtons, BorderLayout.CENTER);
		
		//adding an image
		BufferedImage myPicture = ImageIO.read(new File("my logo.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		jframe.add(picLabel, BorderLayout.PAGE_END);
		
		
		//setting the jframe to visible
		jframe.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//playing the crystal ball
		if (ae.getActionCommand().equalsIgnoreCase("Crystal Ball"))
		{
			CrystalBall fortunes = new CrystalBall();
		}
		
		//playing the change counter
		else if (ae.getActionCommand().equalsIgnoreCase("Change Counter"))
		{
			ChangeCounter change = new ChangeCounter();
			
		}
		
		//playing tic tac toe
		else if (ae.getActionCommand().equalsIgnoreCase("Tic-Tac-Toe"))
		{
			TicTacToeButtons3 game = new TicTacToeButtons3();
		}
		
		//playing the to do list
		else if (ae.getActionCommand().equalsIgnoreCase("To-Do Lists"))
		{
			ToDoList todo = new ToDoList();
		}
		
		//playing the calculator
		else if (ae.getActionCommand().equalsIgnoreCase("Calculator"))
		{
				Calc calculate = new Calc();	
		}
		
		
		//exiting the toolkit
		else if (ae.getActionCommand().equalsIgnoreCase("Exit Toolkit"))
		{
			//exiting the program is the user decides to quit
			jframe.setVisible(false);
			System.exit(0);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		new ToolkitMainframe();
		
		
		
	}

	

}
