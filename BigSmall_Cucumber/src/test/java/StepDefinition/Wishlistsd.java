package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.P6_Wishlist;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_0_Landingpage;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Wishlistsd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	UI_0_Landingpage lploc;
	String url = rp.getUrl();
	P6_Wishlist wl;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
    @Given("^Open the URL$")
    public void open_the_url() {
    	driver = Personalizedsd.getdriver();
		er = Personalizedsd.getreport();
		driver.get(url);
		lploc = new UI_0_Landingpage(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on click on Wish List$")
    public void i_click_on_click_on_wish_list() {
    	wl = new P6_Wishlist(driver, er);
		wl.clickonwishlist(lploc);
    }

    @Then("^Navigate to the page and display$")
    public void navigate_to_the_page_and_display() throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		log.info("Wish List - Successful");
    }
	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}
}
