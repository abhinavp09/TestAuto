package applib.common;

import applib.appdirect.IHomePage;
import applib.appdirect.ISignUpPage;
import applib.appdirect.ISignUpSuccessPage;
import applib.appdirect.ILoginPage;
import applib.appdirect.HomePage;
import applib.appdirect.SignUpPage;
import applib.appdirect.SignUpSuccessPage;
import applib.appdirect.LoginPage;

public class BasePage implements IBasePage
{
//	public Selenium selenium = null;
//	
//	/**
//	 * Constructor for class
//	 * @param selenium
//	 */
//	public BasePage(Selenium selenium)
//	{
//	}

	
	@Override
	public IHomePage homePage() {
		return new HomePage();
	}
	

	@Override
	public ILoginPage loginPage() {
		return new LoginPage();
	}
	
	
	@Override
	public ISignUpPage singUpPage() {
		return new SignUpPage();
	}


	@Override
	public ISignUpSuccessPage signUpSuccessPage() {
		return new SignUpSuccessPage();
	}


	
	
	
	
	
}
