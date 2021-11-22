package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.P7_Giftcard;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_7_Giftcardpage;
import UIStore.UI_0_Landingpage;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Giftcardsd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	UI_0_Landingpage lploc;
	UI_7_Giftcardpage gcploc;
	P7_Giftcard gc;
	String url = rp.getUrl();
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
    @Given("^Browser and url is open$")
    public void browser_and_url_is_open() {
    	driver = Personalizedsd.getdriver();
		er = Personalizedsd.getreport();
		driver.get(url);
		lploc = new UI_0_Landingpage(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on click on Gift card$")
    public void i_click_on_click_on_gift_card() {
    	gcploc = new UI_7_Giftcardpage(driver);
		gc = new P7_Giftcard(driver, er);
		gc.clickongiftcard(lploc);
    }

    @Then("^Navigate to the page and check COD$")
    public void navigate_to_the_page_and_check_cod() throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		gc.checkCOD(gcploc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		gc.getAvailability(gcploc);
		log.info("Cash On Delivery - Successful");
    }

    @And("^Add to Wishlist$")
    public void add_to_wishlist() {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gc.addtowishlist(gcploc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Add to Wishlist - Succesful");
		
    }
	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}
}
