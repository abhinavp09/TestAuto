package applib.common;

import applib.appdirect.IHomePage;
import applib.appdirect.ISignUpPage;
import applib.appdirect.ISignUpSuccessPage;
import applib.appdirect.ILoginPage;


public interface IBasePage 
{
	//Web Pages
	IHomePage homePage();
	ILoginPage loginPage();
	ISignUpPage singUpPage();
	ISignUpSuccessPage signUpSuccessPage();
}
