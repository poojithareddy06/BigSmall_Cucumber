package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import PageObjects.P0_Search;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
public class Searchproductsd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	P0_Search search;
	String path;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
	@Given("^The Website is open fetch driver$")
	public void the_website_is_open_fetch_driver() {
		driver = Personalizedsd.getdriver();
		er = Personalizedsd.getreport();
		helper = new WebDriverHelper(driver);
	}

	@When("^Search box locator is found$")
	public void search_box_locator_is_found() throws Throwable {
		path = System.getProperty("user.dir") + rp.pathsheet();
		search = new P0_Search(driver);
		
	}

	@Then("^Search products mentioned in excel$")
	public void search_products_mentioned_in_excel() throws Throwable {
		search.getproducts(path);
		search.searchforproducts(er);
		log.info("Product Search Successful");
		driver.quit();
	}
	
	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}

}
