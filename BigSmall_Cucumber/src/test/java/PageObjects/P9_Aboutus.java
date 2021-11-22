package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.UI_0_Landingpage;
import UIStore.UI_9_Aboutuspage;
import Utilities.ExtentReport;


public class P9_Aboutus {
	WebDriver driver;
	ExtentReport er;
	
	public P9_Aboutus(WebDriver driver,ExtentReport er)
	{
		this.driver=driver;
		this.er=er;
		PageFactory.initElements(driver,this);
	}
	
	public void clickonaboutus(UI_0_Landingpage lploc)
	{
		lploc.aboutus().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void getaboutustitle(UI_9_Aboutuspage aup)
	{
		er.startTest("About us Title");
		driver.getTitle();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		er.endTest();
		
	}

}
