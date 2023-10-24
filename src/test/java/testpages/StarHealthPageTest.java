package testpages;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import base.BaseTest;
import dataprovider.XlS_dataprovider;
import dataprovider.XlS_dataprovider2;
import pages.HealthInsurancePage;
import pages.HomePage;
public class StarHealthPageTest extends BaseTest {
	HomePage homePage;
	HealthInsurancePage healthInsurancePage;

	@Test(priority=1 )
	public void Validate_Alt_Value_Of_Logo() throws InterruptedException {
		homePage = new HomePage(driver);
		Thread.sleep(3000);
		String Alt_Value = homePage.logo.getAttribute("alt");
		Thread.sleep(5000);
		boolean isValidated = Alt_Value.equals("Star Health Logo");
		System.out.println(Alt_Value);
		Assert.assertTrue(isValidated, "alt value not matching");
		
		
	}
	
	@Test(priority=2)
	public void click_on_plans() throws InterruptedException {
		Thread.sleep(1000);
		homePage.Hover_over_Plans();
	}
	
	@Parameters({ "name", "mobile" ,"pin"})
	@Test(priority=3)
	public void GetAQuoate(String name,String mobile,String pin) throws InterruptedException {
		healthInsurancePage=new HealthInsurancePage(driver);
		Thread.sleep(4000);
		healthInsurancePage.Give_Input_And_Click_GetaQuote_Button(name, mobile, pin);
		
	}
	
	@Parameters({"email"})
	@Test(priority=4)
	public void Input_Authorize_Form(String email) throws InterruptedException {
		Thread.sleep(2000);
		healthInsurancePage.Give_Input_in_Authorize_Form_And_Click_Next(email);
	}
	
	
	@Test(priority = 5,dataProvider = "testdata")
	public void Get_Value(String name,String email) throws InterruptedException {
		
		Thread.sleep(1000);
		ArrayList<String> listValue=healthInsurancePage.Fetch_The_Value();
		//System.out.println(listValue);
		
		String ActualName=listValue.get(0);
		String Actualemail=listValue.get(2);
		
		Assert.assertEquals(email, Actualemail);
		Assert.assertEquals(name, ActualName);
	}

	
//	@Test(priority = 6,dataProvider = "linkdata")
//	public void Check_social_Media_link(String fb,String youtube,String linkdln,String twitter,String instagram) throws InterruptedException {
//		
//		Thread.sleep(1000);
//		ArrayList<String> links=healthInsurancePage.fetch_Social_media_links();
//		System.out.println(fb);
//		System.out.println(youtube);
//		System.out.println(linkdln);
//		System.out.println(twitter);
//		System.out.println(instagram);
//		
//		System.out.println(links);
//		
//	}
	
	@Test(priority = 6)
	public void clickontwitter() {
		healthInsurancePage.clik_on_twitter();
	}
	
	@Test(priority = 7)
	public void validatetwitter() {
		String actual=healthInsurancePage.validate_twitter();
		String exp="https://twitter.com/starhealthins?lang=en";
		Assert.assertEquals(actual, exp);
		
	}
	
	
	
	
	@DataProvider(name="testdata")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
		
		Object input[][] = XlS_dataprovider.getTestData("Sheet1");
		return input;
		
	}
	
	@DataProvider(name="linkdata")
	public Object[][] datasupplier2() throws EncryptedDocumentException, IOException
	{
		
		Object input2[][] = XlS_dataprovider2.getTestData2("Sheet1");
		return input2;
		
	}
}
