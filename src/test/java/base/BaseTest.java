package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.DriverManager;

//Common setup and tear down methods for all test classes
public class BaseTest 
{
	// WebDriver reference used across framework
	public WebDriver driver;
	
	// ConfigReader object to fetch configuration values
	ConfigReader configReader = new ConfigReader();
	
	// DriverFactory object to initialize browser
	DriverFactory driverFactory = new DriverFactory();
	
	@BeforeMethod(alwaysRun = true) 
	@Parameters ("browser")
	public void setUp(String browser)
	{	
		System.out.println("Browser = " + browser);
		
		// Launch Chrome browser
		driver = driverFactory.initializeWebDriver(browser);
		
		DriverManager.setDriver(driver);
	
		System.out.println("Driver = " + driver);
		
		// Open application URL from config file
		driver.get(configReader.getUrl());
		
		// Maximize browser window
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		// Close complete browser session
		DriverManager.getDriver().quit();
		DriverManager.unload();
	}
}
