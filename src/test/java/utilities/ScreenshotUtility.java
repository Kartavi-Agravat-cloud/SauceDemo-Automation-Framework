package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//Utility class used for capturing screenshots
public class ScreenshotUtility 
{
    // Capture screenshot and store it in screenshots folder
	public String captureScreenshot(WebDriver driver, String screenshotName)
	{	
		// Convert WebDriver object to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
				
		// Store screenshot temporarily
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
				
		String destinationPath = "./src/test/resources/screenshots/" + screenshotName + ".png";
		
		// Define destination path for screenshot
		File destinationFile = new File(destinationPath);
		
		try 
		{
			// Copy screenshot to destination folder
			FileUtils.copyFile(sourceFile, destinationFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return destinationPath;
	}
}