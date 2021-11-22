package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.UI_0_Landingpage;
import UIStore.UI_1_LoginPage;
import Utilities.ExtentReport;


public class P1_Login {
	WebDriver driver;
	ExtentReport er;
	
	public P1_Login(WebDriver driver, ExtentReport er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonlogin(UI_0_Landingpage lploc) {
		lploc.getsignin().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
		
	public void entercorrectdetails(UI_1_LoginPage lploc, String email, String pwd)
	{
		er.startTest("Login");
		lploc.email().sendKeys(email);
		lploc.password().sendKeys(pwd);
		//lploc.getloginsubmit().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void forgotpassword(UI_1_LoginPage lploc)
	{
		lploc.forgot().click();
	}
	
	public void requestpassword(UI_1_LoginPage lploc) throws InterruptedException
	{
		er.startTest("Rest Password");
		lploc.recoveryemail().sendKeys("poojithareddy1199@gmail.com");
		lploc.forgotpwdsubmit().click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='errors']")).getText());
		er.endTest();
	}
	
	public void getmessage()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='errors']")).getText());
	}
}
