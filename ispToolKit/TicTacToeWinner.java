//By: Sabrina Wasserman
//Date: April 30, 2015
//Title: Tic Tac Toe Winner
//Purpose: to inform the user of the winner of the tic tac toe game, then determine whether or not they would like to replay

package ispToolKit;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class TicTacToeWinner extends TicTacToeButtons3 implements ActionListener{

	//creating a static jframe
	static JFrame winner = new JFrame();
	
	TicTacToeWinner()
	{
		//preventing the blank game from reopening
		jframe.setVisible(false);
		
		//creating the jframe
		winner = new JFrame();
		winner.setSize(300, 100);
		winner.setLayout(new BorderLayout());
		winner.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		winner.setResizable(false);
		
		//creating a cool font for the you win message
		Font font = new Font("Verdana", Font.BOLD, 20);
		
		
		//telling the user that player 1 wins
			if (p1Wins == true)
			{
				//creating a jlabel
				JLabel p1Winner = new JLabel("Player One Wins!");
				p1Winner.setFont(font);
				winner.add(p1Winner, BorderLayout.CENTER);
			}
		
			//telling the user that player 2 wins	
			if (p2Wins == true)
			{
				//creating a jlabel
				JLabel p2Winner = new JLabel("Player Two Wins!");
				p2Winner.setFont(font);
				winner.add(p2Winner, BorderLayout.CENTER);
			}
		
			//Telling the user it was a cats game	
			if (catsGame == 9)
			{
				//creating a jlabel
				JLabel draw = new JLabel("It's a cat's game!");
				draw.setFont(font);
				winner.add(draw, BorderLayout.CENTER);
			}
		
			//creating a JPanel for the buttons
			JPanel buttonHolder = new JPanel();
			buttonHolder.setLayout(new BorderLayout());
			
			//creating buttons to restart the game
			JButton exit = new JButton("Exit Game");
			exit.addActionListener(this);
			buttonHolder.add(exit, BorderLayout.EAST);
			
			//play again code
			JButton playAgain = new JButton("Play Again");
			playAgain.addActionListener(this);
			buttonHolder.add(playAgain, BorderLayout.WEST);
		
		winner.add(buttonHolder, BorderLayout.SOUTH);
		winner.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		//exiting the game
		if (ae.getActionCommand().equalsIgnoreCase("Exit Game"))
		{
			
			winner.setVisible(false);
		
		}
		
		//replaying the game
		else if (ae.getActionCommand().equalsIgnoreCase("Play Again"))
		{
			winner.setVisible(false);

			//replaying the game
			TicTacToeButtons3 newGame = new TicTacToeButtons3();
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//new TicTacToeWinner();
	}

}
