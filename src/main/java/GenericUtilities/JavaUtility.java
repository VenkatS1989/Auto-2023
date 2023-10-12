package GenericUtilities;

import java.util.Random;

/**
 * This class contains the Generic method for Java
 * @author user
 *
 */
public class JavaUtility 
{
/**
 * This method will generate the Random number for every run and send it to the caller
 * @return
 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int r = ran.nextInt(10000);
		return r;
	}
}
