package UIStore;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_0_Landingpage {
	public WebDriver driver;

	public UI_0_Landingpage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href='https://www.bigsmall.in/account/login']")
	WebElement signin;
		public WebElement getsignin()
		{
			return signin;
		}
		
	@FindBy(css="input[type='search']")
	WebElement searchbox;
		public WebElement getsearchbox()
		{
			return searchbox;
		}
	
	@FindBy(xpath="//*[contains(text(),' Corporate Gifts ')]")
	WebElement corporategift;
		public WebElement getcorporategift() {
			return corporategift;
		}
		
	@FindBy(xpath="//*[contains(text(),' Personalized Gifts ')]")
	WebElement personalizedgift;
		public WebElement getpersonalizedgift()
		{
			return personalizedgift;
		}
		
	@FindBy(xpath="//*[contains(text(), ' Home & Lifestyle')]")
	WebElement homelifestyle;
		public WebElement gethomelifestyle() {
			return homelifestyle;
		}
		
	@FindBy(xpath="//*[contains(text(), ' Home Decor ')]")
	WebElement homedecor;
		public WebElement gethomedecor()
		{
			return homedecor;
		}
	
	@FindBy(xpath="//*[contains(text(),'wish list')]")
	WebElement wishlist;
		public WebElement getwishlist()
		{
			return wishlist;
		}
		
	@FindBy(xpath="//*[contains(text(),'gift card')]")
	WebElement giftcard;
		public WebElement getgiftcard()
		{
			return giftcard;
		}
		
	@FindBy(id="Email")
	WebElement email;
		public WebElement getemail()
		{
			return email;
		}
		
		@FindBy(xpath="//*[contains(text(),'About Us')]")
		WebElement about;
			public WebElement aboutus()
			{
				return about;
			}
		
	
	
}
