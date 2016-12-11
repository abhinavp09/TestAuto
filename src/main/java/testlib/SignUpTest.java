package testlib;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import applib.common.BasePage;
import corelib.Common;
import corelib.Config;
import corelib.GlobalSetup;
import corelib.Selenium;

public class SignUpTest {
	
	
	static BasePage basePage = null;
	SoftAssert softAssert = null;
	
	String validEmail = "";
	String inValidEmail = "";
	String partSuccessMsg="We have sent a verification email to ";

	@BeforeClass
	public void setUpBeforeClass() 
	{
		basePage = GlobalSetup.setUp();
		validEmail = Common.getRandomNumber()+"@abc.com";
		inValidEmail = Common.getRandomNumber();
		
	}
	
	
	@BeforeMethod
	public void setUpBeforeMethod()
	{
		softAssert = new SoftAssert();
		
		Selenium.loadUrl(Config.ProductUrl);
		basePage.homePage().clickOnLoginLink();
		basePage.loginPage().clickOnSignUpForAnAccountLink();
		
	}
	

	@Test(enabled = true, description="TestCaseID = Signup_01", priority=1)
	public void signUpWithValidEmail()
	{
		basePage.singUpPage().enterEmail(validEmail);
		basePage.singUpPage().clickOnSignUpButton();
		
		String actualSuccessMsg = partSuccessMsg+validEmail+".";
		String successMessageFromPage = basePage.signUpSuccessPage().getSignUpSuccessMsg(validEmail);
		
		Assert.assertEquals(actualSuccessMsg, successMessageFromPage, "Success Message do not matches");
			
	}
	
	
	@Test(enabled=true, description="TestCaseID = Signup_02", dependsOnMethods={"signUpWithValidEmail"}, priority=2)
	public void verifyDuplicateSignUp()
	{
		String actualError = "This email address has already been registered in our system. Please register with a new email address.";
		
		basePage.singUpPage().enterEmail(validEmail);
		basePage.singUpPage().clickOnSignUpButton();
		
		String errorMsgFromPage = basePage.singUpPage().getDuplicateSignUpErrorMsg();
		
		Assert.assertEquals(actualError, errorMsgFromPage, "Duplicate Signup Message do not matches");
	}
	
	
	
	@Test(enabled=true, description="TestCaseID = Signup_03", priority=3)
	public void pageStaticDetailVerification()
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap = basePage.singUpPage().getPageStaticTextInHashMap();
		
		softAssert.assertEquals("SIGN UP", hashMap.get("signup"));
		softAssert.assertEquals("Email", hashMap.get("email"));
		softAssert.assertEquals("email@address.com", hashMap.get("emailplaceholder"));
		softAssert.assertEquals("Already have an account? Log In.", hashMap.get("alreadyhaveaccount"));
		softAssert.assertEquals("Want to partner with us? Sign Up.", hashMap.get("partnerwithus"));
		
		softAssert.assertAll();
	}
	
	
	@Test(enabled=true, description="TestCaseID = Signup_04", priority=4)
	public void verifyLogInLinkOnSignUpPage()
	{
		basePage.singUpPage().clickOnLoginLink();
		Selenium.wait(10);
		String browserTitle = Selenium.getPageTitle();
		
		Assert.assertEquals("Log In | AppDirect", browserTitle, "Page Tile dose not matches");
		
	}
	
	
	@Test(enabled=true, description="TestCaseID = Signup_05", priority=5)
	public void verifySignUpLinkOnSignUpPage()
	{
		basePage.singUpPage().clickOnSignUpLink();
		Selenium.wait(10);
		String browserTitle = Selenium.getPageTitle();
		
		Assert.assertEquals("Register | AppDirect", browserTitle, "Page Tile dose not matches");
		
	}
	
	@Test (enabled=true, description="TestCaseID = Signup_06", priority=6)
	public void signUpWithInvalidEmailID()
	{
		basePage.singUpPage().enterEmail(inValidEmail);
		basePage.singUpPage().clickOnSignUpButton();
		
		boolean isBlankEmailSignUpErrorMsgPresent = basePage.singUpPage().isBlankSignUpErrorPresent();
		
		Assert.assertTrue(isBlankEmailSignUpErrorMsgPresent, "blank email sign up error msg not present");
	}
	
	@Test(enabled=true, description="TestCaseID = Signup_07", priority=7)
	public void signUpWithBlankEmailID()
	{
		basePage.singUpPage().enterEmail(inValidEmail);
		basePage.singUpPage().clickOnSignUpButton();
		
		boolean isBlankEmailSignUpErrorMsgPresent = basePage.singUpPage().isBlankSignUpErrorPresent();
		
		Assert.assertTrue(isBlankEmailSignUpErrorMsgPresent, "Invalid email sign up error msg not present");
	}
	
	
	@AfterClass(alwaysRun=true)
	public static void tearDownAfterClass() throws Exception 
	{
		Selenium.closeBrowser();
	}

}
