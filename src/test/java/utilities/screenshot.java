package utilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	public static void TakeScrShot(WebDriver driver) throws Exception {
	TakesScreenshot scrshot = (TakesScreenshot) driver;
	// Get the current timestamp
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	String timestamp = dateFormat.format(new Date());

	// Create a unique filename using the timestamp
	String target = System.getProperty("user.dir") + "/Reports/ScreenShot/";
	String filename = target + "screenshot_" + timestamp + ".png";

	File src = scrshot.getScreenshotAs(OutputType.FILE);
	File trg = new File(filename);
	FileUtils.copyFile(src, trg);
	System.out.println("ScreenShot Captured Successfully");
	}
}



