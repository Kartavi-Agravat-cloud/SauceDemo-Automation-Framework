package tests;

import org.testng.annotations.Test;

//Sample test class used to verify suite execution
public class DummyTest
{ 
	// Regression test used for group execution practice
    @Test (groups = {"regression"})
    public void dummyExecution()
    {
    	// Print message to verify test execution from XML suite
        System.out.println("Dummy Test Executed");
    }
}