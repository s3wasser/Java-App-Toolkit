//By: Sabrina Wasserman
//Date: April 30, 2015
//Title: To Do List
//Purpose: allows the user to create to do lists, which can be exported to text files by calling another class

package ispToolKit;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
public class ToDoList extends JPanel implements ActionListener {

	//creating static jframe
	public static JFrame jframe = new JFrame();

	//creating a static array list to save the values in the to do list
	public static ArrayList <String> listItems = new ArrayList ();
	
	//creating String to save title name
	public static String documentTitle;
	
	//creating static user Jtextareas to be manipulated in other methods
	public static JTextArea userEnterItem;
	public static JTextArea userEnterTitle;
	

	//creating a counter to add the number of 
	static int counter = 1;
	
	ToDoList() 
	{
		//Creating the JFrame
		jframe.repaint();
		jframe.setSize(800,500);
		jframe.setLayout(new BorderLayout());
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setResizable(false);
		
		//creating a jpanel
		JPanel wholeProgram = new JPanel();
		wholeProgram.setLayout(new GridLayout(7,1,5,5));
		

		//Welcoming the user with a JLabel
		JLabel welcome = new JLabel("Welcome to the To-Do List Maker!");
		welcome.setForeground(Color.darkGray);
		Font font = new Font("Verdana", Font.BOLD, 40);
		welcome.setFont(font);
		
		//creating a JPanel to save the instructions in this ISP
		JPanel instructions = new JPanel (new GridLayout(2,1,3,3));
		
		
		//Explaining the program to the user in a jlabel
		JLabel instruct1 = new JLabel("In this program, you can enter values to be saved to a to-do list text file");
		JLabel instruct2 = new JLabel("When you are finished and submit your list, the file will be saved to your desktop!");
		Font fontInstructions = new Font("Verdana", Font.ITALIC, 17);
		instruct1.setFont(fontInstructions);
		instruct2.setFont(fontInstructions);
		instructions.add(instruct1);
		instructions.add(instruct2);

		
		//Creating the JPanel for the user to enter their document title
		JPanel enterTitle = new JPanel(new BorderLayout());
		
		//adding JLabel teling the user to enter the title of their document
		JLabel titleAsk = new JLabel("Enter List Title");
		titleAsk.setForeground(Color.darkGray);
		Font font2 = new Font("Verdana", Font.BOLD, 20);
		titleAsk.setFont(font2);
		enterTitle.add(titleAsk, BorderLayout.NORTH);
	
		//adding the JTextArea where the user can enter 
		userEnterTitle = new JTextArea("enter your title here");
		Font font3 = new Font("Verdana", Font.BOLD, 14);
		userEnterTitle.setFont(font3);
		userEnterTitle.setBackground(Color.PINK);
		enterTitle.add(userEnterTitle, BorderLayout.CENTER);
		
	
		//creating JPanel with button to submit
		JPanel submissionTitleButton = new JPanel(new BorderLayout());
		
		//adding a Jlabel with instructions for resubmitting title
		JLabel resubmitTitle = new JLabel("If you wish to re-enter the title of your list, simply resubmit the title");
		resubmitTitle.setForeground(Color.darkGray);
		submissionTitleButton.add(resubmitTitle, BorderLayout.NORTH);
		
		
		
		//creating JButton to have the user submit the title name
		JButton submitTitle = new JButton("Submit Title");
		submitTitle.setSize(20,20);
		submitTitle.addActionListener(this);
		submissionTitleButton.add(submitTitle, BorderLayout.WEST);
		
		//creating a blank JLabel to make the submit title align right
		JLabel placeHolder = new JLabel("                                  ");
		submissionTitleButton.add(placeHolder, BorderLayout.CENTER);
		
		

		
		//creating JPanel to get user to enter value for the list
		JPanel enterListValues = new JPanel(new BorderLayout());
		
		//adding the Jlabel telling the user to enter the next item on the to do list
		JLabel itemAsk = new JLabel("Enter The Next Item in the List");
		itemAsk.setForeground(Color.darkGray);
		itemAsk.setFont(font2);
		enterListValues.add(itemAsk, BorderLayout.NORTH);
		
		//adding the JTextArea where the user can enter 
		userEnterItem = new JTextArea("enter your item here");
		userEnterItem.setFont(font3);
		userEnterItem.setBackground(Color.PINK);
		enterListValues.add(userEnterItem, BorderLayout.CENTER);
		
		//creating JPanel to add the button for submitting an item to the list
		JPanel submissionListButton = new JPanel(new BorderLayout());
		
		//creating the button to submit the list item
		JButton submitListItem = new JButton("Submit Item");
		submitListItem.addActionListener(this);
		submitListItem.setSize(20,20);
		submissionListButton.add(submitListItem, BorderLayout.WEST);
		
		//creating a blank JLabel to make the submit title align right
		JLabel placeHolder2 = new JLabel("                                         ");
		submissionListButton.add(placeHolder2, BorderLayout.CENTER);

		
		//creating the JPanel and Jbutton to create the list 
		JPanel finalButtonSaver = new JPanel(new BorderLayout());
		JButton listDone = new JButton("List Completed");
		listDone.addActionListener(this);
		finalButtonSaver.add(listDone, BorderLayout.NORTH);
		
		
		
		//adding all componenets to the jpanel
		wholeProgram.add(welcome);
		wholeProgram.add(instructions);
		wholeProgram.add(enterTitle);
		wholeProgram.add(submissionTitleButton);
		wholeProgram.add(enterListValues);
		wholeProgram.add(submissionListButton);
		wholeProgram.add(finalButtonSaver);
		
		//adding jpanel to the jframe
		jframe.add(wholeProgram, BorderLayout.CENTER);
		
		//setting the jframe to visible
		jframe.setVisible(true);
		
	}
	
	
	
	public void actionPerformed (ActionEvent ae)
	{
		if (ae.getActionCommand().equalsIgnoreCase("Submit Title"))
		{
			//updating the value of the title for the directory
			documentTitle = userEnterTitle.getText();
			userEnterTitle.setText("");
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Submit Item"))
		{
			//saving the item to the arraylist
			listItems.add(userEnterItem.getText());
			userEnterItem.setText("");
		
		}
		else if (ae.getActionCommand().equalsIgnoreCase("List Completed"))
		{
			//running the class to save the values into a separate file
			jframe.dispatchEvent(new WindowEvent(jframe, WindowEvent.WINDOW_CLOSING));
			
			try 
			{
				ToDoIOSaver saveList = new ToDoIOSaver();
			} 
			
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		new ToDoList();
	}

}
