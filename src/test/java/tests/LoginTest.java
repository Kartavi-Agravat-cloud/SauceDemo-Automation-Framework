package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
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
		// Create LoginPage object
		LoginPage loginPage = new LoginPage(driver);
	
		// Create ScreenshotUtility object
		ScreenshotUtility screenshotUtility = new ScreenshotUtility();
		
		// Perform login using valid credentials
		loginPage.loginToApplication(username, password);
			
		// Capture screenshot after successful login
		screenshotUtility.captureScreenshot(driver, "LoginPage");
		
		String actualURL = driver.getCurrentUrl();

		if(expectedResult.equalsIgnoreCase("PASS"))
		{
		    Assert.assertEquals(actualURL, "https://www.saucedemo.com/inventory.html");
		}
		else if(expectedResult.equalsIgnoreCase("FAIL"))
		{
		    String actualError = loginPage.getErrorMessage();
		    Assert.assertEquals(actualError, "Epic sadface: Sorry, this user has been locked out.");
		}
	}
}
 