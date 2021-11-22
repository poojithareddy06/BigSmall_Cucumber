package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.UI_0_Landingpage;
import UIStore.UI_1_LoginPage;
import UIStore.UI_2_CreateAccount;
import Utilities.ExtentReport;


public class P2_CreateAccount {
	WebDriver driver;
	ExtentReport er;
	
	public P2_CreateAccount(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonlogin(UI_0_Landingpage lploc) {
		lploc.getsignin().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void clickoncreateaccount(UI_1_LoginPage lploc) {
		lploc.createaccount().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void enterdetails()
	{
		er.startTest("Create Account");
		UI_2_CreateAccount sploc = new UI_2_CreateAccount(driver);
		sploc.getfirstname().sendKeys("Poojitha");
		sploc.getlastname().sendKeys("Reddy");
		sploc.getemail().sendKeys("xyz123@gmail.com");
		sploc.createpassword().sendKeys("xyz123");
		//sploc.getcreateaccount().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void getmessage()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='errors']")).getText());
	}
}
