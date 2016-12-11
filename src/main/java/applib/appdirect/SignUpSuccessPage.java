package applib.appdirect;

import org.openqa.selenium.WebElement;

import corelib.Selenium;

public class SignUpSuccessPage implements ISignUpSuccessPage{
	
	Selenium selenium =null;

	/**
	 * Constructor for class
	 * @param selenium
	 */
//	public SignUpSuccessPage(Selenium selenium)
//	{
//		this.selenium = selenium;
//	}
	
	//Page elemetns section starts here
	
	private WebElement msgRegistrationSuccess(String email)
	{
		return Selenium.getElement("//p[text()[contains(.,'"+email+"')]]", "xpath");
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Methods section starts here
	
	@Override
	public String getSignUpSuccessMsg(String email) 
	{
		String message = Selenium.getText(msgRegistrationSuccess(email));
		return message;
	}
	

}
