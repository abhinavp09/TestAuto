package applib.appdirect;

import java.util.HashMap;

public interface ISignUpPage {
	
	public void enterEmail(String email);
	public void clickOnSignUpButton();
	public boolean isBlankSignUpErrorPresent();
	public HashMap<String, String> getPageStaticTextInHashMap();
	public String getDuplicateSignUpErrorMsg();
	public void clickOnLoginLink();
	public void clickOnSignUpLink();
	

}
