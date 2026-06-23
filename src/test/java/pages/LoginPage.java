package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtility;

public class LoginPage 
{
	// WebDriver reference for page actions
	WebDriver driver;
	
	// WaitUtility object for explicit waits
	WaitUtility waitUtility;
	
	// Locators for login page elements
	By userName = By.id("user-name");
	By password = By.id("password");
	By login = By.id("login-button");
	
	// Error message displayed after failed login
	By errorMessage = By.xpath("//h3[@data-test='error']");
	
	// Constructor to initialize driver and utility objects
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		// Initialize explicit wait utility
		waitUtility = new WaitUtility(driver);
	}
	
	// Enter username into username field
	public void enterUsername(String usernameValue)
	{
		// Wait until username field is visible
		waitUtility.waitForElementVisible(userName, 10);
		
		driver.findElement(userName).sendKeys(usernameValue);
	}
	
	// Enter password into password field
	public void enterPassword(String passwordValue)
	{
		// Wait until password field is visible
		waitUtility.waitForElementVisible(password, 10);
		
		driver.findElement(password).sendKeys(passwordValue);
	}
	
	// Click on login button
	public void clickLogin()
	{
		// Wait until login button is visible
		waitUtility.waitForElementVisible(login, 10);
		driver.findElement(login).click();
	}
	
	// Perform complete login action
	public void loginToApplication(String userNameValue, String passwordValue)
	{
	    enterUsername(userNameValue);
	    enterPassword(passwordValue);
	    clickLogin();
	}
	
	// Get login error message
	public String getErrorMessage()
	{
	    waitUtility.waitForElementVisible(errorMessage, 10);

	    return driver.findElement(errorMessage).getText();
	}
}
