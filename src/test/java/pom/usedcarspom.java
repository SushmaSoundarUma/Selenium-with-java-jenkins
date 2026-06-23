package pom;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class usedcarspom extends baseclass{

	public usedcarspom(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//webelement

	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
	WebElement clickchennai;
	
	
	@FindBy(xpath="//ul[@class=\\\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\\\"]/li")
	List<WebElement> popularcar;
	
	@FindBy(xpath="//img[@data-track-label='zw-header-logo']")
	WebElement zigwheelback;
	

	public void clickchennai() {
		clickchennai.click();
		
	}
	
	public void scrolll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)" ," ");
	}
	
	public  List<WebElement>  popularcar() {
		return popularcar;
	}
	public void zigwheelback() throws InterruptedException {
		zigwheelback.click();
		Thread.sleep(5000);
	}
	
	
	}




