/*
 * subclass of Gladiator
 * special ability: has lower base stat but training works better on Rudiarius (increase 2 per training instead of 1)
 */

public class Rudiarius extends Gladiator
{
	private static double defaultDeathRate = 0.5;
	private static double defaultStd = 1;
	
	/*
	 * create a Rudiarius object with attributes normally distributed
	 * with a mean of 7.5 and a standard deviation of defaultStd;
	*/
	public Rudiarius ()
	{
		super(4, 4, 4, 4, defaultStd);
		this.setDeathRate(defaultDeathRate);
	}
	
	/*
	 * create a Rudiarius object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Rudiarius (double str, double agl, double end, double itl)
	{
		super(str, agl, end, itl, defaultStd);
		this.setDeathRate(defaultDeathRate);
	}
	
	/*
	 * create a Rudiarius object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Rudiarius (double str, double agl, double end, double itl, double std)
	{
		super(str, agl, end, itl, std);
		this.setDeathRate(defaultDeathRate);
	}
	
	/* control the range of attributes (no more than 8, no less than 0) */
	@Override
	public double roundAtr (double atr)
	{
		double rounded = (double)Math.round(atr * 10) / 10.0;
		if (rounded > 8.0)
		{
			rounded = 8.0;
		}
		else if (rounded < 0.0)
		{
			rounded = 0.0;
		}
		return rounded;
	}
	
	/*
	 * for writing and reading data
	 * directly assign values to create a Rudiarius object 
	 */
	public Rudiarius (String name, double str, double agl, double end, double itl, double deathRate)
	{
		super(name, str, agl, end, itl, deathRate);
	}
	
	public String toString ()
	{
		return ("Name: " + getName() + "\n" +
				"Type: " + "Rudiarius\n" +
				"Ability: grows faster with training\n" +
				"Strength: " + getStr() + "\n" +
				"Agility: " + getAgl() + "\n" +
				"Endurance: " + getEnd() + "\n" +
				"Intelligance: " + getItl());
	}
	
	/*
	 * train a Rudiarius
	 * increase all of the attributes by 2
	 */
	@Override
	public void train ()
	{
		this.setStr(this.getStr() + 2.0);
		this.setAgl(this.getAgl() + 2.0);
		this.setEnd(this.getEnd() + 2.0);
		this.setItl(this.getItl() + 2.0);
	}

//	public static void main(String[] args)
//	{
//		Rudiarius h = new Rudiarius();
//		System.out.println (h);
//	}
}
