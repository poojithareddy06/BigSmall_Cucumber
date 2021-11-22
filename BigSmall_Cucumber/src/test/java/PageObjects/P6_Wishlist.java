package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import UIStore.UI_0_Landingpage;
import Utilities.ExtentReport;


public class P6_Wishlist {
	WebDriver driver;
	ExtentReport er;
	
	
	public P6_Wishlist(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	public void clickonwishlist(UI_0_Landingpage lploc)
	{
		er.startTest("Wish List");
		lploc.getwishlist().click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		er.endTest();
	}
	
}
