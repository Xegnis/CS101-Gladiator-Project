/*
 * The main class for the Gladiator Business Simulator
 */

import java.util.*;

public class GBSimulator
{
	static int maxFighter = 10;
	static int initialGold = 500;
	
	/* data that should be stored */
	static Fighter [] fighters = new Fighter[maxFighter];
	static int number;
	static int gold = initialGold;
	/* end */
	
	static String log = "";

	public static void main(String[] args)
	{
		
	}
	
	/*
	 * call this function at the beginning of the program
	 * generates random Gladiators
	 */
	public static void fillWithGladiators (int number)
	{
		for (int i = 0; i < number; i ++)
		{
			addFighter(new Gladiator());
		}
	}
	
	/* 
	 * return an array of randomly generated Fighters
	 * have a chance of generating high-class gladiators
	 */
	public static Fighter [] generateRecruits (int number)
	{
		Fighter [] recruits = new Fighter[number];
		for (int i = 0; i < number; i ++)
		{
			double roll = Math.random();
			if (roll < 0.05)
			{
				recruits[i] = new Hoplomachus();
			}
			else if (roll < 0.1)
			{
				recruits[i] = new Secutor();
			}
			else if (roll < 0.15)
			{
				recruits[i] = new Rudiarius();
			}
			else
			{
				recruits[i] = new Gladiator();
			}
		}
		return recruits;
	}
	
	/*
	 * initiate a battle between two Fighters
	 * adds the amount of gold won to gold
	 * if a Fighter dies, removes the dead Fighter from fighters
	 * writes the result of the battle to log
	 */
	public static void battle (Fighter f1, Fighter f2)
	{
		Fighter [] result = Fighter.compete(f1, f2);
		writeToLog(f1.getName() + " VS. " + f2.getName() + ": " + f1.getName() + " won.\n");
		if (Math.random() < ((Gladiator)f2).getDeathRate())
		{
			removeFighter(f2);
			writeToLog(f2.getName() + " died.");
		}
		gold += Fighter.winGold(f1, f2);
	}
	
	/* concatenate message to log */
	public static void writeToLog (String message)
	{
		log += message;
	}
	
	/* clear log */
	public static void clearLog ()
	{
		log = "";
	}
	
	/* use this method to add a fighter to fighters */
	public static void addFighter(Fighter f)
	{
		if (number < fighters.length)
		{
			fighters[number] = f;
			number ++;
		}
		//TODO throw an exception if number is out of range?
	}
	
	/*remove a Fighter from fighters and bring the following entries forward */
	public static void removeFighter (Fighter f)
	{
		fighters[Arrays.binarySearch(fighters, f)] = null;
		for (int i = Arrays.binarySearch(fighters, f); i < fighters.length; i ++)
		{
			if (i == (fighters.length - 1))
			{
				fighters[i] = null;
			}
			else
			{
				fighters[i] = fighters[i + 1];
			}
		}
	}
	
	public static boolean WriteToTabDelimitedFile(String[] data, String FileName)
	{
		try
		{
			FileWriter fileWritter = new FileWriter(FileName);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			// loop through all your data and print it to the file
			for (int i=0;i< data.length;i++)
					bufferWritter.write(data[i]+"\t");
			bufferWritter.write("\n");
			bufferWritter.close();
		}
		catch (IOException e)
		{
			System.out.println("Error Printing Tab Delimited File");
			return false;
		}
		return true;
	}
	
	public static boolean appendToTabDelimitedFile (String[] data, String FileName)
	{
		try
		{
			File file =new File(FileName);
			if(!file.exists()) //if file doesn’t exists, return false
				return false;
			FileWriter fileWritter = new FileWriter(file.getName(),true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			for (int i=0;i< data.length;i++)
				bufferWritter.write(data[i]+"\t");
			bufferWritter.write("\n");
			bufferWritter.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return true;
	}
		
	public static String [] readFromTabDelimitedFile (String FileName)
	{
		List<String> lines = new ArrayList<String>();
		try
		{
			FileReader fileReader = new FileReader(FileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null)
				lines.add(line);
			bufferedReader.close();
		}
		catch (IOException e)
		{
		e.printStackTrace();
		}
		return lines.toArray(new String[lines.size()]);
	}	
}
