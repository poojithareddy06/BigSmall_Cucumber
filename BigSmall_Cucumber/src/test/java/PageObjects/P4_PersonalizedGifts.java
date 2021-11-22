package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.UI_0_Landingpage;
import UIStore.UI_4_Personalizedgiftpage;
import Utilities.ExtentReport;


public class P4_PersonalizedGifts {
	WebDriver driver;
	ExtentReport er;
	
	public P4_PersonalizedGifts(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonpersonalizedgift(UI_0_Landingpage lploc) {
		lploc.getpersonalizedgift().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void addproduct(UI_4_Personalizedgiftpage pploc, String name) {
		er.startTest("Personalized Gifts");
		pploc.prproduct().click();
		pploc.entername().sendKeys(name);
		pploc.addtocart().click();
		er.endTest();
	}
	public void verify(UI_4_Personalizedgiftpage pploc) {
		//System.out.println("To Verify: "+pploc.getverification().getText());
	}
}
