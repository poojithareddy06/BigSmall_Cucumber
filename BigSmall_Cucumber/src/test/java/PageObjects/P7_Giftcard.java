package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.UI_7_Giftcardpage;
import UIStore.UI_0_Landingpage;
import Utilities.ExtentReport;

public class P7_Giftcard {
	WebDriver driver;
	ExtentReport er;
	
	public P7_Giftcard(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickongiftcard(UI_0_Landingpage lploc) {
		lploc.getgiftcard().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void addtowishlist(UI_7_Giftcardpage gcploc)
	{
		gcploc.addtowishlists().click();
		er.startTest("Product adding to Wishlist");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void checkCOD(UI_7_Giftcardpage gcploc)
	{
		er.startTest("Gift Card");
		gcploc.getpin().sendKeys("500055");
		gcploc.checkpin().click();
		er.endTest();
	}
	
	public void addtocart(UI_7_Giftcardpage gcploc)
	{
		gcploc.getaddtocart().click();
	}
	
	public void getAvailability(UI_7_Giftcardpage gcploc)
	{
		System.out.println(gcploc.getavailability().getText());
	}
	
}
