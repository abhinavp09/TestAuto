package corelib;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Config 
{
	
	public static String ProductUrl="";
	public static String Browser="";
	
	/**
	 * Method to load all variables in property file before test
	 */
	public static void loadPropertiesfile()
	{	
		try {
			File propertyfile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Automation.properties");
			FileReader filereader = new FileReader(propertyfile);
			
			
			Properties prop = new Properties();
			prop.load(filereader);
			
			ProductUrl = prop.getProperty("ProductUrl");
			Browser 		= prop.getProperty("Browser");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
