// Aniqua Azad
// TrenchWar.java
// 04-18-16
// Description: This program is to help sophomores or those interested in
//history to understand the historical significance behind World War 1 and the aspects of it
//(weapons, leaders, battle tactics, etc). This specific class holds main, and it creates the Frame and call
//class TWPanel, which will create the panels
// Testing: no testing for this particular class

//import libraries
import java.awt.*;
import javax.swing.*;

//create class TrenchWar. This will hold class TrenchWar and create the JFrame
public class TrenchWar extends JFrame
{
    public TrenchWar()
    {
        //create the JFrame
        super ("The Trench War Game");
        
        setSize(1350, 720); //have Frame be 1350 x 720
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false); //re-sizable should be false 
    }

    public static void main (String [] args)
    {
        TrenchWar tw = new TrenchWar();//create instance of class TrenchWar
        tw.run();//call method run() which will call another class
    }

    public void run()
    {

            TWStartPanel twsp = new TWStartPanel();//call class TWPanel which will create the panels
            add(twsp);
            
            setVisible(true);
    }
}