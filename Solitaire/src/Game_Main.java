import java.io.IOException;
import enigma.core.Enigma;

/*
   PROJECT NAME: SOLITAIRE GAME SOFTWARE
   PROGRAMMING LANGUAGE: JAVA SE
   DEVELOPER: ERDEM AKBABA
   UNIVERSITY: THE UNIVERSITY OF DOKUZ EYLÜL
   FACULTY: FACULTY OF ENGINEERING
   DEPARTMENT: COMPUTER ENGINEERING DEPARTMENT
   DUE DATE: 07.06.2013
   EDUCATION YEAR: 2012-2013/FIRST YEAR-SPRING SEMESTER
   PLEACE: TNAZTEPE CAMPUS-BUCA-ÝZMÝR
 */

public class Game_Main
{
	public static void main(String[] args) throws IOException
	{
		Enigma.getConsole("Game_Main");
		
		Game g = new Game();
		g.simulation();
		
	}
	

}
