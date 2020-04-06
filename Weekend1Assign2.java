package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Weekend1Assign2 {

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
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Search the Lead with phone number
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByLinkText("Phone").click();
		driver.findElementByName("phoneAreaCode").sendKeys("123");
		driver.findElementByName("phoneNumber").sendKeys("4567890");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		//Select the first record from the search result and record the Lead ID
		String leadid = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").getText();
		System.out.println("The Lead Id is : " +leadid);
		
		//Delete the selected first record
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();
		driver.findElementByLinkText("Delete").click();
		
		//Search the deleted lead with Lead ID
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(leadid);
		driver.findElementByXPath("//button[text()='Find Leads']").click(); 
		Thread.sleep(2000);
		
		//Verify the delete status with deleted lead id search result message
		String result = driver.findElementByClassName("x-paging-info").getText();
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
