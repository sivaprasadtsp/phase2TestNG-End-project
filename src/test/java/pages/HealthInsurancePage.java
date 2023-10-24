package pages;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
public class HealthInsurancePage extends BaseTest {
	@FindBy(xpath = "//input[@id='name']")
	public  WebElement name;
	
	
	@FindBy(xpath = "//input[@id='phoneNumber']")
	public  WebElement phnumber;
	
	
	@FindBy(xpath = "//input[@id='pinCode']")
	public  WebElement pinCode;
	
	
	@FindBy(xpath = "//span[text()='Get a quote']")
	public  WebElement GetQuoteButton;
	
	
	@FindBy(xpath = "//input[@id='email']")
	public  WebElement emailField;
	
	
	@FindBy(xpath = "//span[text()='Next']")
	public  WebElement nextButton;
	
	
	@FindBy(xpath = "//span[text()='Back']")
	public  WebElement backButton;
	
	
	@FindBy(xpath = "//input[@id='mobile']")
	public  WebElement mobileField;
	
	
	
	@FindBy(xpath = "(//a[@class='mr-4 mr-10-xs'])[1]")
	public  WebElement fb;		
	
	@FindBy(xpath = "(//a[@class='mr-4 mr-10-xs'])[2]")
	public  WebElement youTube;
	
	@FindBy(xpath = "(//a[@class='mr-4 mr-10-xs'])[3]")
	public  WebElement Linkdln;
	
	@FindBy(xpath = "(//a[@class='mr-4 mr-10-xs'])[4]")
	public  WebElement twitter;
	
	@FindBy(xpath = "(//a[@class='mr-4 mr-10-xs'])[5]")
	public  WebElement insta;
					
	
	public HealthInsurancePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
	}
	
	
	public void Give_Input_And_Click_GetaQuote_Button(String Name,String phNumber,String pincode) throws InterruptedException {

		Thread.sleep(2000);
		name.sendKeys(Name);
		phnumber.sendKeys(phNumber);
		pinCode.sendKeys(pincode);
		GetQuoteButton.click();
		
	}
	
	public void Give_Input_in_Authorize_Form_And_Click_Next(String email) throws InterruptedException {
		emailField.sendKeys(email);
		Thread.sleep(1000);
		nextButton.click();
		Thread.sleep(1000);
		backButton.click();
		
	}
	
	public ArrayList<String> Fetch_The_Value() throws InterruptedException {
		
		Thread.sleep(2000);
		
		ArrayList<String> list=new ArrayList<String>();
		
		String nameValue= name.getAttribute("value");
		String PhValue= mobileField.getAttribute("value");
		String emailValue= emailField.getAttribute("value");
		
		list.add(nameValue);
		list.add(PhValue);
		list.add(emailValue);
		
		return list;
		
	}
	
	public ArrayList<String> fetch_Social_media_links() throws InterruptedException {
		
		Thread.sleep(1000);
		ArrayList<String> list_Of_Link=new ArrayList<String>();
		
		String fblink=fb.getAttribute("href");
		String Linkdlnlink=Linkdln.getAttribute("href");
		String twitterlink=twitter.getAttribute("href");
		String youtubelink=youTube.getAttribute("href");
		String instaLink=insta.getAttribute("href");
		
		list_Of_Link.add(fblink);
		list_Of_Link.add(youtubelink);
		list_Of_Link.add(Linkdlnlink);
		list_Of_Link.add(twitterlink);
		list_Of_Link.add(instaLink);
		
		return list_Of_Link;
	}
	
	
	public void clik_on_twitter() {
		twitter.click();
	}


	public String validate_twitter() {
	
		String T_url=driver.getCurrentUrl();
		return T_url;
	}
}
