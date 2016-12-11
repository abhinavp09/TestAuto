package applib.appdirect;

import org.openqa.selenium.WebElement;

import corelib.Selenium;

public class HomePage implements IHomePage
{

	Selenium selenium =null;

	/**
	 * Constructor for class
	 * @param selenium
	 */
//	public HomePage(Selenium selenium) mukesh
//	{
//		this.selenium = selenium;
//	}

	//Page elemetns section starts here
	private WebElement lnkLogIn()
	{
		return Selenium.getElement("//div[@id='newnav']//span[text()='Log In']", "xpath");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Methods section starts here
	@Override
	public void clickOnLoginLink() {
		
		Selenium.click(lnkLogIn());
	}



}
