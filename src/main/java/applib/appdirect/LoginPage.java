package applib.appdirect;

import org.openqa.selenium.WebElement;

import corelib.Selenium;

public class LoginPage implements ILoginPage{


	Selenium selenium =null;

	/**
	 * Constructor for class
	 * @param selenium
	 */
//	public LoginPage(Selenium selenium)
//	{
//		this.selenium = selenium;
//	}
	
	//Page elemetns section starts here
	private WebElement lnkSignUpForNewAccount()
	{
		return Selenium.getElement("//a[text()='Sign up for an account']", "xpath");
	} 



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Methods section starts here
	@Override
	public void clickOnSignUpForAnAccountLink() 
	{
		Selenium.click(lnkSignUpForNewAccount());
	}

}
