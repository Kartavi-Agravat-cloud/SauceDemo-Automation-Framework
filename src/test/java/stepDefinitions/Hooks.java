package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.DriverManager;

public class Hooks
{
	WebDriver driver;

	@Before
	public void setUp()
	{
		System.out.println("BDD Before Hook Executed");
		
		ConfigReader configReader = new ConfigReader();
		
		driver = new DriverFactory().initializeWebDriver("chrome");

		driver.get(configReader.getUrl());

		driver.manage().window().maximize();

		DriverManager.setDriver(driver);
	}

	@After
	public void tearDown()
	{
		DriverManager.getDriver().quit();
	}
}