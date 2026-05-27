package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseTest 
{
	// WebDriver reference used across framework
	protected WebDriver driver;
	
	// ConfigReader object to fetch configuration values
	ConfigReader configReader = new ConfigReader();
	
	// DriverFactory object to initialize browser
	DriverFactory driverFactory = new DriverFactory();
	
	@BeforeMethod 
	public void setUp()
	{
		// Launch Chrome browser
		driver = driverFactory.initializeWebDriver(configReader.getBrowser());
		
		// Open application URL from config file
		driver.get(configReader.getUrl());
		
		// Maximize browser window
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown()
	{
		// Close complete browser session
		driver.quit();
	}
}
