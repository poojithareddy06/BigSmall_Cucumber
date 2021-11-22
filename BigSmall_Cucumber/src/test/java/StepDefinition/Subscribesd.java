package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.P8_Subscribe;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_0_Landingpage;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Subscribesd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	UI_0_Landingpage lploc;
	String url = rp.getUrl();
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
	P8_Subscribe nl;
    @Given("^Open the URL in browser$")
    public void open_the_url_in_browser() {
    	driver = CreateAccountsd.getdriver();
		er = CreateAccountsd.getreport();
		driver.get(url);
		lploc = new UI_0_Landingpage(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I Enter the \"([^\"]*)\"$")
    public void i_enter_the_something(String emailid) {
    	nl = new P8_Subscribe(driver, er);
 		nl.subscribetonewsletter(lploc, emailid);
 		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Then("^Navigate and quit$")
    public void navigate_and_quit() {
    	log.info("Newletter Subscription Successful");
    	
    }
	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}
}
