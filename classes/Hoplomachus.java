/*
 * subclass of Gladiator
 * special ability: has higher attributes than normal gladiators (maximum of 15 instead of 10 and a minimum of 10)
 */

public class Hoplomachus extends Gladiator
{
	private static double defaultDeathRate = 0.5;
	private static double defaultStd = 0.8;
	
	/*
	 * create a Hoplomachus object with attributes normally distributed
	 * with a mean of 12 and a standard deviation of defaultStd;
	*/
	public Hoplomachus ()
	{
		super(12.0, 12.0, 12.0, 12.0, defaultStd);
		this.setDeathRate(defaultDeathRate);
	}
	
	/*
	 * create a Hoplomachus object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Hoplomachus (double str, double agl, double end, double itl)
	{
		super(str, agl, end, itl, defaultStd);
		this.setDeathRate(defaultDeathRate);
	}
	
	/*
	 * create a Hoplomachus object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Hoplomachus (double str, double agl, double end, double itl, double std)
	{
		super(str, agl, end, itl, std);
	}
	
	/* control the range of attributes (no more than 15, no less than 10) */
	@Override
	public double roundAtr (double atr)
	{
		double rounded = (double)Math.round(atr * 10) / 10.0;
		if (rounded > 15.0)
		{
			rounded = 15.0;
		}
		else if (rounded < 10.0)
		{
			rounded = 0.0;
		}
		return rounded;
	}
	
	/*
	 * for writing and reading data
	 * directly assign values to create a Hoplomachus object 
	 */
	public Hoplomachus (String name, double str, double agl, double end, double itl, double deathRate)
	{
		super(name, str, agl, end, itl, deathRate);
	}
	
	@Override
	public String toString ()
	{
		return ("Name: " + getName() + "\n" +
				"Type: " + "Hoplomachus\n" +
				"Ability: spectacular attributes\n" +
				"Strength: " + getStr() + "\n" +
				"Agility: " + getAgl() + "\n" +
				"Endurance: " + getEnd() + "\n" +
				"Intelligance: " + getItl());
	}

//	public static void main(String[] args)
//	{
//		
//	}

}
