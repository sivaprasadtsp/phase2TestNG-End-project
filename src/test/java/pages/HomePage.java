package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
public class HomePage extends BaseTest {
Actions a = new Actions(driver);
	
	@FindBy(xpath = "//img[@class='cursor-pointer']")
	public  WebElement logo;
	
	
	@FindBy(xpath = "//p[text()='Plans']")
	public  WebElement plans;
	
	
			@FindBy(xpath = "(//a[text()='For My Family'])[1]")
			public  WebElement ForMyFamily;
	
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	public void Hover_over_Plans() throws InterruptedException
	{
	    a.moveToElement(plans).build().perform();
	    
	    Thread.sleep(3500);
	    
	    ForMyFamily.click();
	}
}
