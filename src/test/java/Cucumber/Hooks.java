package Cucumber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseclass.driversetup;
//import factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
 

public class Hooks {

		@BeforeAll

	   public static void setup() throws Exception

	   {
			
	   	driversetup.setup("1");

		}

		@AfterStep

	    public void addScreenshot(Scenario scenario) {

	    	// this is for cucumber junit report

	        	TakesScreenshot ts=(TakesScreenshot) driversetup.getDriver();

	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);

	        	scenario.attach(screenshot, "image/png",scenario.getName());

	    }
	 
	   @AfterAll

	   public static void tearDown() {

		   driversetup.getDriver().quit();

	   }

	}


