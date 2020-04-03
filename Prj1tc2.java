package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Prj1tc2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Search the bus
		driver.findElementById("src").sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElementById("src").sendKeys(Keys.TAB);
		driver.findElementById("dest").sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElementById("dest").sendKeys(Keys.TAB);
		driver.findElementByXPath("//label[@for='onward_cal']").click();
		driver.findElementByXPath("(//td[text()='30'])[2]").click();
		driver.findElementById("search_btn").click();
		
		//Applying the filer in search
		driver.findElementByXPath("(//label[@class='cbox-label'])[4]").click();
		driver.findElementByXPath("//label[@title='SLEEPER']").click();
		driver.findElementByXPath("(//div[contains(@class,'w-15 fl')]//a)[2]").click();
		
		//Close the browser
		driver.close();
		
	
		
	}

}
