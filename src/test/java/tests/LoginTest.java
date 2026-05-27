package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import utilities.ConfigReader;

public class LoginTest extends BaseTest
{
	@Test
	public void getURL()
	{	
		// Create LoginPage object
		LoginPage loginPage = new LoginPage(driver);

		// Create ConfigReader object
		ConfigReader configReader = new ConfigReader();
		
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
 