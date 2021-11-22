package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.P1_Login;
import ReusableComponents.WebDriverHelper;
import Runner.RunnerTest;
import UIStore.UI_0_Landingpage;
import UIStore.UI_1_LoginPage;
import Utilities.ExtentReport;
import Utilities.ReadProperty;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Loginsd {
	static ReadProperty rp = new ReadProperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	static ExtentReport er;
	UI_0_Landingpage lploc;
	String url = rp.getUrl();
	UI_1_LoginPage loginloc;
	private static Logger log = LogManager.getLogger(RunnerTest.class.getName());
	P1_Login p1_Login;
	@Given("^The landing page is open fetch driver$")
    public void the_landing_page_is_open_fetch_driver() {
		driver = Openbrowsersd.getdriver();
		er = Openbrowsersd.getreport();
		helper = new WebDriverHelper(driver);
		driver.get(url);
		lploc = new UI_0_Landingpage(driver);
    }

    @When("^I click on Signin$")
    public void i_click_on_signin() {
    	p1_Login = new P1_Login(driver, er);
    	p1_Login.clickonlogin(lploc);
    	loginloc = new UI_1_LoginPage(driver);
    }

    @Then("^Navigate to the page and enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void navigate_to_the_page_and_enter_something_and_something(String emailid, String password) throws InterruptedException {
    	driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p1_Login.entercorrectdetails(loginloc, emailid, password);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("Login Successful");
    }
	
	public static WebDriver getdriver() {
		return driver;
	}

	public static ExtentReport getreport() {
		return er;
	}
}
