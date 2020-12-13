/*
 * subclass of Gladiator
 * special ability: has higher attributes than normal gladiators (maximum of 15 instead of 10 and a minimum of 10)
 */

public class Hoplomachus extends Gladiator
{
	private static double defaultStd = 0.8;
	
	/*
	 * create a Hoplomachus object with attributes normally distributed
	 * with a mean of 12 and a standard deviation of defaultStd;
	*/
	public Hoplomachus ()
	{
		super(12.0, 12.0, 12.0, 12.0, defaultStd);
	}
	
	/*
	 * create a Hoplomachus object with attributes normally distributed
	 * with the designated values as means and a standard deviation of defaultStd;
	*/
	public Hoplomachus (String name, double str, double agl, double end, double itl)
	{
		super(str, agl, end, itl, defaultStd);
	}
	
	/*
	 * create a Hoplomachus object with attributes normally distributed
	 * with the designated values as means and a standard deviation of std
	*/
	public Hoplomachus (String name, double str, double agl, double end, double itl, double std)
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

//	public static void main(String[] args)
//	{
//		
//	}

}
