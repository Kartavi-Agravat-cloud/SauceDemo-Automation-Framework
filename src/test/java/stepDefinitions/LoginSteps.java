package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;

public class LoginSteps
{
	LoginPage loginPage;
	ConfigReader configReader;
	
	@Given("User launches SauceDemo application")
	public void user_launches_sauce_demo_application()
	{
	    System.out.println("Application launched");
	    
	    loginPage = new LoginPage(utilities.DriverManager.getDriver());
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password)
	{
	    loginPage.loginToApplication(username, password);

	    System.out.println("Username = " + username);
	    System.out.println("Password = " + password);
	}

	@When("User clicks Login button")
	public void user_clicks_login_button()
	{
		System.out.println("Login button clicked");
	}

	@Then("User should see result {string}")
	public void user_should_see_result(String expectedResult)
	{
		String actualURL = DriverManager.getDriver().getCurrentUrl();
		
		if(expectedResult.equalsIgnoreCase("PASS"))
		{
			System.out.println("PASS Scenario");
			
			Assert.assertEquals(actualURL, "https://www.saucedemo.com/inventory.html");
		}
		else 
		{
			System.out.println("FAIL Scenario");
			
			Assert.assertNotEquals(actualURL, "https://www.saucedemo.com/inventory.html");
		}
	}
}