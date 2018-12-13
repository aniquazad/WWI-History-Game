import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HistoryReader 
{
	private String [] historyArray;
	private Scanner historyFileScanner;
	private File historyFile;
	public HistoryReader()
	{
		historyArray = new String [36];
		historyFile = new File ("History.txt");
	}
	public static void main(String[] args) 
	{
		HistoryReader hr = new HistoryReader();
		hr.run();
	}
	
	public void run()
	{
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
				{
					historyArray[histLine++] = historyPrompt;
				}
				System.out.println(historyArray[1]);
         }
         historyFileScanner.close();
     }
 }
