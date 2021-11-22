package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_4_Personalizedgiftpage {
	public WebDriver driver;

	public UI_4_Personalizedgiftpage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Personalized Wonder Woman Themed Nameplate | COD not available')]")
	WebElement productname;
		public WebElement prproduct() 
		{
			return productname;
		}
		
	@FindBy(css="input[type='text']")
	WebElement name;
		public WebElement entername()
		{
			return name;
		}
		
	@FindBy(css="button[name='add']")
	WebElement addtocart;
		public WebElement addtocart()
		{
			return addtocart;
		}
	
		@FindBy(xpath="//*[contains(text(),'Shopping Cart')]//following::h2")
		WebElement cnfrmmessage;
		
		public WebElement getverification() {
			return cnfrmmessage;
		}
}
