package pom;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class newbikespom extends baseclass{

	WebDriver Driver;


	public newbikespom (WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		
	}
	//webelement
	
	@FindBy(xpath="//a[@href='/newbikes'][1]")
	WebElement newBikeshover_1;
	
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/span")
	WebElement upcomingbikes;
	
	@FindBy(id="makeId")
	WebElement honda;
	
	@FindBy(xpath= "//a[@data-track-label='model-name']")
	List<WebElement> bikename;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
	List<WebElement> bikenameprice;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> bikenamelaunch;
	
	@FindBy(xpath="//*[@class='zw-cmn-loadMore']")
	WebElement loadmore;
	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a/img")
	WebElement zigwheelback;
	
	
	
	public void usedcarhover() {
		Actions action=new Actions(driver);
		action.moveToElement(newBikeshover_1).perform();
	}
	public void upcomingbikes() {
		upcomingbikes.click();
	}
	public void manufacturehover() {
		Select act=new Select(honda);
		act.selectByVisibleText("Honda");
	}
	
	public List<WebElement>bikename () {
		return bikename;
	}
	public List<WebElement> bikenameprice() {
		return bikenameprice;
	}
	public List<WebElement> bikenamelaunch() {
		return bikenamelaunch ;
	} 
	public void loadmore() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loadmore);
		
	}
	public void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1250)" ," ");
	}

	
	public void zigwheelback() {
		
		
		zigwheelback.click();
	}


}




