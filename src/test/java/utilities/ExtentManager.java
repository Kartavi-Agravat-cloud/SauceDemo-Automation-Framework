package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Utility class used for Extent Report configuration
public class ExtentManager 
{
	// Create and return configured ExtentReports object
	public static ExtentReports getReportObject()
	{
		// Define report file location
		ExtentSparkReporter reporter = new ExtentSparkReporter("./test-output/ExtentReport.html");
		
		// Set Report name
		reporter.config().setReportName("SauceDemo Automation Report");
		
		// Set Document title
		reporter.config().setDocumentTitle("Automation Test Results");
		
		// Create ExtentReports object
		ExtentReports extent = new ExtentReports();
		
		// Attach reporter
		extent.attachReporter(reporter);
		
		// Return configured report object
		return extent;
	}
}
