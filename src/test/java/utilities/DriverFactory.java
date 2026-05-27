package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory 
{
	// Initialize browser driver based on browser name
	public WebDriver initializeWebDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			// Launch Chrome browser
			return new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			// Launch Firefox browser
			return new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			// Launch Edge browser
			return new EdgeDriver();
		}
		else
		{
			return null;
		}
	}
}