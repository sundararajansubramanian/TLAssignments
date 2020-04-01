package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1assign2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement email = driver.findElementById("email");
		email.sendKeys("ssr15@gmail.com");
		driver.findElementById("pass").sendKeys("test@6754");
		driver.findElementById("loginbutton").click();
		Thread.sleep(2000);
		/*driver.findElementById("userNavigationLabel").click();
		driver.findElementByLinkText("Log Out").click();*/
		driver.close();
		
		
	}

}
