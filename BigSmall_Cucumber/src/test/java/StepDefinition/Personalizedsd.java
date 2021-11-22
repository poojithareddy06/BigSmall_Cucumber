package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.P4_PersonalizedGifts;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_0_Landingpage;
import UIStore.UI_4_Personalizedgiftpage;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Personalizedsd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	UI_0_Landingpage lploc;
	String url = rp.getUrl();
	P4_PersonalizedGifts pg;
	UI_4_Personalizedgiftpage pgloc;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
	@Given("^The home page is open$")
	public void the_home_page_is_open() {
		driver = Corporategiftsd.getdriver();
		er = Corporategiftsd.getreport();
		driver.get(url);
		lploc = new UI_0_Landingpage(driver);
		helper = new WebDriverHelper(driver);
	}

	@When("^I click on Personalized gifts$")
	public void i_click_on_personalized_gifts() {
		pgloc = new UI_4_Personalizedgiftpage(driver);
		pg = new P4_PersonalizedGifts(driver, er);
		pg.clickonpersonalizedgift(lploc);
	}

	@Then("^Navigate to the page and select product$")
	public void navigate_to_the_page_and_select_product() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Personalized Gift page");
	}

	@And("^Customize the \"([^\"]*)\" to be printed$")
	public void customize_the_something_to_be_printed(String name) throws InterruptedException {
		pg.addproduct(pgloc, name);
		driver = helper.changetonewdriver(driver);
		pg.verify(pgloc);
		log.info("Customized the gifts and added to cart");
		driver.get(url);
	}

	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}
}
