package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.P3_CorporateGifts;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_3_Corporategiftpage;
import UIStore.UI_0_Landingpage;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Corporategiftsd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
	UI_0_Landingpage lploc;
	String url = rp.getUrl();
	P3_CorporateGifts cg;
	UI_3_Corporategiftpage cgloc;
	@Given("^The landing page is open$")
    public void the_landing_page_is_open() {
		driver=CreateAccountsd.getdriver();
		er=CreateAccountsd.getreport();
		driver.get(url);
		lploc = new UI_0_Landingpage(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on Corporate Gift$")
    public void i_click_on_corporate_gift() {
    	cg = new P3_CorporateGifts(driver, er);
		cgloc = new UI_3_Corporategiftpage(driver);
		cg.clickoncorporategift(lploc);
		
    }

    @Then("^Navigate to details page$")
    public void navigate_to_details_page() throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		log.info("Corporate Gift Enquiry Successful");
    }

    @And("^Take user input$")
    public void take_user_input() {
    	cg.enterdetails(cgloc);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    

	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}

}
