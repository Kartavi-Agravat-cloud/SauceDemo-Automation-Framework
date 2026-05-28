package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ScreenshotUtility;

public class LoginTest extends BaseTest
{
	@Test
	public void getURL()
	{	
		// Create LoginPage object
		LoginPage loginPage = new LoginPage(driver);

		// Create ConfigReader object
		ConfigReader configReader = new ConfigReader();
		
		// Create ScreenshotUtility object
		ScreenshotUtility screenshotUtility = new ScreenshotUtility();

		// Capture screenshot after login
		screenshotUtility.captureScreenshot(driver, "LoginPage");
		
		// Perform login using valid credentials
		loginPage.loginToApplication(configReader.getUsername(), configReader.getPassword());
	
		// Store expected URL after successful login
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		
		// Capture actual URL after login
		String actualURL = driver.getCurrentUrl();
		
		// Print expected and actual URL in console
		System.out.println("Expected URL : " + expectedURL);
		System.out.println("Actual URL : " + actualURL);
		
		// Validate successful navigation to inventory page
		Assert.assertEquals(actualURL, expectedURL);
	}
}
 