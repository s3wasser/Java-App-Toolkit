//By: Sabrina Wasserman
//Date: April 30, 2015
//Title: Cystal Ball
//Purpose: to generate random responses to yes or no questions, supposedly telling the user their "fortune"
package ispToolKit;
import java.io.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.*;

public class CrystalBall implements ActionListener {

	//creating static jtextarea to be updated when fortune changes
	static JTextArea fortuneTold = new JTextArea();
	
	
	CrystalBall ()
	{
		
		//Creating the JFrame
			JFrame jframe = new JFrame();
			jframe.setSize(1200, 500);
			jframe.setLayout(new BorderLayout());
			jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			jframe.setResizable(false);

		//Creating JPanel to save instructions and welcome messsage
			JPanel welcomeInstructions = new JPanel();
			welcomeInstructions.setSize(750,200);
			welcomeInstructions.setLayout(new BorderLayout());
			
				
		//adding a JLabel to explain the Application
			JLabel welcome = new JLabel("Welcome to the Crystal Ball Fortune Teller!");
			Font font = new Font("Verdana", Font.BOLD, 25);
			welcome.setFont(font);
			welcome.setSize(new Dimension(25,50));
			
		//telling the user to press the button
			JLabel instructions = new JLabel("Ask the magic ball a yes or no question, then press the button to discover your fortune!");
			instructions.setForeground(Color.darkGray);
			Font font2 = new Font("Verdana", Font.BOLD, 14);
			instructions.setFont(font2);
			instructions.setSize(new Dimension(80,25));

	
		//Creating a JTextArea to generate the fortune
			fortuneTold = new JTextArea("");
			Font font3 = new Font("Verdana", Font.BOLD, 35);
			fortuneTold.setFont(font3);
			fortuneTold.setText("Your fortune will appear here!");
			fortuneTold.setSize(new Dimension(500,200));
			fortuneTold.setBackground(Color.GREEN);
			
			
		//Adding the welcome mesage and instructions to the Jpanel
			welcomeInstructions.add(welcome, BorderLayout.NORTH);
			welcomeInstructions.add(instructions, BorderLayout.CENTER);
			welcomeInstructions.add(fortuneTold, BorderLayout.PAGE_END);
			jframe.add(welcomeInstructions, BorderLayout.NORTH);
			
			
		//Inserting the crystal ball image
			ImageIcon icon = new ImageIcon("CrystalBallHands.gif");
			JLabel copyLabel = new JLabel(icon);
			jframe.add(copyLabel);
		
		//creating the button to generate the fortune
			JButton newFortune = new JButton("Click me for your fortune!");
			newFortune.setSize(30,5);
			newFortune.addActionListener(this);
			jframe.add(newFortune, BorderLayout.SOUTH);
	
	
	     
	     //setting the jframe to visible
	     jframe.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		//generating a random fortune
		if (ae.getActionCommand().equalsIgnoreCase("Click me for your fortune!"))
		{
			//updating the display to include the fortune
			fortuneGenerator();
		}
	}
	
	/*
	 * Title: fortuneGenerator
	 * Purpose: to use a random generator and switch statement to decide which fortune to give to the user
	 * @Param: none
	 * @Return: none
	 */
	public static void fortuneGenerator()
	{
		//creating a new random generator to choose the fortune
		Random generator = new Random();
		int randomNum = generator.nextInt(11);
		
		//creating a switch statement to return the fortune related to the random number
		switch (randomNum)
		{
		case 0: 
			fortuneTold.setText("Signs point to yes");
			break;
			
		case 1:
			fortuneTold.setText("That is a definite NO");
			break;
			
		case 2:
			fortuneTold.setText("I believe that the answer to your question is yes");
			break;
			
		case 3:
			fortuneTold.setText("Maybe...");
			break;
		
		case 4:
			fortuneTold.setText("THIS QUESTION UPSET THE CS RANDOM GENERATOR GODS. NEVER ASK IT AGAIN");
			break;
		
		case 5:
			fortuneTold.setText("I cannot be certain on this one...");
			break;
		
		case 6:
			fortuneTold.setText("Please ask again");
			break;
			
		case 7: 
			fortuneTold.setText("I cannot be 100% certain, but I believe the answer is yes");
			break;
		
		case 8: 
			fortuneTold.setText("Yes");
			break;
			
		case 9:
			fortuneTold.setText("The outlook is good");
			break;
			
		case 10:
			fortuneTold.setText("Very doubtful");
			break;
			
			
		}
		
		
	}
	
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		new CrystalBall();
	}

}
