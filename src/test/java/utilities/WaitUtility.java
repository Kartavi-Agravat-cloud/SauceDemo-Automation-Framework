package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	// WebDriver reference for wait operations
	WebDriver driver;
	
	// Constructor to initialize driver
	public WaitUtility(WebDriver driver)
	{
		this.driver = driver;
	}

	// Wait until element becomes visible
	public void waitForElementVisible(By element, int seconds)
	{
		// Create explicit wait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));	
		
		// Wait until element is visible on page
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}	
}
