// Aniqua Azad
// TWPanel.java
// 04-18-16
// Description: This program is to help sophomores or those interested in history to understand the 
	//historical significance behind World War 1 and the aspects of it (weapons, leaders, battle tactics, etc)
	//This specific class is called from TrenchWar. TWPanel creates the two panels for the game, the "welcome" panel which will have a 
	//"start" button. Once the start button is pressed, the screen will refresh to the next panel that will be the game itself.
// Testing: 
	//Should Work: there is a button that the user will have to press to play the game
	//Should Not Work:
	
//import libraries
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
	
public class TWPanel
{
	//declare variables
		//colors
		//numbers as FINAL
	//////////////////////////////////////
		//boolean variable for buttons
			//startPressed
			//nextPressed
	//////////////////////////////////////
		//cards (20)
		//cardQuestionLabel
		//cardHistoryLabel
	//////////////////////////////////////
		//variables for classes startPanel and gamePanel
		//cardHolderPanel
	
	public TWPanel()
	{
		//instantiate variables
		//call class startPanel and gamePanel
		//call method createCards
	}
	
	public void createCards()
	{
		//instantiate cards
		//add colors to cards
		//make labels for cards
		///////////////////////////////////////
			//labels for cards with questions
		///////////////////////////////////////
			//labels for cards with history
	}
	
	class startPanel extends JPanel
	{
		//This panel will be a border layout that will have a top and bottom. In the north, there will be
		//graphics and the title of the game. In the south, there will be a button which 
		//the user will have to press. The button will say "Start". In the center, there will be simple instructions
		//for the user to follow.
		public startPanel()
		{
			//set background color
			//layout of panel is grid layout with 3 rows and 1 column
			//create button startButton
			//create instance of class startButtonHandler
			//add startButton to panel
		}
		
		public void paintComponent(Graphics g)
		{
			//write title of game in bold letters
			//have images related to WWI placed throughout the panel
			
			//if startPressed
				//call class gamePanel
		}
	}
	
	class startButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//set startPressed to true
			//conditional statement
				//if startPressed is true
					//repaint startPanel
		}
	}
	
	class gamePanel extends JPanel
	{
		//This class will be the panel for the game itself. It will have a diagram of a "trench" with 10 
		//circles in various places. This game will have cards that ask questions as well as answer
		//choices. There will also be a "next" button that the user will press to go to the "history card"
		//and then they will press the button to go to the next question. After each question, 1 circle will 
		//be colored in.
		public gamePanel()
		{
			//set background color
			//create button nextButton
			//create instance of class nextButtonHandler
			//add nextButton to panel
		}
		
		public void paintComponent (Graphics g)
		{
			//create "board"
				//10 circles drawn with small dashes between them
				//two parallel lines on east and west side
					//west side text = "YOU"
					//east side text = "ENEMY"
		}
	}
	
	class nextButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//set nextPressed to true
		}
	}
}
