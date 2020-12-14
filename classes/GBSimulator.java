/*
 * The main class for the Gladiator Business Simulator
 */

import java.util.*;
import java.io.*;

public class GBSimulator
{
	static int maxFighter = 10;
	static int initialGold = 500;
	
	/* data that should be stored */
	static Fighter [] fighters = new Fighter[maxFighter];
	
	static int number = 0;
	static int gold = initialGold;
	
	static String[] fighterData = new String[maxFighter];
	static String[] genData = new String[2];
	/* end */
	
	static String log = "";
	static Fighter[] recruits = new Fighter[3];

	public static void main(String[] args)
	{
//		fillWithGladiators(3);
//		for (int i = 0; i < 3; i ++)
//		{
//			System.out.println(fighters[i]);
//		}
//		clearLog();
//		System.out.println(Arrays.toString(readFromTabDelimitedFile("GenData.txt")));
//		System.out.println(Arrays.toString(readFromTabDelimitedFile("FighterData.txt")));
//		readData();
//		System.out.println(number + " " + gold);
//		System.out.println(Arrays.toString(fighters));
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
	public static void generateRecruits ()
	{
		int number = 3;
		Fighter [] newRecruits = new Fighter[number];
		for (int i = 0; i < number; i ++)
		{
			double roll = Math.random();
			if (roll < 0.05)
			{
				newRecruits[i] = new Hoplomachus();
			}
			else if (roll < 0.1)
			{
				newRecruits[i] = new Secutor();
			}
			else if (roll < 0.15)
			{
				newRecruits[i] = new Rudiarius();
			}
			else
			{
				newRecruits[i] = new Gladiator();
			}
		}
		recruits = newRecruits;
	}
	
	/* train a gladiator */
	public static void train (Fighter f)
	{
		f.train();
		gold -= 50;
	}
	
	/* recruit one of the three recruits */
	public static void recruit (int num)
	{
		addFighter(recruits[num]);
		gold -= 100;
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
		writeToLog("Current gold is " + gold);
	}
	
	/* store information about gladiators in fighters to fighterData[] */
	public static void logFighterData ()
	{
		for (int i = 0; i < fighters.length; i++)
		{
			if (fighters[i] != null)
				fighterData[i] = ((Gladiator)fighters[i]).getData();
		}
	}
	
	/* store general information to genData[] */
	public static void logGenData ()
	{
		genData[0] = String.valueOf(number);
		genData[1] = String.valueOf(gold);
	}
	
	/* concatenate message to log */
	public static void writeToLog (String message)
	{
		log += message;
	}
	
	/* clear log and write data to file*/
	public static void clearLog ()
	{
		logGenData();
		logFighterData();
		if (writeToTabDelimitedFile(genData, "GenData.txt") && writeToTabDelimitedFile(fighterData, "FighterData.txt"))
		{
			log = "";
		}
	}
	
	/* convert all written data back into program data */
	public static void readData ()
	{
		number = 0;
		gold = 0;
		for (int i = 0; i < fighters.length; i ++)
		{
			fighters[i] = null;
		}
		
		String [] genData = readFromTabDelimitedFile("GenData.txt");
		String [] fighterData = readFromTabDelimitedFile("FighterData.txt");
		
		for (int i = 0; i < fighters.length; i ++)
		{
			if (!(fighterData[i].equals("null")))
			{
				String [] data = fighterData[i].split("\t");
				if (data[1].equals("Hoplomachus"))
				{
					addFighter(new Hoplomachus(data[0], Double.parseDouble(data[2]), Double.parseDouble(data[3]), 
							Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6])));
				}
				else if (data[1].equals("Secutor"))
				{
					addFighter(new Secutor(data[0], Double.parseDouble(data[2]), Double.parseDouble(data[3]), 
							Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6])));
				}
				else if (data[1].equals("Rudiarius"))
				{
					addFighter(new Rudiarius(data[0], Double.parseDouble(data[2]), Double.parseDouble(data[3]), 
							Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6])));
				}
				else
				{
					addFighter(new Gladiator(data[0], Double.parseDouble(data[2]), Double.parseDouble(data[3]), 
							Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6])));
				}
			}
		}
		
		number = Integer.parseInt(genData[0]);
		gold = Integer.parseInt(genData[1]);
	}
	
	/* use this method to add a fighter to fighters */
	public static void addFighter(Fighter f)
	{
		if (number < fighters.length)
		{
			fighters[number] = f;
			number ++;
		}
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
		number --;
	}
	
	public static boolean writeToTabDelimitedFile(String[] data, String FileName)
	{
		try
		{
			FileWriter fileWritter = new FileWriter(FileName);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

			for (int i=0;i< data.length;i++)
					bufferWritter.write(data[i]+"\n");
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
			if(!file.exists()) //if file does not exists, return false
				return false;
			FileWriter fileWritter = new FileWriter(file.getName(),true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			for (int i=0;i< data.length;i++)
				bufferWritter.write(data[i]+"\n");
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
