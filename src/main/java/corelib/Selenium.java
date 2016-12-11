package corelib;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.lf5.LogLevel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium 
{
	public static WebDriver  webDriver = null;
	public static final int timeout = 20;
	
	/**
	 * Method to set the browser before test run
	 * @param browser
	 */
	public static void setBrowser(String browser)
	{
		webDriver = null;
		switch (browser.toLowerCase()) 
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", 
						System.getProperty("user.dir")+"\\src\\main\\resources\\"+"chromedriver.exe");
				webDriver = new ChromeDriver();
				break;
				
			case "firefox":
				webDriver = new FirefoxDriver();
				break;
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
	}
	
	/**
	 * Method to close the browser and quit the selenium webdriver 
	 */
	public static void closeBrowser()
	{
		webDriver.close();
		webDriver.quit();
	}
	
	/**
	 * Methos to find elements on web page by differenet means
	 * @param elementIdentifier
	 * @param findBy
	 * @return
	 */
	public static WebElement getElement(String elementIdentifier, String findBy) {
		Log.Message("Finding element by identifier " + elementIdentifier
				+ " using " + findBy.toString(), LogLevel.INFO);
		WebElement element = null;
		
		switch (findBy.toLowerCase()) {
		case "name":
			element = webDriver
					.findElement(By.name(elementIdentifier));
			break;
		case "id":
			element = webDriver.findElement(By.id(elementIdentifier));
			break;
		case "xpath":
			try {
				element = webDriver.findElement(By
						.xpath(elementIdentifier));
			} catch (InvalidSelectorException e) {
				webDriver.navigate().refresh();
				wait(10);
				element = webDriver.findElement(By
						.xpath(elementIdentifier));
			}
			break;
		case "linktext":
			element = webDriver.findElement(By
					.linkText(elementIdentifier));
			break;
		case "cssselector":
			element = webDriver.findElement(By
					.cssSelector(elementIdentifier));
			break;
		case "tagname":
			element = webDriver.findElement(By
					.tagName(elementIdentifier));
			break;
		case "classname":
			element = webDriver.findElement(By
					.className(elementIdentifier));
			break;
		}
		return element;
	}
	

	
	/**
	 * method to click on element on page
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForElementToBeVisible(element);
		Log.Message("Clicking on element: " + element, LogLevel.INFO);
		element.click();
	}
	
	
	/**
	 * Method to set text to a text box
	 * @param text
	 */
	public static void setText(WebElement element, String text) {
		waitForElementToBeVisible(element);
		element.clear();
		Log.Message("Setting the text area with string: " + text, LogLevel.INFO);
		element.sendKeys(text);
	}
	
	
	/**
	 * Method to wait for element to load on page and become visible
	 * @param elementIdentifier
	 * @param findBy
	 */
	public static void waitForElementToBeVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(webDriver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Method to load url on browser
	 * @param url
	 */
	public static void loadUrl(String url)
	{
		webDriver.get(url);
	}
	
	
	public static String getText(WebElement element) {
		String result = "";
		Log.Message("Getting the text value...", LogLevel.INFO);
		waitForElementToBeVisible(element);
		result = element.getText();
		Log.Message("The text value is:" + result.toString(), LogLevel.INFO);
		return result;
	}
	
	
	/**
	 * method to wait for specific seconds
	 * @param i
	 */
	public static void wait(int i) {
		Log.Message("Waiting for time: " + i + " seconds ", LogLevel.INFO);
		try {
			java.util.concurrent.TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			Log.Message(e.getMessage(), LogLevel.ERROR);
		}
	}
	
	
	
	
	public static String getElementAttribute(WebElement element, String attributeName) {
		String attributeValue = element.getAttribute(attributeName);
		return attributeValue;
	}
	
	/**
	 * Returns the page title
	 * 
	 * @return
	 */
	public static String getPageTitle() {
		String pageTitle = webDriver.getTitle();
		Log.Message("Page title is :[" + pageTitle + "]", LogLevel.INFO);
		return pageTitle;
	}
	
	
	
}
