package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelUtility;
import utilities.ScreenshotUtility;

//Test class for login functionality validation
public class LoginTest extends BaseTest
{
	@DataProvider(name = "loginData")
	public Object[][] getData()
	{
		ExcelUtility excelUtility = new ExcelUtility();
		return excelUtility.getLoginData("./src/test/resources/testdata/LoginData.xlsx", "Sheet1");
	}
	
	// Smoke test to verify successful login
	@Test (dataProvider = "loginData", groups = {"smoke"})
	public void getURL(String username, String password, String expectedResult)
	{	
		
		System.out.println("Username = " + username);
		System.out.println("Password = " + password);
		System.out.println("Expected Result = " + expectedResult);
		
		// Create LoginPage object
		LoginPage loginPage = new LoginPage(driver);
	
		// Create ScreenshotUtility object
		ScreenshotUtility screenshotUtility = new ScreenshotUtility();
		
		System.out.println("Username = " + username);
		System.out.println("Password = " + password);
		
		// Perform login using valid credentials
		loginPage.loginToApplication(username, password);
			
		// Capture screenshot after successful login
		screenshotUtility.captureScreenshot(driver, "LoginPage");
		
		String actualURL = driver.getCurrentUrl();

		if(expectedResult.equalsIgnoreCase("PASS"))
		{
		    String expectedURL = "https://www.saucedemo.com/inventory.html";

		    System.out.println("PASS Scenario");

		    Assert.assertEquals(actualURL, expectedURL);
		}
		else if(expectedResult.equalsIgnoreCase("FAIL"))
		{
		    String actualError = loginPage.getErrorMessage();

		    String expectedError = "Epic sadface: Sorry, this user has been locked out.";

		    System.out.println("FAIL Scenario");
		    System.out.println(actualError);

		    Assert.assertEquals(actualError, expectedError);
		}
		
	}
}
 