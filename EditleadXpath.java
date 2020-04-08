package week2day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditleadXpath {

	/*Assignment 1:
http://leaftaps.com/opentaps/control/main
 Edit Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Enter first name
9	Click Find leads button
10	Click on first resulting lead
11	Verify title of the page
12	Click Edit
13	Change the company name
14	Click Update
15	Confirm the changed name appears
16	Close the browser (Do not log out)*/
	
	
	public static void main(String[] args) throws InterruptedException {
		// Browser launch
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		//Load the URL and login the Application
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		//Edit the Lead
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("sundar");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		//Verify the Page Title
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]").click();
		String pagetitle = driver.getTitle();
		System.out.println("The Page Title is : "+pagetitle);
		//Edit the company name
		driver.findElementByXPath("//a[text() = 'Edit']").click();
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").clear();
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").sendKeys("Auto");
		driver.findElementByXPath("(//input[@name='submitButton'])[1]").click();
		//Verify the company name update status
		if(driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText().contains("Auto"))
		  {
			System.out.println("Company name successfully updated");
		  }	else {
			  System.out.println("Company name update failed");
		  		}
		//Close the Browser
		driver.close();

	}

}
