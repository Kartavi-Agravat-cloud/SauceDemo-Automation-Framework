package utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager
{
	private static WebDriver driver;

	public static void setDriver(WebDriver driver)
	{
		DriverManager.driver = driver;
	}

	public static WebDriver getDriver()
	{
		return driver;
	}
}