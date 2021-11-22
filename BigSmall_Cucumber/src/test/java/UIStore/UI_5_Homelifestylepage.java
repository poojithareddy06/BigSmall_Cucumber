package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_5_Homelifestylepage {

	public WebDriver driver;
	public UI_5_Homelifestylepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="a[data-dropdown-rel='home-lifestyle']")
	WebElement ddselect;
		public WebElement getdropdownname()
		{
			return ddselect;
		}
}
