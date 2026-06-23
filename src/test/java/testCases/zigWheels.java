package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseclass.driversetup;
import pom.loginpom;
import pom.newbikespom;
import pom.usedcarspom;
import utilities.ExcelUtilities;
import utilities.screenshot;

public class zigWheels extends driversetup {
	newbikespom bike;
	usedcarspom ucp; 
	loginpom lp;
	
	@Test(priority=1,groups= {"smoke","regression","master"})
	public void newbikes() throws Exception{

		newbikespom bike=new newbikespom(driver);
		screenshot.TakeScrShot(driver);
		
//Go to used cars		
		bike.usedcarhover();
//click upcoming bikes	
        bike.upcomingbikes();
		screenshot.TakeScrShot(driver);
//go to manufacture and click honda 
		
		bike.manufacturehover();
		
		
        Thread.sleep(3000);
		bike.loadmore();
	//print all the bikes below 4 lakh	
		List<WebElement> bknames=bike.bikename();
		List<WebElement> bkprices=bike.bikenameprice();
		List<WebElement> bklaunchdates=bike.bikenamelaunch();
		 int j=1;
		for(int i=0;i<bknames.size();i++) {
			String bkname=bknames.get(i).getText();
			String bkprice=bkprices.get(i).getText();
			String bklaunch=bklaunchdates.get(i).getText();
			
			if(bkprice.contains("Lakh")) {
				String[] price=bkprice.split(" ");
				float value=Float.parseFloat(price[1]);
				if(value<=4.0) {
					System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
					ExcelUtilities.write(j, 0, bkname);
					ExcelUtilities.write(j, 1,bkprice );
					ExcelUtilities.write(j, 2,bklaunch);
					j++;
				}
			}
			else {
				System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
			}
			
		}
		screenshot.TakeScrShot(driver);
		
//click zigwheels to navigate back		
		bike.zigwheelback();
		
	}
	
	@Test(priority=2,groups= {"smoke","regression","master"})
	public void usedcar() throws Exception{
	
		usedcarspom ucp = new usedcarspom (driver);
//Go to used cars
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a"))).perform();
	
		ucp=new usedcarspom(driver);
//click chennai		
		screenshot.TakeScrShot(driver);
		ucp.clickchennai();
//scroll down
		ucp.scrolll();
		screenshot.TakeScrShot(driver);
// go to popular model and print all the models
		ucp.popularcar();
		int j=1;
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li"));
		List<String> Bike = new ArrayList<String>();
		
		for (WebElement webElement : list) {
			String text=webElement.getText();
			Bike.add(text);
			
			ExcelUtilities.write(j++,3, text);
		}
		System.out.println(Bike);
		screenshot.TakeScrShot(driver);
	//navigate back to zigwheels
		ucp.zigwheelback();
	}
	
	@Test(priority=3,groups= {"smoke","regression","master"})
	public void login() throws Exception{
	 lp=new loginpom(driver);
//click on login		
	    Thread.sleep(2000);
	    screenshot.TakeScrShot(driver);
	    lp.login();
	    
		lp.google();
		//multiple windows
				List<String> allHandles = new ArrayList<String> (driver.getWindowHandles());
				String currentHandle = driver.getWindowHandle();
				for (String handle : allHandles) {
					if(!handle.equals(currentHandle)) {
						driver.switchTo().window(handle);
						break;
					}
				}
//click on email and print error message				
		lp.email();
		screenshot.TakeScrShot(driver);
		lp.errormsg();
		String errmsg =lp.errormsg();
		ExcelUtilities.write(1,4,errmsg );
		System.out.println("Error Captured Succesfully");
		screenshot.TakeScrShot(driver);
	}
	}

