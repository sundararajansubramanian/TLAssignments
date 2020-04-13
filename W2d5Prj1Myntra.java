package week2day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class W2d5Prj1Myntra {

	public static void main(String[] args) throws InterruptedException {
		
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		// Open the URL
		driver.get("https://www.myntra.com/");
		
		//selection of women goat
		WebElement women = driver.findElementByXPath("(//a[text()='Women'])[1]");
		Actions act = new Actions(driver);
		act.moveToElement(women).perform();
		driver.findElementByXPath(" //a[contains(text(), 'Jackets & Coats')]").click();
		//4) Find the total count of item (top) 
		
		//5) Validate the sum of categories count matches
			//Get the Total count
			WebElement count = driver.findElementByClassName("title-count");
			String totalcount = count.getText();
			String tc = totalcount.replaceAll("\\D", "");
			int tcount = Integer.parseInt(tc);
			System.out.println("Total count : "+tcount);
			
			//Get the Jacket count
			WebElement jacket = driver.findElementByXPath("(//span[@class='categories-num'])[1]");
			String jcount = jacket.getText();
			String jcount1 = jcount.replaceAll("\\D", "");
			int j1 = Integer.parseInt(jcount1);
			System.out.println("Jacket Count : " +j1);
			
			//Get the coat count
			WebElement coat = driver.findElementByXPath("(//span[@class='categories-num'])[2]");
			String ccount = coat.getText();
			String ccount1 = ccount.replaceAll("\\D", "");
			int c1 = Integer.parseInt(ccount1);
			System.out.println("Coats count : "+c1);
			
			//Add Jacket and count
			int totalcount1 = j1+c1;
			System.out.println("Addition of Jackets and Coats is : "+totalcount1);
			
			// Category total check
			if (tcount == totalcount1)
			{
				System.out.println("Categories Count is matching with Total count");
			} else {
				System.out.println("Something went wrong, Please check...");
			}
			
		//6) Check Coats
		driver.findElementByXPath("//label[text()='Coats']").click();
		
		//7) Click + More option under BRAND
		driver.findElementByClassName("brand-more").click();
		
		//8) Type MANGO and click checkbox
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("Mango");
		driver.findElementByXPath("//label[@class=' common-customCheckbox']").click();
		
		//9) Close the pop-up x
		driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]").click();
		Thread.sleep(2000);
		
		//10) Confirm all the Coats are of brand MANGO
		List<WebElement> Mango = driver.findElementsByXPath("//h3[@class='product-brand']");
		for (WebElement each : Mango) {
			String bname = each.getText();
			if (bname.equals("MANGO"))
			{
				System.out.println("All the displayed products are from Mango brand");
				break;
			} else {
				System.out.println("Something went wrong, Please check...");
				break;
			}
		}
		
		//11) Sort by Better Discount
		WebElement sort = driver.findElementByXPath("//span[text()='Recommended']");
		Actions sort1 = new Actions(driver);
		sort1.moveToElement(sort).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		Thread.sleep(2000);
		
		//12) Find the price of first displayed item
		List<WebElement> first = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		String price = first.get(0).getText();
		String rprice = price.replaceAll("\\D", "");
		int fprice = Integer.parseInt(rprice);
		System.out.println("The First coat price is: "+fprice);
		
		//13) Mouse over on size of the first item
		WebElement addwish = driver.findElementByXPath("(//img[@class='img-responsive'])[1]");
		Actions wishlist = new Actions(driver);
		wishlist.moveToElement(addwish).perform();
		//14) Click on WishList Now
		driver.findElementByXPath("(//span[contains(@class,'product-actionsButton product-wishlist')])[1]").click();
				
		//15) Close Browser
		driver.close();
	}

}
