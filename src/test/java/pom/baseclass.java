package pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class baseclass {
	WebDriver driver;
	public baseclass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

}
