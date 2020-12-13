/*
 *	The base class for all fighting units
 *	Cannot be used to create objects that directly take part in battles
*/

import java.util.Random;

public abstract class Fighter
{
	/* Attributes */
	
	/*
	 * rounded to 1 decimal place
	 * all attributes are between 0.0 and 10.0 inclusive
	*/
	private double str;	//strength
	private double agl;	//agility
	private double end;	//endurance
	private double itl;	//intelligence
	
	private String name;
	
	private static double defaultStd = 1.0;
	private static String [] names = {
									"Kinan", "Romulus", "Eran", "Tyvarius", "Simarion", "QyaJi", "Uri",
									"Mikhail", "Montiago", "Nyrilius", "Samtan", "Syna", "Adrastus",
									"Eros", "Atlas", "Adonis", "Astor", "Knox", "Kai", "Zyan", "Remus",
									"Liber", "Billy", "Amiya", "Arjan", "Cameron", "Nick", "Tye", "Calix", "Amol"
									};
	
	private static Random normal = new Random();

	/* Constructors */
	
	public Fighter ()
	{
		this(5.0, 5.0, 5.0, 5.0);
	}
	
	/*
	 * create a Fighter object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Fighter (double str, double agl, double end, double itl)
	{
		this.name = randomName();
		this.str = roundAtr(str + normal.nextGaussian() * defaultStd);
		this.agl = roundAtr(agl + normal.nextGaussian() * defaultStd);
		this.end = roundAtr(end + normal.nextGaussian() * defaultStd);
		this.itl = roundAtr(itl + normal.nextGaussian() * defaultStd);
	}
	
	/*
	 * create a Fighter object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Fighter (double str, double agl, double end, double itl, double std)
	{
		this.name = randomName();
		this.str = roundAtr(str + normal.nextGaussian() * std);
		this.agl = roundAtr(agl + normal.nextGaussian() * std);
		this.end = roundAtr(end + normal.nextGaussian() * std);
		this.itl = roundAtr(itl + normal.nextGaussian() * std);
	}
	
	/*
	 * for writing and reading data
	 * directly assign values to create a Fighter object 
	 */
	public Fighter (String name, double str, double agl, double end, double itl)
	{
		this.name = name;
		this.str = str;
		this.agl = agl;
		this.end = end;
		this.itl = itl;
	}
	
	/* Behaviors */
	
	//contain and round doubles to 1 decimal place and for attribute use
	public double roundAtr (double atr)
	{
		double rounded = (double)Math.round(atr * 10) / 10.0;
		if (rounded > 10.0)
		{
			rounded = 10.0;
		}
		else if (rounded < 0.0)
		{
			rounded = 0.0;
		}
		return rounded;
	}
	
	/* return a random name from names */
	public static String randomName ()
	{
		return names[(int)Math.random() * names.length];
	}
	
	/*
	 * Getters and Setters
	 * set() assigns the value of the argument directly to the attribute
	 * setNormal() assigns a normally distributed value instead
	 * Setters contain and round the numbers
	 */
	
	public double getStr ()
	{
		return this.str;
	}
	
	public void setStr (double str)
	{
		this.str = roundAtr(str);
	}
	
	public void setStrNormal (double str)
	{
		this.str = roundAtr(str + normal.nextGaussian() * defaultStd);
	}
	
	public void setStrNormal (double str, double std)
	{
		this.str = roundAtr(str + normal.nextGaussian() * std);
	}
	
	public double getAgl ()
	{
		return this.agl;
	}
	
	public void setAgl (double agl)
	{
		this.agl = roundAtr(agl);
	}
	
	public void setAglNormal (double agl)
	{
		this.agl = roundAtr(agl + normal.nextGaussian() * defaultStd);
	}
	
	public void setAglNormal (double agl, double std)
	{
		this.agl = roundAtr(agl + normal.nextGaussian() * std);
	}
	
	public double getEnd ()
	{
		return this.end;
	}
	
	public void setEnd (double end)
	{
		this.end = roundAtr(end);
	}
	
	public void setEndNormal (double end)
	{
		this.end = roundAtr(end + normal.nextGaussian() * defaultStd);
	}
	
	public void setEndNormal (double end, double std)
	{
		this.end = roundAtr(end + normal.nextGaussian() * std);
	}
	
	public double getItl ()
	{
		return this.itl;
	}
	
	public void setItl (double itl)
	{
		this.itl = roundAtr(itl);
	}
	
	public void setItlNormal (double itl)
	{
		this.itl = roundAtr(itl + normal.nextGaussian() * defaultStd);
	}
	
	public void setItlNormal (double itl, double std)
	{
		this.itl = roundAtr(itl + normal.nextGaussian() * std);
	}
	
	//return all attributes as an array of doubles
	public double[] getAtr ()
	{
		double [] atr = {getStr(), getAgl(), getEnd(), getItl()};
		return atr;
	}
	
	// set all attributes at the same time
	public void setAtr (double str, double agl, double end, double itl)
	{
		setStr(str);
		setAgl(agl);
		setEnd(end);
		setItl(itl);
	}
	
	public void setAtrNormal (double str, double agl, double end, double itl)
	{
		setStrNormal(str);
		setAglNormal(agl);
		setEndNormal(end);
		setItlNormal(itl);
	}
	
	public void setAtrNormal (double str, double agl, double end, double itl, double std)
	{
		setStrNormal(str, std);
		setAglNormal(agl, std);
		setEndNormal(end, std);
		setItlNormal(itl, std);
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	 /* End of Getters and Setters */
	
	@Override
	public String toString ()
	{
		return ("Name: " + getName() + "\n" +
				"Strength: " + getStr() + "\n" +
				"Agility: " + getAgl() + "\n" +
				"Endurance: " + getEnd() + "\n" +
				"Intelligance: " + getItl());
	}
	
	/*this method compares attributes between two fighters and return the result as an array of Fighters
	 * the Fighter at index 0 is the winner and the other at index 1 is the loser
	 */
	public static Fighter [] compete (Fighter f1, Fighter f2)
	{
 
		double randomFactor = 0.2;
 
		double selfPerformance = f1.getStr() * f1.getAgl() * f1.getEnd() * f1.getItl() *(1 + randomFactor * normal.nextGaussian());
		double opponentPerformance = f2.getStr() * f2.getAgl() * f2.getEnd() * f2.getItl() *(1 + randomFactor * normal.nextGaussian());
 
		if (selfPerformance > opponentPerformance)
		{
			Fighter [] result = {f1, f2};
			return result;
		}
		else
		{
			Fighter [] result = {f2, f1};
			return result;
		}
	}
	
	/*
	 * returns the amount of gold won between 
	 */
	public static int winGold (Fighter f1, Fighter f2)
	{
		double randomFactor = 0.1;
		int baseGold = 100;
	 
		double selfPerformance = f1.getStr() * f1.getAgl() * f1.getEnd() * f1.getItl();
		double opponentPerformance = f2.getStr() * f2.getAgl() * f2.getEnd() * f2.getItl();
		
		/*
		 * profit is increased when fighters are more skilled and when they are more closely matched
		 */
		
		int gold = (int)((1 + randomFactor * normal.nextGaussian()) * baseGold * (selfPerformance + opponentPerformance) / (1 + Math.abs(selfPerformance - opponentPerformance)));
		return gold;
	}
	
	
	public static void main (String[] args)
	{
//		Fighter f1 = new Fighter();
//		Fighter f2 = new Fighter("Fighter 2", 5, 5, 5, 5);
//		Fighter f3 = new Fighter("Fighter 3", 2, 3, 4, 5, 10);
//		
//		f1.setName("Fighter 1");
//		f2.setAtr(5, 5, 5, 5);
//		
//		System.out.println(f1);
//		System.out.println();
//		System.out.println(f2);
//		System.out.println();
//		System.out.println(f3);
//		System.out.println(f3.getAtr()[0]);
//		System.out.println();
//		
//		for (int i = 0; i < 10; i ++)
//		{
//			f1.setAtrNormal(5, 5, 5, 5);
//			System.out.println(f1);
//			System.out.println();
//		}
//		
//		System.out.println(Fighter.number);
//		f3.die();
//		System.out.println(Fighter.number);
		
		System.out.println(randomName());
	}
}
