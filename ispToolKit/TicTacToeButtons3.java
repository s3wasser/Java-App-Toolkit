//By: Sabrina Wasserman
//Date: April 30, 2015
//Title: Tic Tac Toe Buttons 3
//Purpose: to allow the user to t=play multiplayer tic tac toe!

package ispToolKit;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TicTacToeButtons3 implements ActionListener {

	//creating static JPanel to hold the game board visual
		JPanel boardVisual = new JPanel();
		static JButton [] [] gameBoard = new JButton [3] [3];
		static JFrame jframe;
		static int playerGoing = 1;
		
	//creating static variables to see if player one wins
		public static boolean p1Wins = false;
		
	//creating static variables to see if player two wins
		public static boolean p2Wins = false;
		
	//creating a variable to see if it is a cats game
		public static int catsGame = 0;
		
		
	TicTacToeButtons3 () 
	{
		//Creating the JFrame
		//NOTE: jframe is set to dispose on close and not exit on close so that it only closes this part of the toolkit, not the entire thing
	jframe = new JFrame();
	jframe.setSize(400, 450);
	jframe.setLayout(new BorderLayout());
	jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	jframe.setResizable(false);
	
	//setting the boardVisual display to grid layout
	boardVisual.setLayout(new GridLayout(3, 3, 5, 5));
	boardVisual.setBackground(Color.LIGHT_GRAY);
	
	//adding a JPanel with instructions
	JPanel instructions = new JPanel();
	
	//creating jlabels with the instructions
	JLabel instruct1 = new JLabel("Welcome to Tic Tac Toe!");
	JLabel instruct2 = new JLabel("This is a 2 player game! Click the square you wish to place your piece on");
	JLabel instruct3 = new JLabel("If you get 3 squares in a row, you win!");
	Font introFont = new Font("Verdana", Font.BOLD, 20);
	Font fontInstructions = new Font("Verdana", Font.ITALIC, 17);
	
	//changing the jlabels fonts
	instruct1.setFont(introFont);
	instruct2.setFont(fontInstructions);
	instruct3.setFont(fontInstructions);
	
	//adding the jlabels to the instructions
	instructions.add(instruct1, BorderLayout.NORTH);
	instructions.add(instruct2, BorderLayout.CENTER);
	instructions.add(instruct3, BorderLayout.PAGE_END);
	instructions.setBackground(Color.orange);

	//adding instructions to the jframe
	jframe.add(instructions, BorderLayout.PAGE_START);
	
	//creating JButtons for each coordinate
		//numberFillCounter will give each JButton a number to hold to be identified when clicked by the action listener
	int numberFillCounter = 1;
	
	for (int i = 0; i<gameBoard.length; i++)
	{
		for (int z = 0; z<gameBoard[i].length ;z++)
		{
			//filling in the buttons with numbers and creating the action listeners
			gameBoard[i][z] = new JButton(numberFillCounter+"");
			gameBoard[i][z].setOpaque(true);
			gameBoard[i][z].setForeground(Color.WHITE);
			gameBoard[i][z].addActionListener(this);
			gameBoard[i][z].setBorderPainted(false);
			boardVisual.add(gameBoard[i][z]);
			
			//increasing the counter
			numberFillCounter++;
		}
	}
	//adding JPanel to jframe
	jframe.add(boardVisual, BorderLayout.CENTER);
	
	//making the jframe visible
	jframe.setVisible(true);
	
	
	
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getActionCommand().equalsIgnoreCase("1"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[0][0].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[0][0].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[0][0].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[0][0].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[0][0].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		
		}
		else if (ae.getActionCommand().equalsIgnoreCase("2"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[0][1].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[0][1].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[0][1].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[0][1].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[0][1].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		else if (ae.getActionCommand().equalsIgnoreCase("3"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[0][2].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[0][2].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[0][2].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[0][2].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[0][2].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		
		else if (ae.getActionCommand().equalsIgnoreCase("4"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[1][0].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[1][0].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[1][0].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[1][0].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[1][0].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		
		else if (ae.getActionCommand().equalsIgnoreCase("5"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[1][1].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[1][1].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[1][1].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[1][1].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[1][1].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		
		else if (ae.getActionCommand().equalsIgnoreCase("6"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[1][2].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[1][2].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[1][2].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[1][2].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[1][2].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		
		else if (ae.getActionCommand().equalsIgnoreCase("7"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[2][0].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[2][0].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[2][0].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[2][0].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[2][0].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		
		else if (ae.getActionCommand().equalsIgnoreCase("8"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[2][1].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[2][1].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[2][1].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[2][1].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[2][1].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		
		else if (ae.getActionCommand().equalsIgnoreCase("9"))
		{
			//if player one had entered the space
			if ((playerGoing%2)!=0)
			{
				//changing color of the space
				gameBoard[2][2].setBackground(Color.RED);
				
				//changing the text so that the button cannot be repressed
					//using p1 so that when checking who won, i can see player one hit this square
				gameBoard[2][2].setText("p1");
			}
			else
			{
				//changing color of the space
				gameBoard[2][2].setBackground(Color.BLUE);
				
				//changing the text so that the button cannot be repressed
					//using p2 so that when checking who won, i can see player two hit this square
				gameBoard[2][2].setText("p2");
			}
			
		//repainting the frame and array to show changes
		gameBoard[2][2].repaint();
		jframe.repaint();
		
		//updating playergoing
		playerGoing++;
		
		//checking if a player won
		playerWin();
		}
		
		
	}
	
	/*
	 * Title: playerWin
	 * Purpose:to check if a player has one after each move had been made
	 * @Param: none
	 * @Return: none
	 */
	public static void playerWin()
	{
		//checking if row 1 is a winner for player 1
		if (gameBoard[0][0].getActionCommand().equalsIgnoreCase("p1"))
		{
			if (gameBoard[0][1].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[0][2].getActionCommand().equalsIgnoreCase("p1"))
				{
					p1Wins = true;
				}
			}
		}
		
		//checking if row 1 is a winner for p2
		if (gameBoard[0][0].getActionCommand().equalsIgnoreCase("p2"))
		{
			if (gameBoard[0][1].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[0][2].getActionCommand().equalsIgnoreCase("p2"))
				{
					p2Wins = true;
				}
			}
		}
		
		//checking if row 2 is a winner for p1
		if (gameBoard[1][0].getActionCommand().equalsIgnoreCase("p1"))
		{
			if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[1][2].getActionCommand().equalsIgnoreCase("p1"))
				{
					p1Wins = true;
				}
			}
		}
		
		//checking if row 2 is a winner for p2
		if (gameBoard[1][0].getActionCommand().equalsIgnoreCase("p2"))
		{
			if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[1][2].getActionCommand().equalsIgnoreCase("p2"))
				{
					p2Wins = true;
				}
			}
		}
		
		
		//checking if row 3 is a winner for p1
		if (gameBoard[2][0].getActionCommand().equalsIgnoreCase("p1"))
		{
			if (gameBoard[2][1].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[2][2].getActionCommand().equalsIgnoreCase("p1"))
				{
					p1Wins = true;
				}
			}
		}
		
		//checking if row 3 is a winner for p2
		if (gameBoard[2][0].getActionCommand().equalsIgnoreCase("p2"))
		{
			if (gameBoard[2][1].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[2][2].getActionCommand().equalsIgnoreCase("p2"))
				{
					p2Wins = true;
				}
			}
		}
		
		//checking if column 1 is a winner for p1
		if (gameBoard[0][0].getActionCommand().equalsIgnoreCase("p1"))
		{
			if (gameBoard[1][0].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[2][0].getActionCommand().equalsIgnoreCase("p1"))
				{
					p1Wins = true;
				}
			}
		}
		
		//checking if column 1 is a winner for p2
		if (gameBoard[0][0].getActionCommand().equalsIgnoreCase("p2"))
		{
			if (gameBoard[1][0].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[2][0].getActionCommand().equalsIgnoreCase("p2"))
				{
					p2Wins = true;
				}
			}
		}
		
		//checking is column 2 is a winner for p1
		if (gameBoard[0][1].getActionCommand().equalsIgnoreCase("p1"))
		{
			if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[2][1].getActionCommand().equalsIgnoreCase("p1"))
				{
					p1Wins = true;
				}
			}
		}
		
		//checking is column 2 is a winner for p2
		if (gameBoard[0][1].getActionCommand().equalsIgnoreCase("p2"))
		{
			if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[2][1].getActionCommand().equalsIgnoreCase("p2"))
				{
					p2Wins = true;
				}
			}
		}
		
		//checking if column 3 is a winner for p1
		if (gameBoard[0][2].getActionCommand().equalsIgnoreCase("p1"))
		{
			if (gameBoard[1][2].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[2][2].getActionCommand().equalsIgnoreCase("p1"))
				{
					p1Wins = true;
				}
			}
		}
		
		//checking if column 3 is a winner for p2
		if (gameBoard[0][2].getActionCommand().equalsIgnoreCase("p2"))
		{
			if (gameBoard[1][2].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[2][2].getActionCommand().equalsIgnoreCase("p2"))
				{
					p2Wins = true;
				}
			}
		}
		
		//checking if diagonal 1 is a winner for p1
		if (gameBoard[0][0].getActionCommand().equalsIgnoreCase("p1"))
		{
			if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[2][2].getActionCommand().equalsIgnoreCase("p1"))
				{
					p1Wins = true;
				}
			}
		}
		
		//checking if diagonal 1 is a winner for p2
		if (gameBoard[0][0].getActionCommand().equalsIgnoreCase("p2"))
		{
			if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[2][2].getActionCommand().equalsIgnoreCase("p2"))
				{
					p2Wins = true;
				}
			}
		}
		
		
		//checking if diagonal 2 is the winner with an if statement
			//checking if diagonal 2 is a winner for player 1
			if (gameBoard[0][2].getActionCommand().equalsIgnoreCase("p1"))
			{
				if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p1"))
				{
					if (gameBoard[2][0].getActionCommand().equalsIgnoreCase("p1"))
					{
						p1Wins = true;
					}
				}
			}
			
			//checking if diagonal 2 is a winner for player 2
			if (gameBoard[0][2].getActionCommand().equalsIgnoreCase("p2"))
			{
				if (gameBoard[1][1].getActionCommand().equalsIgnoreCase("p2"))
				{
					if (gameBoard[2][0].getActionCommand().equalsIgnoreCase("p2"))
					{
						p2Wins = true;
					}
				}
			}
			
			//checking if p1 won
			if (p1Wins == true)
			{
				//exiting the game
				jframe.dispatchEvent(new WindowEvent(jframe, WindowEvent.WINDOW_CLOSING));
				
				//running the you win class
				TicTacToeWinner winner = new TicTacToeWinner();
				
				//resetting all the game values
				p1Wins = false;
				p2Wins = false;
				catsGame = 0;
				playerGoing = 1;
				
			}
			else if (p2Wins == true)
			{
				//exiting the game
				jframe.dispatchEvent(new WindowEvent(jframe, WindowEvent.WINDOW_CLOSING));
				
				//running the you win class
				TicTacToeWinner winner = new TicTacToeWinner();
				
				//resetting all the game values
				p1Wins = false;
				p2Wins = false;
				catsGame = 0;
				playerGoing = 1;
			}
		
		
		//checking to see if it is a cats game
			for (int i = 0; i<gameBoard.length; i++)
			{
				for (int z = 0; z<gameBoard[i].length; z++)
				{
					if (gameBoard [i][z].getActionCommand().equalsIgnoreCase("p1") ||gameBoard [i][z].getActionCommand().equalsIgnoreCase("p2"))
					{
						//updating cats game
						catsGame++;
					}
				}
				
				//checking to see if cats game is equal to 9 before the loop ends!
				if (catsGame == 9)
				{					
					//exiting the game
					jframe.dispatchEvent(new WindowEvent(jframe, WindowEvent.WINDOW_CLOSING));
					
					//running the you win class
					TicTacToeWinner winner = new TicTacToeWinner();
					
					
					//resetting all the game values
					p1Wins = false;
					p2Wins = false;
					catsGame = 0;
					playerGoing = 1;
				}
				
				
			}
			//resetting the cats game value	
			catsGame = 0;
	}
	
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		new TicTacToeButtons3();
	
	
	
	}
	
	
	
	
}
