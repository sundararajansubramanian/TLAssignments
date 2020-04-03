package week1.day5;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Prj1tc1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		//Load URL
		driver.get("https://acme-test.uipath.com/account/login");
		// Login to the Site
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(2000);
		//Search Vendor Country
		WebElement ele = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		Thread.sleep(2000);
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		Thread.sleep(2000);
		WebElement Country = driver.findElementByXPath("//td[text()='France']");
		String Country1 = Country.getText();
		System.out.println("The Country Name is: "+Country1);
		//Logout and close the Browser
		driver.findElementByLinkText("Log Out").click();
		Thread.sleep(2000);
		driver.close();

	}

}
