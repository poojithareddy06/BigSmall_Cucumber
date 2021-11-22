package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_9_Aboutuspage {
	public WebDriver driver;
	
	public UI_9_Aboutuspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="a[href='https://www.bigsmall.in/pages/about-us']")
	WebElement about;
		public WebElement aboutus()
		{
			return about;
		}
		
	@FindBy(className="section-header__title")
	WebElement title;
	public WebElement getTitle(){
		return title;
	}

}
