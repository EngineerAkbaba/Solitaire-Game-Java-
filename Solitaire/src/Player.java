import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import enigma.core.Enigma;

public class Player
{
	enigma.console.Console cn = Enigma.getConsole();
	
	// Fields
	private String name;
	private String surname;
	private int score;
	
	// Constructor with parameter
	public Player (String name, String surname, int score)
	{
		this.name = name;
		this.surname = surname;
		this.score = score;
	}
	
	// Constructor without parameter in case we ned
	public Player ()
	{
		name = null;
		surname = null;
		score = 0;
	}
	
	// Get-Set methods
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}
	
	// Reading the scor list from file and add it to double linked list
	public Double_Linked_List scor_list (Double_Linked_List d) throws IOException
	{
		String line_scor = null;
		int counter = 0;
		String[] x = null;
		File f_scor = new File("ScorList.txt");
		BufferedReader b_scor = new BufferedReader(new FileReader(f_scor));
		String temp_string = " ";
		while (counter < 10)
		{
			temp_string = b_scor.readLine();
			if (!(temp_string.equals(null)))
			{
				counter++;
				line_scor = temp_string;
			}
			String[] scor_split = new String[10];
			for (int i = 0; i <scor_split.length; i++)
			{
				scor_split = line_scor.split(",");
				x = scor_split;
			}
			Player p = new Player(x[0], x[1], Integer.parseInt(x[2]));
			d.add_increasing_order(p);
		}
		cn.getTextWindow().setCursorPosition(0, 0);
		d.disaplayFromHead();
		//d.displayFromTail();
		return d;
	}
	
}
