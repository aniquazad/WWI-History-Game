//Aniqua Azad
//TWGamePanel.java
//04-22-16
//This panel will have the game itself. It will be a grid layout, where
//there are 3 columns and 1 row. The left and right column will hold two
//panels each, while the center most panel will have the board for the game.
//The questions and history will be taken from two text files, and they
//will be via cardLayout.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TWGamePanel extends JFrame
{
		//declare variables
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
	    //card layouts
	    private CardLayout cardLayout;
	    //panel holder which holds all panels
	    private BoardPanel boardp;
	
	    public TWGamePanel()
	    {    
	      super("Game Panel");
	      setSize(1350, 720); //have Frame be 1350 x 720
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	      setResizable(false); //re-sizable should be false
	      //colors and fonts     
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
	      //strings
	      answer = "";
	      click = "";
	      /////////////////////////////////////
	      qCardPanel = new QuestionCardHolderPanel();
	      hCardPanel = new HistoryCardHolderPanel();
	      //card layout
	      cardLayout = new CardLayout();
	      //add layout to card panel holders
	      qCardPanel.setLayout(cardLayout);
	      hCardPanel.setLayout(cardLayout);
	      pcard1 = new PromptCard1();
	      pcard2 = new PromptCard2();
	            
	      qcard1 = new QuestionCard1();
	      qcard2 = new QuestionCard2();
	      qcard3 = new QuestionCard3();
	      qcard4 = new QuestionCard4();
	      qcard5 = new QuestionCard5();
	      qcard6 = new QuestionCard6();
	      qcard7 = new QuestionCard7();
	      qcard8 = new QuestionCard8();

          hcard1 = new HistoryCard1();
          hcard2 = new HistoryCard2();
          hcard3 = new HistoryCard3();
          hcard4 = new HistoryCard4();
          hcard5 = new HistoryCard5();
          hcard6 = new HistoryCard6();
          hcard7 = new HistoryCard7();
          hcard8 = new HistoryCard8();//instantiate cards
            ///////////////////////////////////////
                //make labels for cards with questions
          qLabel1 = new JLabel ("Question 1");
          qLabel2 = new JLabel ("Question 2");
          qLabel3 = new JLabel ("Question 3");
          qLabel4 = new JLabel ("Question 4");
          qLabel5 = new JLabel ("Question 5");
          qLabel6 = new JLabel ("Question 6");
          qLabel7 = new JLabel ("Question 7");
          qLabel8 = new JLabel ("Question 8");
            ///////////////////////////////////////
                //make label for cards with history
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
          //card panel holder
	     
	      //panel holder which holds all panels
	      boardp = new BoardPanel();
          add(boardp); //add panel holder to frame
            //////////////////////////////////////////////////////
          setVisible(true);
        }
        
        public static void main(String [] args)
        {
            TWGamePanel twgp = new TWGamePanel();
        }

        class BoardPanel extends JPanel
        {
            //This class will be the panel for the game itself. It will have a
            //diagram of a "trench" with 10
            //circles in various places. This game will have cards that ask
            //questions as well as answer
            //choices. There will also be a "next" button that the user will
            //press to go to the "history card"
            //and then they will press the button to go to the next question.
            //After each question, 1 circle will
            //be colored in.

            //variables of column panels
            //columnOne, two, three
            private FirstColumn columnOne;
            private SecondColumn columnTwo;
            private ThirdColumn columnThree;
            
            public BoardPanel()
            {
              //layout will be gridLayout with 3 columns and 1 row
              setLayout(new GridLayout (1,3));
              setBackground(Color.BLACK);//set background color
              
              columnOne = new FirstColumn();
              columnTwo = new SecondColumn();
              columnThree = new ThirdColumn();//instantiate column panels
              
              add(columnOne);
              add(columnTwo);
              add(columnThree);//add column panels
            }
        }

        class FirstColumn extends JPanel
        {
            //This class holds the question and history cards for the game.
            private QuestionPanel questp;
            private HistoryPanel histp;
            public FirstColumn()
            {
                setLayout(new GridLayout (2, 1));//set layout as grid layout with 2 rows and 1 column
                
                questp = new QuestionPanel();//instantiate QuestionPanel and HistoryPanel
                histp = new HistoryPanel();
                
                add(questp);
                add(histp);//add QuestionPanel and HistoryPanel to FirstColumn panel
            }
        }

        class QuestionPanel extends JPanel
        {
        //This class will be a cardLayout and it will ask the user questions on the
        //history of WWI. The questions
        //will be retrieved from Questions.txt . There will be 4 options from which
        //the user can choose exactly
        //one answer. After the user is done selecting, he/she will click the
        //"submit" button, and they will be
        //able to see if they were correct or incorrect.

        //declare variables
        int currentQuestionNum;//for currentQuestionNum
        Scanner questionFileScanner;
        File questionFile;
        private PrintWriter printQuestion;
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
        	private Font prompt1Instruc;
        	
        	public PromptCard1()
        	{
        		setBackground(Color.YELLOW);
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
            public void actionPerformed(ActionEvent e)
            {
                click = e.getActionCommand();
                submitPressed = true;

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
                repaint();
                //boardp.repaint();
            }
            
            public void checkAnswer()
            {
            	
            }
        }
    

        class HistoryPanel extends JPanel
        {
        //red or green card
        //This class will tell the user if he/she got the answer to the question
        //wrong by comparing the choice
        //with the correct answer from Answers.txt . It will then tell the user a
        //brief history about the question
        //which will be retrieved from History.txt . After the user is done
        //reading, he/she will click the "next"
        //button which will change the top panel to the next question.

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
        		setBackground(Color.GREEN);
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
            public void actionPerformed(ActionEvent e)
            {
            	nextPressed = true;
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
    //This class is for the board of the game. It has the drawing of the board.
    //The board will consist of
    //ten circles with lines between them (almost as a map), and there will be
    //two horizontal lines which
    //indicate the sides. It will communicate with the panel that has
    //questions. When one question is done,
    //the corresponding circle will be colored in.
            private Font sideFont;

        public SecondColumn()
        {
        //instantiate variables
            sideFont = new Font("Monospaced", Font.BOLD, 20);
        }
            public void paintComponent (Graphics g)
            {
                super.paintComponent(g);//create "board"
                setBackground(background);

                for (int currentQuestionNum = 1; currentQuestionNum < answerArray.length; currentQuestionNum++)
                {//for loop with i less than answerArray.length
                    if (answerArray[currentQuestionNum] == 1)
                    {//if answerArray[i] = 1
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
                    }//draw a green circle
                    else if (answerArray[currentQuestionNum] == -1)
                    {//if answerArray[i] = -1
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
                //ScorePanel sp = new ScorePanel();
                //sp.changeScoreToString(score);
                scorep.changeScoreToString(score);
                scorep.repaint();
                //sp.repaint();
                g.setColor(Color.BLACK);
                g.drawLine(0, 40, 720, 40);
                g.drawLine(0, 650, 720, 650);
                g.setFont(sideFont);
                g.setColor(Color.RED);
                g.drawString("ENEMY", 200, 20);
                g.setColor(Color.WHITE);
                g.drawString("YOU", 200, 675);//two parallel lines on north and south side
                    //south side text = "YOU"
                    //north side text = "ENEMY"
            }
        }

        class ThirdColumn extends JPanel
        {
            //This class holds two panels, one that keeps track of the score and
            //another which will relay information
            //based on the score. The second panel will show up when the user is done
            //with the game. The first panel
            //will have the score that will change as the user plays and answers the
            //question.

                //private ScorePanel scorep;
                private ReviewPanel revp;
            public ThirdColumn()
            {
                setLayout(new GridLayout(2,1));//set layout as grid layout with 2 rows and 1 column
                scorep = new ScorePanel();
                revp = new ReviewPanel();//instantiate ScorePanel and ReviewPanel
                add(scorep);
                add(revp);//add panels to SecondColumn panel
            }
        }

        class ScorePanel extends JPanel
        {
            //This panel keeps score of the game. If the user gets a question correct,
            //he/she earns one point. if
            //they get it wrong, they lose one point.
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
            //this panel will have content at the end of the game. If the user scores a certain number, a
            //corresponding message will appear.
            private Font message;
        	
            public ReviewPanel()
            {
               setBackground(Color.PINK); 
               message = new Font ("Monospaced", Font.BOLD, 20);
            }
            
            public void paintComponent(Graphics g)
            {
            	super.paintComponent(g);
            	g.setFont(message);
            	if (currentQuestionNum == 8)
                {
             	   if(score <= 10 && score >= 7)
             	   {
             		   g.setColor(Color.GREEN);
             		   g.drawString("Congrats! You have won the war!", 10, 30);
             	   }
             	   else if(score <= 6 && score >= 3)
             	   {
             		   g.setColor(Color.YELLOW);
             		   g.drawString("You have survived the war with multiple injuries!", 10, 30);
             	   }
             	   else
             	   {
             		   g.setColor(Color.RED);
             		   g.drawString("Oh No! You were killed!", 10, 30);
             	   }
                }
            }
        }
    }
