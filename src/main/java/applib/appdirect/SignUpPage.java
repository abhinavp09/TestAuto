package applib.appdirect;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import corelib.Selenium;

public class SignUpPage implements ISignUpPage {

	Selenium selenium =null;

	/**
	 * Constructor for class
	 * @param selenium
	 */
//	public SignUpPage(Selenium selenium)
//	{
//		this.selenium = selenium;
//	}
	
	

	//Page elemetns section starts here
	
		public WebElement txtEmail()
		{
			return Selenium.getElement("emailAddress", "name");
		}
		
		public WebElement btnSignUp()
		{
			return Selenium.getElement("userSignupButton", "name");
		}
		
		public WebElement msgBlankEmailSignUp()
		{
			return Selenium.getElement("//input[@class='adb-text__full_width user-error']", "xpath");
		}
		
		public WebElement stcSignUp()
		{
			return Selenium.getElement("//h3[text()='Sign Up']", "xpath");
		}
		
		public WebElement stcEmail()
		{
			return Selenium.getElement("//label[text()='Email']", "xpath");
		}
		
		public WebElement stcAlreadyHaveAccount()
		{
			return Selenium.getElement("signupLoginLink", "id");
		}
		
		public WebElement stcPartnerWithUs()
		{
			return Selenium.getElement("partnerRegisterLink", "id");
		}
		
		public WebElement msgDuplicateSignupError()
		{
			return Selenium.getElement("//p[text()[contains(.,'already been registered')]]", "xpath");
		}
		
		public WebElement lnkLogin()
		{
			return Selenium.getElement("//p[@id='signupLoginLink']/a", "xpath");
		}
		
		public WebElement lnkSignUp()
		{
			return Selenium.getElement("//p[@id='partnerRegisterLink']/a", "xpath");
		}
		

		



		

		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Methods section starts here
		
		@Override
		public void enterEmail(String email) 
		{
			Selenium.setText(txtEmail(), email);
		}



		@Override
		public void clickOnSignUpButton() 
		{
			Selenium.click(btnSignUp());
		}


		
		@Override
		public boolean isBlankSignUpErrorPresent() 
		{
			WebElement element = null;
			element = msgBlankEmailSignUp();
			
			if(!(element.equals(null)))
			{
				return true; 
			}else
			{
				return false;
			}
		}



		@Override
		public HashMap<String, String> getPageStaticTextInHashMap() 
		{
			HashMap<String, String> hashMap = new HashMap<String, String>();
			
			hashMap.put("signup", Selenium.getText(stcSignUp()));
			hashMap.put("email", Selenium.getText(stcEmail()));
			hashMap.put("emailplaceholder", Selenium.getElementAttribute(txtEmail(), "placeholder"));
			hashMap.put("alreadyhaveaccount", Selenium.getText(stcAlreadyHaveAccount()));
			hashMap.put("partnerwithus", Selenium.getText(stcPartnerWithUs()));
			
			
			return hashMap;
		}



		@Override
		public String getDuplicateSignUpErrorMsg() 
		{
			String errorMsg = Selenium.getText(msgDuplicateSignupError());
			return errorMsg;
		}



		@Override
		public void clickOnLoginLink() 
		{
			Selenium.click(lnkLogin());
			
		}



		@Override
		public void clickOnSignUpLink() {
			Selenium.click(lnkSignUp());
			
		}
		
		



	

}



	
