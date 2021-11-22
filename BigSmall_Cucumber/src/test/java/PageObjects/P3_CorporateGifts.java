package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.UI_3_Corporategiftpage;
import UIStore.UI_0_Landingpage;
import Utilities.ExtentReport;

public class P3_CorporateGifts {
	WebDriver driver;
	ExtentReport er;
	
	public P3_CorporateGifts(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncorporategift(UI_0_Landingpage lploc) {
		er.startTest("Corporate Gifts");
		lploc.getcorporategift().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void enterdetails(UI_3_Corporategiftpage cgp)
	{
		cgp.getname().sendKeys("Xyz");
		cgp.getemail().sendKeys("xyz@gmail.com");
		cgp.getphone().sendKeys("1234567890");
		cgp.getmessage().sendKeys("Sharing the quantity, budget etc...");
		//cgp.getsubmit().click();
		er.endTest();
	}
	
	public void verification(UI_3_Corporategiftpage cgp) {
		System.out.println(cgp.getverification().getText());
	}
}
