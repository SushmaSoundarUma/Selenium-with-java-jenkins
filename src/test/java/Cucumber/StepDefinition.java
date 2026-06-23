package Cucumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseclass.driversetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.loginpom;
import pom.newbikespom;
import pom.usedcarspom;
import testCases.zigWheels;
import utilities.ExcelUtilities;

public class StepDefinition {
	driversetup ds=new driversetup();
	zigWheels zw=new zigWheels();
	
	@Given("Open {string} browser and zigwheels website")
	public void open_browser_and_zigwheels_website(String Browser) throws InterruptedException {

			String actTitle = driversetup.getDriver().getTitle();
			if (actTitle.equals("New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com")) {
				System.out.println("Correct Website is Launched");
			} else {
				System.out.println("Incorrect Website is Launched");
				System.exit(0);
			}
	  
	}

	@Then("Go to new Bikes")
	public void go_to_new_bikes() {
		newbikespom bikes=new newbikespom(driversetup.getDriver());
		bikes.usedcarhover();

	}

	@Then("Click on Upcoming bikes")
	public void click_on_upcoming_bikes() {
		newbikespom bikes=new newbikespom(driversetup.getDriver());
		bikes.upcomingbikes();
	}

	@Then("Go to Manufacture and Click on Honda")
	public void go_to_manufacture_and_click_on_honda() {
		newbikespom bikes=new newbikespom(driversetup.getDriver());
		bikes.manufacturehover();
		bikes.loadmore();
	}

	@Then("Get all the bikes below {int} Lakh")
	public void get_all_the_bikes_below_lakh(Integer int1) throws IOException {
		newbikespom bikes=new newbikespom(driversetup.getDriver());
		List<WebElement> bknames=bikes.bikename();
		List<WebElement> bkprices=bikes.bikenameprice();
		List<WebElement> bklaunchdates=bikes.bikenamelaunch();
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
		bikes.zigwheelback();
		}
	    
	@Given("Go to Used cars and click Chennai")
	public void go_to_used_cars_and_click_chennai() {
		usedcarspom us =new usedcarspom(driversetup.getDriver());
		us=new usedcarspom(driversetup.getDriver());
		//bikes.usedcarhover();

		Actions action=new Actions(driversetup.getDriver());
		action.moveToElement(driversetup.getDriver().findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a"))).perform();
	
	    us.clickchennai();
	}

	@Then("Go to Popular model")
	public void go_to_popular_model() {
		usedcarspom us =new usedcarspom(driversetup.getDriver());
		us.scrolll();
		us.popularcar();
	}

	@Then("Get all Popular cars")
	public void get_all_popular_cars() throws InterruptedException {
		usedcarspom us =new usedcarspom(driversetup.getDriver());
		
		List<WebElement> list = driversetup.getDriver().findElements(By.xpath("//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li"));
		List<String> Bike = new ArrayList<String>();
		
		for (WebElement webElement : list) {
			String text=webElement.getText();
			Bike.add(text);
			
		
		}
		System.out.println(Bike);

		us.zigwheelback();
	}

	@Given("Click on login")
	public void click_on_login() {
		loginpom lp=new loginpom(driversetup.getDriver());
        lp.login();
	    
	}

	@Then("click google")
	public void click_google() {
		loginpom lp=new loginpom(driversetup.getDriver());
		lp.google();
	    
	}

	@Then("Type any email id")
	public void type_any_email_id() {
		loginpom lp=new loginpom(driversetup.getDriver());
		List<String> allHandles = new ArrayList<String> (driversetup.getDriver().getWindowHandles());
		String currentHandle = driversetup.getDriver().getWindowHandle();
		for (String handle : allHandles) {
			if(!handle.equals(currentHandle)) {
				driversetup.getDriver().switchTo().window(handle);
				break;
			}
		}
lp.email();
lp.errormsg();
	    
	}
  @Then ("close browser")
	public void close() {
	  driversetup.getDriver().quit();
             System.out.println("Browser Closed Successfully");
}

	
}
