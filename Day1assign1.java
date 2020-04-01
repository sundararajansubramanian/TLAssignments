package week1.day2;

import org.openqa.selenium.WebElement;

/*Assignment 1 Steps :
1. load the URL - http://leaftaps.com/opentaps/control/main
2. Login as user -> DemoSalesManager & password -> crmsfa
3. Click on CRM/SFA
4. Click on Create Lead
5. Enter mandatory fields - Company Name, First Name & Last Name
6. Click on Submit
7. Verify lead has been created using title
8. Close browser */

import org.openqa.selenium.chrome.ChromeDriver;

public class Day1assign1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		WebElement eleusername = driver.findElementById("username");
		eleusername.sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("CRM/SFA").click();
		Thread.sleep(2000);
		driver.findElementByLinkText("Create Lead").click();
		Thread.sleep(2000);
		driver.findElementById("createLeadForm_companyName").sendKeys("TEST");
		driver.findElementById("createLeadForm_firstName").sendKeys("Sundar");
		driver.findElementById("createLeadForm_lastName").sendKeys("Test");
		driver.findElementByName("submitButton");
		Thread.sleep(2000);
					
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		
		driver.close();
		
		/*
		//get the title
		String title = driver.getTitle();
		System.out.println(title);
		
		//refresh and close
		driver.navigate().refresh();
		driver.close();
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		*/
		
	}

}
