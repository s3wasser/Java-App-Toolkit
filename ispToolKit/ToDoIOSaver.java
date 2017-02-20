//By: Sabrina Wasserman
//Date: April 30, 2015
//Title: To Do IO Saver
//Purpose: to take in the values inputted by the to do list maker application and save them to a text file

package ispToolKit;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class ToDoIOSaver extends ToDoList implements ActionListener{

	//creating a static jframe
	static JFrame newList = new JFrame();
	
	
	ToDoIOSaver() throws IOException 
	{
		//preventing the jframe from reopening
		jframe.setVisible(false);
		
		
		//setting fw and pw
		FileWriter fw = new FileWriter ("/Users/Sabrina/Desktop/"+documentTitle+".txt");
		PrintWriter pw = new PrintWriter(fw);
	
		//running a loop to save each value of the array list to a new line in the documnent
		for (int i = 0; i<listItems.size(); i++)
		{
			pw.println(listItems.get(i));
		}
		//closing the print writer
		pw.close();
		
		
		//creating the jframe
		newList.setSize(300, 100);
		newList.setLayout(new BorderLayout());
		newList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		newList.setResizable(false);
				
		//creating a cool font 
		Font font = new Font("Verdana", Font.BOLD, 20);
		
		//creating a jlabel to ask the user if they want to make another list
		JLabel listAsk = new JLabel("List Completed!");
		listAsk.setFont(font);
		newList.add(listAsk, BorderLayout.CENTER);
		
		//creating buttons to create new list or end the list program
		//creating a JPanel for the buttons
		JPanel buttonHolder = new JPanel();
		buttonHolder.setLayout(new BorderLayout());
		
		//creating buttons to exit the game
		JButton exit = new JButton("Exit");
		exit.addActionListener(this);
		buttonHolder.add(exit, BorderLayout.EAST);
		
		//creating the button to make another list
		JButton playAgain = new JButton("Make Another List");
		playAgain.addActionListener(this);
		buttonHolder.add(playAgain, BorderLayout.WEST);
	
		//adding it to the jframe and making it visible
		newList.add(buttonHolder, BorderLayout.SOUTH);
		newList.setVisible(true);
	}
		
		public void actionPerformed(ActionEvent ae)
		{
			//exiting the program
			if (ae.getActionCommand().equalsIgnoreCase("Exit"))
			{
				
				newList.setVisible(false);
			
			}
			
			//replaying the game
			else if (ae.getActionCommand().equalsIgnoreCase("Make Another List"))
			{
				jframe.dispatchEvent(new WindowEvent(jframe, WindowEvent.WINDOW_CLOSING));
				newList.setVisible(false);

				//replaying the to do list maker
				ToDoList replay = new ToDoList();
			}
		}

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//new ToDoIOSaver();
		
	}

}
