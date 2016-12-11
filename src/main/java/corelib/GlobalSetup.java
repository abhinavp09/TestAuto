package corelib;

import applib.common.BasePage;

public class GlobalSetup 
{
	static BasePage basePage = null;
	
	/**
	 * Method to make all setup ready before test run
	 * @return BasePage Object
	 */
	public static BasePage setUp()
	{
		Config.loadPropertiesfile();
		Selenium.setBrowser(Config.Browser);
		basePage = new BasePage();
		return basePage;
	}

}
