package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.P2_CreateAccount;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_0_Landingpage;
import UIStore.UI_1_LoginPage;
import UIStore.UI_2_CreateAccount;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CreateAccountsd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	UI_0_Landingpage lploc;
	String url = rp.getUrl();
	P2_CreateAccount ca;
	UI_2_CreateAccount suloc;
	UI_1_LoginPage loginpageloc;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
    @Given("^Fetch the driver and open home page$")
    public void fetch_the_driver_and_open_home_page() {
    	driver = Loginsd.getdriver();
		er = Loginsd.getreport();
		driver.get(url);
		lploc = new UI_0_Landingpage(driver);
		helper = new WebDriverHelper(driver);
    }

    @When("^I click on click on Sign in$")
    public void i_click_on_click_on_sign_in() {
    	loginpageloc = new UI_1_LoginPage(driver);
    	ca = new P2_CreateAccount(driver, er);
		driver.get(url);
		ca.clickonlogin(lploc);
    }

    @Then("^Navigate to the respective page and click on create account$")
    public void navigate_to_the_respective_page_and_click_on_create_account() throws InterruptedException {
		driver = helper.changetonewdriver(driver);
		ca.clickoncreateaccount(loginpageloc);
		driver = helper.changetonewdriver(driver);
		log.info("Create Account - Successful");
    }

    @And("^Enter credentials$")
    public void enter_credentials() {
    	ca.enterdetails();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
    }

	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}
}
