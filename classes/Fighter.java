/*
 *	The base class for all fighting units
 *	Cannot be used to create objects that directly take part in battles
*/

import java.util.Random;

public class Fighter
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
	
	private static int number = 0;
	private static double defaultStd = 1.0;
	
	private Random normal = new Random();

	/* Constructors */
	
	public Fighter ()
	{
		this(new String("default"), 5.0, 5.0, 5.0, 5.0);
	}
	
	/*
	 * create a Fighter object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Fighter (String name, double str, double agl, double end, double itl)
	{
		this.name = name;
		this.str = roundAtr(str + normal.nextGaussian() * defaultStd);
		this.agl = roundAtr(agl + normal.nextGaussian() * defaultStd);
		this.end = roundAtr(end + normal.nextGaussian() * defaultStd);
		this.itl = roundAtr(itl + normal.nextGaussian() * defaultStd);
		number ++;
	}
	
	/*
	 * create a Fighter object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Fighter (String name, double str, double agl, double end, double itl, double std)
	{
		this.name = name;
		this.str = roundAtr(str + normal.nextGaussian() * std);
		this.agl = roundAtr(agl + normal.nextGaussian() * std);
		this.end = roundAtr(end + normal.nextGaussian() * std);
		this.itl = roundAtr(itl + normal.nextGaussian() * std);
		number ++;
	}
	
	/* Behaviors */
	
	//contain and round doubles to 1 decimal place and for attribute use
	public static double roundAtr (double atr)
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
	
	public static int getNumber ()
	{
		return number;
	}
	
	//call this function when a fighter dies to subtract 1 from number
	public void die ()
	{
		number --;
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
	
//	public static void main (String[] args)
//	{
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
//	}
}
