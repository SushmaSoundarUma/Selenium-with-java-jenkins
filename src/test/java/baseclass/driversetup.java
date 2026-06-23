package baseclass;

import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class driversetup {

	public static WebDriver driver;

	@Parameters({"browser"})
	@BeforeClass(groups = { "smoke", "regression", "master" })
	public static void setup(String string) throws InterruptedException, Exception {

//		Scanner us = new Scanner(System.in);
//	 	String Browser=us.nextLine();
//		String Browser = "1";

	/*switch (string) {

		case "1":

			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("--disable-notifications");
			options1.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options1);
			break;

		case "2":

			EdgeOptions options2 = new EdgeOptions();

			options2.addArguments("--disable-notifications");

			options2.addArguments("--disable-popup-blocking");

			driver = new EdgeDriver(options2);

			break;

		}*/
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN11);
		capabilities.setBrowserName("MicrosoftEdge");
		driver = new RemoteWebDriver(new URL("http://10.229.38.62:4444"), capabilities);

		// Browser window and page wait.
		// maximize the window

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.get("http://www.zigwheels.com");
		Thread.sleep(2000);

	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterClass(groups = { "smoke", "regression", "master" })
//close all the browser
	public  void close() {
		driver.quit();
		System.out.println("Browser Closed Successfully");
	}

}
