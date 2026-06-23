package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ScreenshotUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//Listener class used to capture TestNG events and update Extent Reports
public class Listeners implements ITestListener
{
	// ExtentReports instance for report generation
	ExtentReports extent = ExtentManager.getReportObject();
	
	// ExtentTest instance for logging test execution details
	ExtentTest test;
	
	// Create test entry in Extent Report when test execution starts
	@Override
	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
	}

	// Log successful test execution in Extent Report
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.pass("Test Passed");
	}

	// Log failed test execution in Extent Report
	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());

	    try
	    {
	        System.out.println("FAILURE LISTENER STARTED");

	        WebDriver driver =
	                (WebDriver) result.getTestClass()
	                                  .getRealClass()
	                                  .getField("driver")
	                                  .get(result.getInstance());

	        System.out.println("Driver from Listener = " + driver);

	        ScreenshotUtility screenshotUtility =
	                new ScreenshotUtility();

	        String screenshotPath =
	                screenshotUtility.captureScreenshot(
	                        driver,
	                        result.getMethod().getMethodName());

	        System.out.println("Screenshot Path = " + screenshotPath);

	        test.addScreenCaptureFromPath(screenshotPath);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
	
	}

	@Override
	public void onStart(ITestContext context) 
	{
	
	}

	// Write all execution details to Extent Report
	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
