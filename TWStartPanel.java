/* Aniqua Azad
  TWStartPanel.java
  04-18-16
 Description: This program is to help sophomores or those interested in history, to understand 
 the historical significance behind World War 1 and the aspects of it(weapons, leaders, battle 
 tactics, etc). This specific class is called from TrenchWar. TWStartPanel creates the two panels 
 for the game, the "welcome" panel which will have a "Start" button. Once the start button is pressed, 
 the screen will refresh to the next panel that will be the game itself.
 
 Once 'Start' is pressed, the frame is refreshed to show the actual game panel which has three columns.
 The first column holds question and history card panels, and each QuestionCard has JRadioButtons
 which requires the user to press to see if they were right or wrong. Once they are done answering, 
 they press the 'Submit' button to see the history card corresponding to the question. After they are
 done reading the history, they will press the 'Next' button to see the next question. If they are correct, a 
 green circle will appear on the middle column, if not, then a red circle will appear, and the score will be 
 updated in the third column. Once they answer the 8th question, a message will appear corresponding to their
 score.
 Testing:
    Should Work: there are buttons that the user will have to press to play the game and 
				answer the questions
    Should Not Work: none */

//import libraries
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TWStartPanel extends JPanel
{
    //declare variables
        //colors
        private Color bgColor1;
        //numbers as FINAL
    //////////////////////////////////////
        //boolean variable for button
        private boolean startPressed;//startPressed
    //////////////////////////////////////
        private LeftPanel leftp;//variables for class StartPanel
        private RightPanel rightp;
        private TitlePanel tp;
        private InstructionPanel ip;
        private ButtonHolderPanel bhp;
		///////////////////////////////////////
		//colors and fonts
		private Color background;
		private Color wrongCircle;
		private Color rightCircle;
		private Font qAndHFont;
		//counter
		private int nextCounter;//for when user presses 'Next' button
		private int submitCounter;//for when user presses 'Submit' button
		private int currentQuestionNum;
		//score
		private int score;
		private String printScore;
		private ScorePanel scorep;
		//arrays
		private int [] answerArray; 
		private String [] questionArray;
		private String [] historyArray;
		//Strings
		private String answer;
		private String click;
		//////////////////////////////////////
		//buttons
		private JButton nextButton;
		private JButton submitButton;
		//////////////////////////////////////
		//boolean variable for buttons
		private boolean submitPressed;//submitPressed
		private boolean nextPressed;    //nextPressed
		private boolean optionClicked;
		private boolean endClicked;
		//////////////////////////////////////cards (18)
		//prompt cards
		private PromptCard1 pcard1;
		private PromptCard2 pcard2;
		//question cards
		private QuestionCard1 qcard1;
		private QuestionCard2 qcard2;
		private QuestionCard3 qcard3;
		private QuestionCard4 qcard4;
		private QuestionCard5 qcard5;
		private QuestionCard6 qcard6;
		private QuestionCard7 qcard7;
		private QuestionCard8 qcard8;
		//history cards
		private HistoryCard1 hcard1;
		private HistoryCard2 hcard2;
		private HistoryCard3 hcard3;
		private HistoryCard4 hcard4;
		private HistoryCard5 hcard5;
		private HistoryCard6 hcard6;
		private HistoryCard7 hcard7;
		private HistoryCard8 hcard8;
		//labels
		private JLabel qLabel1, qLabel2, qLabel3, qLabel4, qLabel5, qLabel6,qLabel7, qLabel8;
		private JLabel hLabel;
		//card panel holders
		private QuestionCardHolderPanel qCardPanel; //question card holder
		private HistoryCardHolderPanel hCardPanel; //history card holder
		private PanelHolder pHolder;
		//card layouts
		private CardLayout cardLayout;
		private CardLayout panelLayout;
		//panel holder which holds all panels
		private BoardPanel boardp;
		private GameHolderPanel ghp;
        
    public TWStartPanel()
    {
      //instantiate variables
        setLayout(new GridLayout(1, 2));
      //colors and fonts
        bgColor1 = new Color (127, 24, 44);
        startPressed = false;     
	    background = new Color(171, 144, 93);
	    wrongCircle = new Color(255, 0, 51);
	    rightCircle = new Color(98, 253, 54);
	    qAndHFont = new Font ("Monospaceed", Font.PLAIN, 15);
	    //counters
	    nextCounter = 1;
	    submitCounter = 1;
	    //score
	    score = 0;
	    printScore = "";
	    //arrays
	    answerArray = new int [9];
	    questionArray = new String [8];
	    historyArray = new String [36];
	    //booleans for buttons
	    submitPressed = false;
	    nextPressed = false;
	    optionClicked = false;
	    endClicked = false;
	    //strings
	    answer = "";
	    click = "";
	    /////////////////////////////////////
	    //panel and card holders
	    qCardPanel = new QuestionCardHolderPanel(); //holds question cards
	    hCardPanel = new HistoryCardHolderPanel(); //holds history cards
	    pHolder = new PanelHolder(); //holds panels
	    //card layout
	    cardLayout = new CardLayout();
	    panelLayout = new CardLayout();
	    //add layout to card panel holders
	    qCardPanel.setLayout(cardLayout);
	    hCardPanel.setLayout(cardLayout);
	    pHolder.setLayout(panelLayout);
	    /////////////////////////////////////
	    //cards (18)
	    //prompt cards
	    pcard1 = new PromptCard1();
	    pcard2 = new PromptCard2();
	    //question cards        
	    qcard1 = new QuestionCard1();
	    qcard2 = new QuestionCard2();
	    qcard3 = new QuestionCard3();
	    qcard4 = new QuestionCard4();
	    qcard5 = new QuestionCard5();
	    qcard6 = new QuestionCard6();
	    qcard7 = new QuestionCard7();
	    qcard8 = new QuestionCard8();
	    //history cards
        hcard1 = new HistoryCard1();
        hcard2 = new HistoryCard2();
        hcard3 = new HistoryCard3();
        hcard4 = new HistoryCard4();
        hcard5 = new HistoryCard5();
        hcard6 = new HistoryCard6();
        hcard7 = new HistoryCard7();
        hcard8 = new HistoryCard8();
        ///////////////////////////////////////
        //labels for cards with questions
        qLabel1 = new JLabel ("Question 1");
        qLabel2 = new JLabel ("Question 2");
        qLabel3 = new JLabel ("Question 3");
        qLabel4 = new JLabel ("Question 4");
        qLabel5 = new JLabel ("Question 5");
        qLabel6 = new JLabel ("Question 6");
        qLabel7 = new JLabel ("Question 7");
        qLabel8 = new JLabel ("Question 8");
        ///////////////////////////////////////
        //label for cards with history
        hLabel = new JLabel ("History");
        ///////////////////////////////////////
        //add labels for card with questions
        qcard1.add(qLabel1);
        qcard2.add(qLabel2);
        qcard3.add(qLabel3);
        qcard4.add(qLabel4);
        qcard5.add(qLabel5);
        qcard6.add(qLabel6);
        qcard7.add(qLabel7);
        qcard8.add(qLabel8);
        ///////////////////////////////////////
        //add labels for cards with history
        hcard1.add(hLabel);
        hcard2.add(hLabel);
        hcard3.add(hLabel);
        hcard4.add(hLabel);
        hcard5.add(hLabel);
        hcard6.add(hLabel);
        hcard7.add(hLabel);
        hcard8.add(hLabel);
        ///////////////////////////////////////
        //add cards to panel AND give each a string name
        qCardPanel.add(pcard1, "PROMPT 1");
        qCardPanel.add(qcard1, "QUESTION 1");
        qCardPanel.add(qcard2, "QUESTION 2");
        qCardPanel.add(qcard3, "QUESTION 3");
        qCardPanel.add(qcard4, "QUESTION 4");
        qCardPanel.add(qcard5, "QUESTION 5");
        qCardPanel.add(qcard6, "QUESTION 6");
        qCardPanel.add(qcard7, "QUESTION 7");
        qCardPanel.add(qcard8, "QUESTION 8");
        
        hCardPanel.add(pcard2, "PROMPT 2");
        hCardPanel.add(hcard1, "HISTORY 1");
        hCardPanel.add(hcard2, "HISTORY 2");
        hCardPanel.add(hcard3, "HISTORY 3");
        hCardPanel.add(hcard4, "HISTORY 4");
        hCardPanel.add(hcard5, "HISTORY 5");
        hCardPanel.add(hcard6, "HISTORY 6");
        hCardPanel.add(hcard7, "HISTORY 7");
        hCardPanel.add(hcard8, "HISTORY 8");
        //panel which holds panels for the "greeting" panel and the game
        boardp = new BoardPanel();
        ghp = new GameHolderPanel();
        //add ghp and boardp to pHolder
        pHolder.add(ghp, "Game Holder");
        pHolder.add(boardp, "Board Panel");
        //add pHolder to frame
        add(pHolder);
    }
    
    class PanelHolder extends JPanel
    {
    	public PanelHolder()
    	{
    		setBackground(Color.CYAN);
    	}
    }
    
    class GameHolderPanel extends JPanel
    {
    	//This panel has 1 row and 2 columns. It contains two sub-panels; LeftPanel and RightPanel
    	public GameHolderPanel()
    	{
    		setLayout(new GridLayout (1, 2));
    		leftp = new LeftPanel();//call class LeftPanel
            add(leftp);
            rightp = new RightPanel();//call class RightPanel
            add(rightp);
    	}
    }

    class LeftPanel extends JPanel
    {
        //This class will have the title panel of the game on the left side of the screen, along with images 
        //related to WWI. It calls the class title panel, which creates the title and includes images.
        public LeftPanel()
        {
            setBackground(Color. WHITE);//set background color
            setLayout(new BorderLayout());
            tp = new TitlePanel();
            add(tp, BorderLayout.CENTER);
        }
    }
    
    class TitlePanel extends JPanel
    {
        //This class panel has the title of the game as well as images related to WWI (i.e. weapons, leaders, etc).
        //The title of the game will be created using paintComponent.
        
        Font titleFont;
        private Image image1;
        private Image image2;
        
        public TitlePanel()
        {
            setBackground(bgColor1);
            titleFont = new Font ("Monospaced", Font.BOLD, 100);
            image1 = Toolkit.getDefaultToolkit().getImage("image2.jpg");
            image2 = Toolkit.getDefaultToolkit().getImage("image3.jpg");
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage( image1, 20, 50, this);
            g.drawImage( image2, 360, 50, this);
            
            g.setFont(titleFont);
            g.setColor(Color.BLACK);
            g.drawString("The", 185, 150);
            g.drawString("Game", 185, 530);
            g.setColor(Color.YELLOW);
            g.drawString("TRENCH WAR", 50, 360);
        }
    }
    
    class RightPanel extends JPanel
    {
        /*This panel has 2 rows and 1 column and holds panels that have 
    	the instructions for the game (instruction panel is on top)
    	and the button to start the game(button panel is on the bottom).*/
        public RightPanel()
        {
            setLayout(new GridLayout(2, 1));
            
            ip = new InstructionPanel();
            add(ip);
            
            bhp = new ButtonHolderPanel();
            add(bhp);
        }
    }
    
    class InstructionPanel extends JPanel
    {
        //This class will have the instructions of the game printed. It will inform the user how to play 
    	//the game and what they will have to do to win. The rules will be written using paintComponent.
        
        Font instrucFont;
        Font instrucFont2;
        Font instrucFont3;
        public InstructionPanel()
        {
            setBackground(Color.WHITE);
            instrucFont = new Font ("Serif", Font.BOLD, 45);
            instrucFont2 = new Font ("Serif", Font.BOLD, 20);
            instrucFont3 = new Font ("Monospaced", Font.BOLD,100);
        }
        
        public void paintComponent(Graphics g)
        {
            //write instructions of game
            super.paintComponent(g);
            g.setFont(instrucFont);
            g.setColor(Color.BLACK);
            g.drawString("Rules", 260, 30);
            g.setColor(Color.BLACK);
            g.setFont(instrucFont2);
            g.drawString("1. There will be a question along with 3 options.",20, 60);
            g.drawString("        Press which answer you think is correct.",20, 80);
            g.drawString("2. Click 'Submit' after choosing.", 20, 100);
            g.drawString("3. On the bottom panel, a brief history will appear.", 20, 160);
            g.drawString("        After you are done reading, click the 'Next' button.", 20, 180);
            g.drawString("        It will take you to the next question.", 20, 200);
            //This will inform the user what will appear if they get a question right or wrong
            g.setColor(Color.GREEN);
            g.drawString("          Correct = green circle on board & +1 point", 20, 120);
            g.setColor(Color.RED);
            g.drawString("       Incorrect = red circle on board & -1 point", 20, 140);
            
            g.setColor(Color.MAGENTA);
            g.setFont(instrucFont3);
            g.drawString("GOOD LUCK!", 20, 280);
        }
    }
    
    class ButtonHolderPanel extends JPanel
    {
    	//This panel holds a JButton which prompts the user to start the game. It has the text
    	//'Start' on it, which the user will press.
        private JButton startButton;
        private Font startFont;
        
        public ButtonHolderPanel()
        {
            setBackground(Color.PINK);
            startButton = new JButton ("START");//create button startButton
            StartButtonHandler sbHandler = new StartButtonHandler();//create instance of class startButtonHandler
            startButton.addActionListener(sbHandler);
            startButton.setPreferredSize(new Dimension(300, 150)); //
            startButton.setLocation(700, 700);
            add(startButton);    //add startButton to panel
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            startFont = new Font("Monospaced", Font.BOLD, 30);
            g.setFont(startFont);
            g.drawString("Press 'Start' to play!", 690, 350);
            
          //if startPressed is true, show "Board Panel" which holds the game itself
            if (startPressed)
            {
                panelLayout.show(pHolder, "Board Panel");
            }
        }
    }

    class StartButtonHandler implements ActionListener
    {
        public StartButtonHandler()
        {
            
        }
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();//set variable equal to e.getActionCommand
            //conditional statement: if the start button is pressed, boolean startPressed is set to true
            if(click.equals("START")) 
            {
            	startPressed = true; 
            }
            repaint();
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////// 
    class BoardPanel extends JPanel
    {
        /*This class will be the panel for the game itself. It will have a
        diagram of a "trench" with 10 circles in various places. 
    	This game will have cards that ask questions as well as answer
        choices. There will also be a "next" button that the user will
        press to go to the "history card" and then they will press 
    	the button to go to the next question. After each question, 
    	1 circle will be colored in.*/

        //variables of column panels
        	//columnOne, two, three
        private FirstColumn columnOne;
        private SecondColumn columnTwo;
        private ThirdColumn columnThree;
        
        public BoardPanel()
        {
          //layout is gridLayout with 3 columns and 1 row
          setLayout(new GridLayout (1,3));
          setBackground(Color.BLACK);//set background color
          
          columnOne = new FirstColumn();
          columnTwo = new SecondColumn();
          columnThree = new ThirdColumn();//instantiate column panels
          //add columns to panel
          add(columnOne);
          add(columnTwo);
          add(columnThree);
        }
    }

    class FirstColumn extends JPanel
    {
        /*This panel has 2 sub-panels, one is for the question cards 
         and one is for the history cards
    	This is a gridLayout with 2 rows and 1 column*/
        private QuestionPanel questp;
        private HistoryPanel histp;
        
        public FirstColumn()
        {
            setLayout(new GridLayout (2, 1));//set layout as grid layout with 2 rows and 1 column
            //instantiate QuestionPanel and HistoryPanel
            
            questp = new QuestionPanel();
            add(questp);

            histp = new HistoryPanel();
            add(histp);//add QuestionPanel and HistoryPanel to FirstColumn panel
        }
    }

    class QuestionPanel extends JPanel
    {
    /*This class will be a cardLayout and it will ask the user questions on the
    history of WWI. The questions will be retrieved from the text file "Questions.txt" . 
    There will be 3 options from which the user can choose exactly
    one answer. After the user is done selecting, he/she will click the
    "Submit" button, and they will be able to see if they were correct or incorrect.
    
    If a user is correct, the JRadioButtons are removed and the card becomes green
    and prompts the user to press the 'Submit' button. If the user is incorrect,
    the JRadioButtons are removed and the card becomes red and prompt the user to 
    press the 'Submit' button.*/

    //declare variables
    int currentQuestionNum;//for currentQuestionNum
    Scanner questionFileScanner;
    File questionFile;
        
    	public QuestionPanel()
        {
            setLayout(new BorderLayout());
            setBackground(Color.YELLOW);
           
            questionFile = new File("Questions.txt");
            
            //create button "Submit"
            submitButton = new JButton("Submit");
            SubmitButtonHandler subHandler = new SubmitButtonHandler();//register submitButton handler
            submitButton.addActionListener(subHandler);//add ActionListener
           
            add(submitButton, BorderLayout.SOUTH);//Add button into this panel
            add(qCardPanel,BorderLayout.CENTER);
            
            readQuestionFile();
        }
        
        public void readQuestionFile()
        {
            try
            {
                questionFileScanner = new Scanner (questionFile);
            }
            catch (FileNotFoundException e)
            {
                
                System.exit(2);
            }
            int i = 0;
            while ( questionFileScanner.hasNext() )
            {
                questionArray[i++] = questionFileScanner.nextLine();
            }
            questionFileScanner.close();
        }
    }
    class QuestionCardHolderPanel extends JPanel
    {
        public QuestionCardHolderPanel()
        {
            setBackground(Color.CYAN);
        }
    }
    
    class PromptCard1 extends JPanel
    {
    	//This card informs the user to press the submit button after they are done 
    	//answering the question. When the 'Submit' button is pressed, the corresponding 
    	//history card for the question appears.
    	private Font prompt1Instruc;
    	
    	public PromptCard1()
    	{
    		setBackground(Color.WHITE);
    		prompt1Instruc = new Font ("Serif", Font.BOLD, 30);
    	}
    	
    	public void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		g.setFont(prompt1Instruc);
    		g.drawString("Press 'Submit' when you are done ", 5, 30);
    		g.drawString("answering the question.", 5, 65);
    	}
    }
/////////////////////////////////////////////////////////////////////////
    /*Each QuestionCard class will have variables for JRadioButtons and the questionNum.
    The background color for each card is white.
    There is 1 QuestionHandler for each QuestionCard with different variables for each option.
    The question is drawn on the card using the array questionArray[] with the variable questionNum
    If the boolean optionClicked is true, then check to see if it is the correct option.
    	-use isSelected()
    If the answer is correct
    	-then remove the JRadioButtons and change the background color to green.
    	-Set the array answerArray[questionNum] to 1
    	-Set string variable 'answer' to right
	If the answer is incorrect
		-then remove the JRadioButtons and change the background color to red.
		-Set the array answerArray[questionNum] to -1
		-Set string variable 'answer' to wrong*/
    class QuestionCard1 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
        private int questionNum;
        
        public QuestionCard1()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 0;
           
            option1 = new JRadioButton("A. Nationalism");
            Question1Handler q1o1Handler = new Question1Handler();
            option1.addActionListener( q1o1Handler );
            
            option2 = new JRadioButton("B. Economy");
            Question1Handler q1o2Handler = new Question1Handler();
            option2.addActionListener( q1o2Handler );
            
            option3 = new JRadioButton("C. Power");
            Question1Handler q1o3Handler = new Question1Handler();
            option3.addActionListener( q1o3Handler );
            
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(questionArray[questionNum], 50, 40);
            
            if(optionClicked)
            {
            	currentQuestionNum = 1;
                
            	if(option1.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option2.isSelected()|| option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            	optionClicked = false;
            }
        }
    }
    
    class Question1Handler implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }
   
    class QuestionCard2 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
        private int questionNum;
        
        public QuestionCard2()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 1;
           
            option1 = new JRadioButton("A. Fight to the Finish");
            Question2Handler q2o1Handler = new Question2Handler();
            option1.addActionListener( q2o1Handler );
            
            option2 = new JRadioButton("B. The Last War");
            Question2Handler q2o2Handler = new Question2Handler();
            option2.addActionListener( q2o2Handler );
            
            option3 = new JRadioButton("C. The War to End All Wars");
            Question2Handler q2o3Handler = new Question2Handler();
            option3.addActionListener( q2o3Handler );
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(questionArray[questionNum], 50, 40);
            if(optionClicked)
            {
            	currentQuestionNum = 2;
                if(option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option1.isSelected()||option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            }
        }
    }
    
    class Question2Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }
    
    class QuestionCard3 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
         private int questionNum;
        public QuestionCard3()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 2;
            option1 = new JRadioButton("A. Gas Chamber");
            Question3Handler q3o1Handler = new Question3Handler();
            option1.addActionListener( q3o1Handler );
            
            option2 = new JRadioButton("B. Trench Warfare");
            Question3Handler q3o2Handler = new Question3Handler();
            option2.addActionListener( q3o2Handler );
            
            option3 = new JRadioButton("C. Atomic Bomb");
            Question3Handler q3o3Handler = new Question3Handler();
            option3.addActionListener( q3o3Handler );
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(questionArray[questionNum], 50, 40);
            if(optionClicked)
            {
            	currentQuestionNum = 3;
                if(option2.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option1.isSelected()||option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            }
        }
    }
    
    class Question3Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }
    
    class QuestionCard4 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
         private int questionNum;
        public QuestionCard4()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 3;
            option1 = new JRadioButton("A. Loss of Lives");
            Question4Handler q4o1Handler = new Question4Handler();
            option1.addActionListener( q4o1Handler );
            
            option2 = new JRadioButton("B. Expense");
            Question4Handler q4o2Handler = new Question4Handler();
            option2.addActionListener( q4o2Handler );
            
            option3 = new JRadioButton("C. All of the Above");
            Question4Handler q4o3Handler = new Question4Handler();
            option3.addActionListener( q4o3Handler );
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(questionArray[questionNum], 50, 40);
            if(optionClicked)
            {
            	currentQuestionNum = 4;
                if(option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option1.isSelected()||option2.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            }
        }
    }
    
    class Question4Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }
    class QuestionCard5 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
         private int questionNum;
        public QuestionCard5()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 4;
            option1 = new JRadioButton("A. Germany");
            Question5Handler q5o1Handler = new Question5Handler();
            option1.addActionListener( q5o1Handler );
            
            option2 = new JRadioButton("B. Russia");
            Question5Handler q5o2Handler = new Question5Handler();
            option2.addActionListener( q5o2Handler );
            
            option3 = new JRadioButton("C. America");
            Question5Handler q5o3Handler = new Question5Handler();
            option3.addActionListener( q5o3Handler );
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(questionArray[questionNum], 50, 40);
            if(optionClicked)
            {
            	currentQuestionNum = 5;
                if(option1.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option2.isSelected()||option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            }
        }
    }
    
    class Question5Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }
    class QuestionCard6 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
         private int questionNum;
        public QuestionCard6()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 5;
            option1 = new JRadioButton("A. November 11, 1918");
            Question6Handler q6o1Handler = new Question6Handler();
            option1.addActionListener( q6o1Handler );
            
            option2 = new JRadioButton("B. November 11, 1917");
            Question6Handler q6o2Handler = new Question6Handler();
            option2.addActionListener( q6o2Handler );
            
            option3 = new JRadioButton("C. November 10, 1918");
            Question6Handler q6o3Handler = new Question6Handler();
            option3.addActionListener( q6o3Handler );
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(questionArray[questionNum], 50, 40);
            if(optionClicked)
            {
            	currentQuestionNum = 6;
                if(option1.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option2.isSelected()||option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            }
        }
    }
    
    class Question6Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }
    class QuestionCard7 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
         private int questionNum;
        public QuestionCard7()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 6;
            option1 = new JRadioButton("A. Lost land, took the blame, pay reparations");
            Question7Handler q7o1Handler = new Question7Handler();
            option1.addActionListener( q7o1Handler );
            
            option2 = new JRadioButton("B. Sent off with a warning");
            Question7Handler q7o2Handler = new Question7Handler();
            option2.addActionListener( q7o2Handler );
            
            option3 = new JRadioButton("C. Pay reparations, lost land, blamed Ottoman Empire for war");
            Question7Handler q7o3Handler = new Question7Handler();
            option3.addActionListener( q7o3Handler );
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(questionArray[questionNum], 0, 40);
            if(optionClicked)
            {
            	currentQuestionNum = 7;
                if(option1.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option2.isSelected()||option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            }
        }
    }
    
    class Question7Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }
    
    class QuestionCard8 extends JPanel
    {
        private JRadioButton option1;
        private JRadioButton option2;
        private JRadioButton option3;
        private int questionNum;
        public QuestionCard8()
        {
            setBackground(Color.WHITE);
            setLayout(new FlowLayout(FlowLayout.CENTER,200, 50));
            questionNum = 7;
            option1 = new JRadioButton("A. United Nations");
            Question8Handler q8o1Handler = new Question8Handler();
            option1.addActionListener( q8o1Handler );
            
            option2 = new JRadioButton("B. League of Nations");
            Question8Handler q8o2Handler = new Question8Handler();
            option1.addActionListener( q8o2Handler );
            
            option3 = new JRadioButton("C. League of Legends");
            Question8Handler q8o3Handler = new Question8Handler();
            option1.addActionListener( q8o3Handler );
            
            add(option1);
            add(option2);
            add(option3);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawString(questionArray[questionNum], 50, 40);
            if(optionClicked)
            {
            	currentQuestionNum = 8;
                if(option2.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.GREEN);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("CORRECT. Click 'Submit' to find out why!", 80, 100);
                    answerArray[currentQuestionNum] = 1;
                    answer = "right";
                }
                else if(option1.isSelected()||option3.isSelected())
                {
                    super.paintComponent(g);
                    setBackground(Color.RED);
                    remove(option1);
                    remove(option2);
                    remove(option3);
                    g.drawString("INCORRECT. Click 'Submit' to learn why!", 80, 100);
                    answerArray[currentQuestionNum] = -1;
                    answer = "wrong";
                }
            }
        }
    }
    
    class Question8Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            optionClicked = true;
            repaint();
        }
    }

    class SubmitButtonHandler implements ActionListener
    {
    	/*This class has a counter which keeps track of the history cards.
    	When the user presses the 'Submit' button, submitCounter is used to
    	show the corresponding history card.*/
    	
    	/*This also has a conditional statement for when the answer to the question
    	was right or wrong. If the string variable 'answer' = "right", then score++.
    	Otherwise if it is equal to "wrong", then score--*/
        public void actionPerformed(ActionEvent e)
        {
            click = e.getActionCommand();
            if(click.equals("Submit"))
            {
            	submitPressed = true;
            }

            //show history cards related to 'currentsubmitCounter' question
            if(submitPressed)
            {             
                if (submitCounter%9 == 0)
                    cardLayout.show(hCardPanel, "PROMPT 2");
                else if (submitCounter%9 == 1)
                    cardLayout.show(hCardPanel, "HISTORY 1");
                else if (submitCounter%9 == 2)
                    cardLayout.show(hCardPanel, "HISTORY 2");
                else if (submitCounter%9 == 3)
                    cardLayout.show(hCardPanel, "HISTORY 3");
                else if (submitCounter%9 == 4)
                    cardLayout.show(hCardPanel, "HISTORY 4");
                else if (submitCounter%9 == 5)
                    cardLayout.show(hCardPanel, "HISTORY 5");
                else if (submitCounter%9 == 6)
                    cardLayout.show(hCardPanel, "HISTORY 6");
                else if (submitCounter%9 == 7)
                    cardLayout.show(hCardPanel, "HISTORY 7");
                else if (submitCounter%9 == 8)
                    cardLayout.show(hCardPanel, "HISTORY 8");
                submitCounter++;
            }
            
            if(answer.equals("right"))
            	score++;
            else if (answer.equals("wrong"))
            	score--;
            scorep.changeScoreToString(score);
            scorep.repaint();
            repaint();
        }
    }

    class HistoryPanel extends JPanel
    {
    	/*This panel holds the history cards for each question. It informs the user
    	the history behind the corresponding question. The history is read from the 
    	text file "History.txt" and each line is stored into the array historyArray[].
    	This panel also includes a 'Next' button which the user presses to see the next 
    	question. Additionally, at the beginning of the game, there is a prompt card which
    	informs the user to press the 'Next' button to see the question.*/

	    Scanner historyFileScanner;
	    File historyFile;//declare historyFileScanner
       
	    public HistoryPanel()
        {
			historyFile = new File ("History.txt");
            setLayout(new BorderLayout());
            setBackground(Color.MAGENTA);
            
            //create button "Next"
            nextButton = new JButton("Next");
            NextButtonHandler nbHandler = new
            NextButtonHandler();//nextButton handler
            nextButton.addActionListener(nbHandler);//add ActionListener
            
            add(nextButton, BorderLayout.SOUTH);//add button into this panel
            add(hCardPanel, BorderLayout.CENTER);
            readHistoryFile();
        }

        public void readHistoryFile()
        {
			int histLine = 0;
			String historyPrompt;
            try
            {
                historyFileScanner = new Scanner (historyFile);
            }
            catch (FileNotFoundException e)
            {
                
                System.exit(2);
            }
            while ( historyFileScanner.hasNext() )
            {
				historyPrompt = historyFileScanner.nextLine();
				if (historyPrompt.length() > 0)
					historyArray[histLine++] = historyPrompt;
            }
            historyFileScanner.close();
        }
    }
////////////////////////////////////////////////////////////////////
    /* Each history card has a int variable 'currentHistoryNum' which keeps
     track of which number card it is on. It is also used for when writing
     the history onto the cards.*/
    class HistoryCardHolderPanel extends JPanel
    {
        public HistoryCardHolderPanel()
        {
            setBackground(Color.DARK_GRAY);
        }
    }
    
    class PromptCard2 extends JPanel
    {
    	private Font promptInstruc;
    	
    	public PromptCard2()
    	{
    		setBackground(Color.MAGENTA);
    		promptInstruc = new Font ("Serif", Font.BOLD, 30);
    	}
    	
    	public void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		g.setFont(promptInstruc);
    		g.drawString("Press 'Next' to ", 15, 30);
    		g.drawString("to see the next question.",15, 70);
    	}
    }
   
    class HistoryCard1 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard1()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 0;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
        }
    }
    
    class HistoryCard2 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard2()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 3;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
            g.drawString(historyArray[currentHistoryNum + 3], 0, 100);
        }
    }
    
    class HistoryCard3 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard3()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 7;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
        }
    }
    
    class HistoryCard4 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard4()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 10;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum ], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
            g.drawString(historyArray[currentHistoryNum + 3], 0, 100);
        }
    }
    
    class HistoryCard5 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard5()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 14;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
        }
    }
    
    class HistoryCard6 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard6()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 17;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
        }
    }
    
    class HistoryCard7 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard7()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 20;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
        }
    }
    
    class HistoryCard8 extends JPanel
    {
		private int currentHistoryNum;
        
		public HistoryCard8()
        {
            setBackground(Color.ORANGE);
            currentHistoryNum = 23;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setFont(qAndHFont);
            g.drawString(historyArray[currentHistoryNum], 0, 40);
            g.drawString(historyArray[currentHistoryNum + 1], 0, 60);
            g.drawString(historyArray[currentHistoryNum + 2], 0, 80);
        }
    }

    class NextButtonHandler implements ActionListener
    {
    	/* This class has a counter which keeps track of the question cards.
    	When the user presses the 'Next' button, nextCounter is used to
    	show the corresponding question card. */
        public void actionPerformed(ActionEvent e)
        {
        	click = e.getActionCommand();
        	if(click.equals("Next"))
        	{
        		nextPressed = true;
        	}
        	
        	if(nextPressed)//if "nextButton" pressed is true
        	{
            		 if (nextCounter%10 == 0)
                         cardLayout.show(qCardPanel, "PROMPT 1");
                     else if (nextCounter%10 == 1)
                         cardLayout.show(qCardPanel, "QUESTION 1");
                     else if (nextCounter%10 == 2)
                         cardLayout.show(qCardPanel, "QUESTION 2");
                     else if (nextCounter%10 == 3)
                         cardLayout.show(qCardPanel, "QUESTION 3");
                     else if (nextCounter%10 == 4)
                         cardLayout.show(qCardPanel, "QUESTION 4");
                     else if (nextCounter%10 == 5)
                         cardLayout.show(qCardPanel, "QUESTION 5");
                     else if (nextCounter%10 == 6)
                         cardLayout.show(qCardPanel, "QUESTION 6");
                     else if (nextCounter%10 == 7)
                         cardLayout.show(qCardPanel, "QUESTION 7");
                     else if (nextCounter%10 == 8)
                         cardLayout.show(qCardPanel, "QUESTION 8");
            		 nextCounter++;
        	}
        }
    }

    class SecondColumn extends JPanel
    {
		/*This class is for the board of the game. It has the drawing of the board.
		The board will consist of 8 circles, and there will be two horizontal lines 
		which indicate the sides. It will communicate with the panel that has
		questions. When one question is done, the corresponding circle will be 
		colored in.*/
        private Font sideFont;

	    public SecondColumn()
	    {
	        sideFont = new Font("Monospaced", Font.BOLD, 20);
	    }
        
	    public void paintComponent (Graphics g)
        {
	    	/* This panel contains the "board" which has two distinct sides
	    	 (the enemy and player's sides). When the user answers the question
	    	 and he/she gets it right/wrong, then the answerArray[questionNum], which is
	    	  used in the QuestionCard classes, is used to determine where the circle
	    	  is to be placed. 
	    	  
	    	  If the user is wrong, then the circle is red. If the user is
	    	  right, then the circle is green. The circles start being drawn
	    	  from the bottom upwards (starting position -> enemy.*/
            super.paintComponent(g);//creates "board"
            setBackground(background);

          //for loop with i less than answerArray.length
            for (int currentQuestionNum = 1; currentQuestionNum < answerArray.length; currentQuestionNum++)
            {
            	//if answerArray[i] = 1
                if (answerArray[currentQuestionNum] == 1)
                {
                	//draw a green circle
                	g.setColor(Color.GREEN);
                	if(currentQuestionNum == 1)
                	{
                		g.fillOval(180, 600, 40, 40);
                	}
                	else if(currentQuestionNum == 2)
                	{
                		g.fillOval(180, 520, 40, 40);
                	}
                	else if(currentQuestionNum == 3)
                	{
                		g.fillOval(180, 440, 40, 40);
                	}
                	else if(currentQuestionNum == 4)
                	{
                		g.fillOval(180, 360, 40, 40);
                	}
                	else if(currentQuestionNum == 5)
                	{
                		g.fillOval(180, 270, 40, 40);
                	}
                	else if(currentQuestionNum == 6)
                	{
                		g.fillOval(180, 180, 40, 40);
                	}
                	else if(currentQuestionNum == 7)
                	{
                		g.fillOval(180, 100, 40, 40);
                	}
                	else if(currentQuestionNum == 8)
                	{
                		g.fillOval(180, 20, 40, 40);
                	}
                }
              //if answerArray[i] = -1
                else if (answerArray[currentQuestionNum] == -1)
                {
                	g.setColor(Color.RED);
                	if(currentQuestionNum == 1)
                	{
                		g.fillOval(180, 600, 40, 40);
                	}
                	else if(currentQuestionNum == 2)
                	{
                		g.fillOval(180, 520, 40, 40);
                	}
                	else if(currentQuestionNum == 3)
                	{
                		g.fillOval(180, 440, 40, 40);
                	}
                	else if(currentQuestionNum == 4)
                	{
                		g.fillOval(180, 360, 40, 40);
                	}
                	else if(currentQuestionNum == 5)
                	{
                		g.fillOval(180, 270, 40, 40);
                	}
                	else if(currentQuestionNum == 6)
                	{
                		g.fillOval(180, 180, 40, 40);
                	}
                	else if(currentQuestionNum == 7)
                	{
                		g.fillOval(180, 100, 40, 40);
                	}
                	else if(currentQuestionNum == 8)
                	{
                		g.fillOval(180, 20, 40, 40);
                	}
                }//draw a red circle
            }//////////////////end for loop
          
            //two parallel lines on north and south side
            g.setColor(Color.BLACK);
            g.drawLine(0, 40, 720, 40);
            g.drawLine(0, 650, 720, 650);
            g.setFont(sideFont);
            g.setColor(Color.RED);
            g.drawString("ENEMY", 200, 20);//north side text = "ENEMY"
            g.setColor(Color.WHITE);
            g.drawString("YOU", 200, 675); //south side text = "YOU"
        }
    }

    class ThirdColumn extends JPanel
    {
        /*This class holds two panels, one that keeps track of the score and
        another which will relay information
        based on the score. The second panel will show up when the user is done
        with the game. The first panel
        will have the score that will change as the user plays and answers the
        question.*/

        private ReviewPanel revp;
        
        public ThirdColumn()
        {
            setLayout(new GridLayout(2,1));//set layout as grid layout with 2 rows and 1 column
            
            scorep = new ScorePanel();
            add(scorep);
            revp = new ReviewPanel();//instantiate ScorePanel and ReviewPanel
            add(revp);//add panels to SecondColumn panel
        }
    }

    class ScorePanel extends JPanel
    {
        /*This panel keeps score of the game. If the user gets a question correct,
        he/she earns one point. If they get it wrong, they lose one point. The score is 
        received from the SubmitButtonHandler class and is sent as a parameter to 
        the method changeScoretoString, which changes the int to a String. The string is 
        then printed to the score panel using paint component.*/
        private Font scoreFont;
        private Font number;
        public ScorePanel()
        {
            scoreFont = new Font("Monospaced", Font.BOLD, 40);
            number  = new Font("Sans Serif", Font.BOLD, 120);
            setBackground(Color.DARK_GRAY);
        }
        
        public void changeScoreToString(int num)
        {
        	printScore = "" + num;
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.YELLOW);
            g.setFont(scoreFont);
            g.drawString("CURRENT SCORE", 40, 30);//draw text "Current Score"
            g.setColor(Color.WHITE);
            g.setFont(number);
            g.drawString(printScore, 200,  200);
        }
    }

    class ReviewPanel extends JPanel
    {
        /*This panel will have content at the end of the game. If the user scores a certain number, a
        corresponding message will appear.*/
        private Font message;
    	private JButton endButton;
        
        public ReviewPanel()
        {
           setBackground(Color.PINK); 
           setLayout(new BorderLayout());
           message = new Font ("Monospaced", Font.BOLD, 40);
           
           endButton = new JButton ("End Game");//create button startButton
           EndButtonHandler ebHandler = new EndButtonHandler();//create instance of class startButtonHandler
           endButton.addActionListener(ebHandler);
           add(endButton, BorderLayout.SOUTH);
        }
        
        public void paintComponent(Graphics g)
        {
        	super.paintComponent(g);
        	g.setFont(message);
        	
        	if(answerArray[currentQuestionNum] == 1)
        	{
        		g.drawString("Good Job!", 20, 70);
        	}
        	else if (answerArray[currentQuestionNum] == -1)
        	{
        		g.drawString("UH OH!", 20, 70);
        	}
        	else if(currentQuestionNum == 8)
        	{
         	   if(score <= 10 && score >= 7)
         	   {
         		   g.setColor(Color.GREEN);
         		   g.drawString("Congrats!", 20, 30);
         		   g.drawString("You have won ", 20, 70);
         		   g.drawString("the war!", 20, 110);
         	   }
         	   else if(score <= 6 && score >= 3)
         	   {
         		   g.setColor(Color.YELLOW);
         		   g.drawString("Good Job!",20, 30 );
         		   g.drawString("You have survived ", 20, 70);
         		   g.drawString("but with injuries!", 20, 110);
         	   }
         	   else
         	   {
         		   g.setColor(Color.RED);
         		   g.drawString("Oh No! You ", 20, 30);
         		   g.drawString("were killed!", 20, 70);
         	   }
            }
        	
        	if(endClicked)
        		panelLayout.show(pHolder, "Game Holder");
        }
    }
    
    class EndButtonHandler implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		click = e.getActionCommand();
    		if(click.equals("End Game"))
    		{
    			endClicked = true;
    		}
    		repaint();
    	}
    }
}
