/*
 * subclass of Gladiator
 * special ability: has slightly higher attributes than normal gladiators (maximum of 12 instead of 10)
 * impossible to die
 */
public class Secutor extends Gladiator
{
	private static double defaultDeathRate = 0;
	private static double defaultStd = 0.8;
	
	/*
	 * create a Secutor object with attributes normally distributed
	 * with a mean of 7.5 and a standard deviation of defaultStd;
	*/
	public Secutor ()
	{
		super(7.5, 7.5, 7.5, 7.5, defaultStd);
		this.setDeathRate(defaultDeathRate);
	}
	
	/*
	 * create a Secutor object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Secutor (double str, double agl, double end, double itl)
	{
		super(str, agl, end, itl, defaultStd);
		this.setDeathRate(defaultDeathRate);
	}
	
	/*
	 * create a Secutor object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Secutor (double str, double agl, double end, double itl, double std)
	{
		super(str, agl, end, itl, std);
		this.setDeathRate(defaultDeathRate);
	}
	
	/* control the range of attributes (no more than 11, no less than 5) */
	@Override
	public double roundAtr (double atr)
	{
		double rounded = (double)Math.round(atr * 10) / 10.0;
		if (rounded > 11.0)
		{
			rounded = 11.0;
		}
		else if (rounded < 5.0)
		{
			rounded = 5.0;
		}
		return rounded;
	}
	
	/*
	 * for writing and reading data
	 * directly assign values to create a Secutor object 
	 */
	public Secutor (String name, double str, double agl, double end, double itl, double deathRate)
	{
		super(name, str, agl, end, itl, deathRate);
	}
	
	public String toString ()
	{
		return ("Name: " + getName() + "\n" +
				"Type: " + "Secutor\n" +
				"Ability: impossible to die in battle\n" +
				"Strength: " + getStr() + "\n" +
				"Agility: " + getAgl() + "\n" +
				"Endurance: " + getEnd() + "\n" +
				"Intelligance: " + getItl());
	}
	
	/*
	 * for writing and reading data
	 * return a string of data representing the Secutor
	 */
	@Override
	public String getData ()
	{
		String data = "";
		data += this.getName() + "\t";
		data += "Secutor\t";
		data += this.getStr() + "\t";
		data += this.getAgl() + "\t";
		data += this.getEnd() + "\t";
		data += this.getItl() + "\t";
		data += this.getDeathRate();
		return data;
	}

//	public static void main(String[] args)
//	{
//		Secutor h = new Secutor();
//		System.out.println (h);
//	}
}
