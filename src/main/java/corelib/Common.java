package corelib;

import java.util.UUID;

public class Common 
{
	
	/**
	 * method to get random number
	 * @return
	 */
	public static String getRandomNumber() 
	{
		return UUID.randomUUID().toString();
	}

}
