package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_1_LoginPage {
	public WebDriver driver;

	public UI_1_LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="CustomerEmail")
	WebElement txtemail;
		public WebElement email()
		{
			return txtemail;
		}
	
	@FindBy(id="CustomerPassword")
	WebElement txtpassword;
		public WebElement password()
		{
			return txtpassword;
		}
		
	@FindBy(css="input[type='submit']")
	WebElement btnsubmit;
		public WebElement sign_in()
		{
			return btnsubmit;
		}
		
	@FindBy(id="customer_register_link")
	WebElement btncreateaccount;
		public WebElement createaccount()
		{
			return btncreateaccount;
		}
	
	@FindBy(id="RecoverPassword")
	WebElement btnforgot;
		public WebElement forgot()
		{
			return btnforgot;
		}
		
	@FindBy(id="RecoverEmail")
	WebElement txtrecoveremail;
		public WebElement recoveryemail()
		{
			return txtrecoveremail;
		}
		
	@FindBy(css="input[type='submit']")
	WebElement btnforgotsubmit;
		public WebElement forgotpwdsubmit()
		{
			return btnforgotsubmit;
		}

}
