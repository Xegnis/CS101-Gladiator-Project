import java.util.Random;

/*
 * Extends the Fighter class
 * Gladiator is the most basic fighting unit; can upgrade to higher-level units
 */

public class Gladiator extends Fighter
{
	private double deathRate;
	private int price;
	
	private static double defaultDeathRate = 0.75;
	
	public Gladiator ()
	{
		super(5.0, 5.0, 5.0, 5.0);
		this.deathRate = defaultDeathRate;
	}
	
	/*
	 * create a Gladiator object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Gladiator (double str, double agl, double end, double itl)
	{
		super(str, agl, end, itl);
		this.deathRate = defaultDeathRate;
	}
	
	/*
	 * create a Gladiator object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Gladiator (double str, double agl, double end, double itl, double std)
	{
		super(str, agl, end, itl, std);
		this.deathRate = defaultDeathRate;
	}
	
	
	public double getDeathRate ()
	{
		return this.deathRate;
	}
	
	public void setDeathRate (double deathRate)
	{
		this.deathRate = deathRate;
	}
	
	public int getPrice ()
	{
		return this.price;
	}
	
	public void setPrice (int price)
	{
		this.price = price;
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
	
	/*
	 * for writing and reading data
	 * directly assign values to create a Gladiator object 
	 */
	public Gladiator (String name, double str, double agl, double end, double itl, double deathRate)
	{
		super(name, str, agl, end, itl);
		this.deathRate = deathRate;
	}

	/*
	 * for writing and reading data
	 * return a string of data representing the gladiator 
	 */
	public String getData ()
	{
		String data = "";
		data += this.getName() + "\t";
		data += "Gladiator\t";
		data += this.getStr() + "\t";
		data += this.getAgl() + "\t";
		data += this.getEnd() + "\t";
		data += this.getItl() + "\t";
		data += this.getDeathRate();
		return data;
	}

	

//	public static void main(String[] args)
//	{
//
//	}

}
