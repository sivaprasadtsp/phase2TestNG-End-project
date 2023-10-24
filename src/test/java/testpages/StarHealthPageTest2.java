package testpages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
public class StarHealthPageTest2 extends BaseTest  {
	@Test
	public void fetch_All_Link() throws InterruptedException {
		driver.get("https://www.starhealth.in/");
		Thread.sleep(2000);
		List<WebElement> allLink=driver.findElements(By.xpath("//a"));
		
		for (WebElement webElement : allLink) {
			String links=webElement.getAttribute("href");
			System.out.println(links);
		}
	}
}
