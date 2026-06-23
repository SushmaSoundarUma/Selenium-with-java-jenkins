package pom;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpom extends baseclass {
	
public loginpom(WebDriver driver) {
	super(driver);
	// TODO Auto-generated constructor stub
}
@FindBy(id="des_lIcon")
WebElement login;


@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
WebElement google;

@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
WebElement email;
//'o6cuMc Jj6Lae'

@FindBy(xpath="//div[@class='Ekjuhf Jj6Lae']")
WebElement errormsg;

public void login() {
	 login.click();
}
	
	public void google() {
		google.click();
		}
	public void email() {
		email.sendKeys("sush@gmail.com");
		email.sendKeys(Keys.ENTER);
		}
	public String  errormsg() {
		String Error = errormsg.getText();
		System.out.println(Error);
		return Error;
	}

}
