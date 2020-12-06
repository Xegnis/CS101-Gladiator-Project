/*
 * Extends the Fighter class
 * Gladiator is the most basic fighting unit; can upgrade to higher-level units
 */

public class Gladiator extends Fighter
{
	private double deathRate;
	
	private static int number = 0;
	private double defaultDeathRate = 0.75;
	private static double defaultStd = 1.0;
	
	public Gladiator ()
	{
		super(new String("default"), 5.0, 5.0, 5.0, 5.0);
		this.deathRate = defaultDeathRate;
	}
	
	public Gladiator (String name)
	{
		super(name, 5.0, 5.0, 5.0, 5.0);
		this.deathRate = defaultDeathRate;
	}
	
	/*
	 * create a Gladiator object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Gladiator (String name, double str, double agl, double end, double itl)
	{
		super(name, str, agl, end, itl);
		this.deathRate = defaultDeathRate;
		number ++;
	}
	
	/*
	 * create a Gladiator object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Gladiator (String name, double str, double agl, double end, double itl, double std)
	{
		super(name, str, agl, end, itl, std);
		this.deathRate = defaultDeathRate;
		number ++;
	}
	
	public boolean compete (Fighter op)
	{
		/*
		 * TODO: develop an algorithm that compares attributes between this gladiator and another fighter using the four attributes
		 * true means that the fighter that calls this method has won and vice versa
		 * calls checkDeath() for the losing fighter
		 */
		return true;
	}
	
	public void checkDeath ()
	{
		if (Math.random() < deathRate)
		{
			this.die();
		}
		else
		{
			return;
		}
	}
	
	@Override
	public String toString ()
	{
		return ("Name: " + getName() + "\n" +
				"Type: " + "Gladiator\n" +
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
