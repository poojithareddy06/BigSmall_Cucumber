package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.P9_Aboutus;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_0_Landingpage;
import UIStore.UI_9_Aboutuspage;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Aboutussd {
	static WebDriver driver;
	static ReadProperty rp= new ReadProperty();
	WebDriverHelper helper = null;
	static ExtentReport er;
	private Logger log = LogManager.getLogger(RunnerTest.class.getName());
	UI_0_Landingpage lploc;
	String url=rp.getUrl();
	P9_Aboutus au;
	UI_9_Aboutuspage auloc;
	@Given("^Get the driver from the WishListSD file$")
    public void get_the_driver_from_the_wishlistsd_file() throws Throwable {
     
		driver = Personalizedsd.getdriver();
		er=Personalizedsd.getreport();
		driver.get(url);
		lploc=new UI_0_Landingpage(driver);
		helper = new WebDriverHelper(driver);
    }

    @Then("^Click on the About Us from he footer section$")
    public void click_on_the_about_us_from_he_footer_section() throws Throwable {
    	
    	au = new P9_Aboutus(driver,er);
    	auloc = new UI_9_Aboutuspage(driver);
    	log.info("Going to click on About us");
    	au.clickonaboutus(lploc);
    	log.info("clicked on about us");
    }

    @Then("^Validate whether About us is opened or not$")
    public void validate_whether_about_us_is_opened_or_not() throws Throwable {
        
    	driver=helper.changetonewdriver(driver);
    	au = new P9_Aboutus(driver,er);
    	auloc = new UI_9_Aboutuspage(driver);
    	au.getaboutustitle(auloc);
    	log.info("Title is verified");
    }
    
    public static WebDriver getDriver() {
    	return driver;
    }
    public static ExtentReport getreport() {
		return er;
	}



}
