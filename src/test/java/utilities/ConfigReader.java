package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
	// Properties object to read configuration values
	Properties properties = new Properties();
	
	public ConfigReader()
	{
		FileInputStream file;
		
		// Load configuration file
		try {
			file = new FileInputStream("src/test/resources/config.properties");
			properties.load(file);
		} catch (IOException  e) {
			// Print exception details if config file loading fails
			e.printStackTrace();
		}
	}
	
	// Return application URL from config file
	public String getUrl()
	{
		return properties.getProperty("url");
	}
	
	// Return application username from config file
	public String getUsername()
	{
		return properties.getProperty("username");
	}
	
	// Return application password from config file
	public String getPassword()
	{
		return properties.getProperty("password");
	}
	
	// Return application browser from config file
	public String getBrowser()
	{
		return properties.getProperty("browser");
	}
}
