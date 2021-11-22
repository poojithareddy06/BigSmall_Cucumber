package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_2_CreateAccount {
	public WebDriver driver;

	public UI_2_CreateAccount(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="FirstName")
	WebElement firstname;
		public WebElement getfirstname() 
		{
			return firstname;
		}
	
	@FindBy(id="LastName")
	WebElement lastname;
	
	public WebElement getlastname() {
		return lastname;
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	public WebElement getemail() {
		return email;
	}
	
	@FindBy(id="CreatePassword")
	WebElement password;
	
	public WebElement createpassword() {
		return password;
	}
	
	@FindBy(css="input[type='submit']")
	WebElement createacc;
	
	public WebElement getcreateaccount() {
		return createacc;
	}
	
}
