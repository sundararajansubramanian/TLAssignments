package week2day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadXpath {

	/*Assignment 2:
http://leaftaps.com/opentaps/control/main
Delete Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Phone
9	Enter phone number
10	Click find leads button
11	Capture lead ID of First Resulting lead
12	Click First Resulting lead
13	Click Delete
14	Click Find leads
15	Enter captured lead ID
16	Click find leads button
17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
18	Close the browser (Do not log out)*/
	
	
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
		driver.findElementByXPath("//input[@class = 'decorativeSubmit']").click();
		
		//Search the Lead with phone number
		driver.findElementByXPath("//a[contains(text(), 'CRM/SFA')]").click();
		driver.findElementByXPath("//a[contains(text(), 'Leads')]").click();
		driver.findElementByXPath("//a[text() = 'Find Leads']").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneAreaCode']").sendKeys("123");
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("4567890");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		//Select the first record from the search result and record the Lead ID
		String leadid = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").getText();
		System.out.println("The Lead Id is : " +leadid);
		
		//Delete the selected first record
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();
		driver.findElementByXPath("//a[text()='Delete']").click();
		
		//Search the deleted lead with Lead ID
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadid);
		driver.findElementByXPath("//button[text()='Find Leads']").click(); 
		Thread.sleep(2000);
		
		//Verify the delete status with deleted lead id search result message
		String result = driver.findElementByXPath("//div[text()='No records to display']").getText();
			if (result.contains("No records to display"))
				{
					System.out.println("Selected record deleted successfully");
				} 
			else 	
				{
					System.out.println("Selected record deleted process failed");
				}
		
		//Close the Browser
		driver.close();

	}

}
