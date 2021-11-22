package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import UIStore.UI_0_Landingpage;
import UIStore.UI_5_Homelifestylepage;
import Utilities.ExtentReport;




public class P5_HomeLifeStyle {

	WebDriver driver;
	ExtentReport er;
	
	public P5_HomeLifeStyle(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonshopbycategory(UI_0_Landingpage lploc) {
		WebElement hls = lploc.gethomelifestyle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(hls).build().perform();
		er.startTest("Home & LifeStyle");
		lploc.gethomedecor().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}

	public void dropdown(UI_5_Homelifestylepage hlsloc) {
		er.startTest("Filter by new");
		hlsloc.getdropdownname().click();
		hlsloc.getdropdownname().sendKeys(Keys.DOWN);
		hlsloc.getdropdownname().sendKeys(Keys.ENTER);
		er.endTest();
	}
}
