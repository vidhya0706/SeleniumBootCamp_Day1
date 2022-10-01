package sprint2.day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC021_CreateContactForCompaign {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver =new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		   
//2. Click on toggle menu button from the left corner
		WebElement element = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		Thread.sleep(2000);
		
		WebElement element1 =driver.findElement(By.xpath("(//p[@class='al-app-tile-description'])[3]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);	
//4. Click on Campaigns tab  
		WebElement element2 =driver.findElement(By.xpath("//span[text()='Campaigns']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
//5. Click Bootcamp link
		driver.findElement(By.xpath("//a[@title='BootCamp']")).click();
//6. Click on New Contact under Search field
		driver.findElement(By.xpath("//div[@title='New Contact']")).click();
//8. Pick Salutation as 'Mr.'
//9. Enter first name as <your First Name>
//10. Enter last name as <your last name>
		driver.findElement(By.xpath("//a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[@title='Mrs.']")).click();
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Sri");
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Vidhya");
//12. Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		Thread.sleep(2000);
//13. Click on Add Contact from Campaign member
		
		Actions a = new Actions(driver);
		//scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		driver.findElement(By.xpath("//div[@title='Add Contacts']")).click();
//14. Select the Created Contact
//15. Click Next
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys("Sri Vidhya"+Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='slds-checkbox--faux'])[7]")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral button-brand uiButton--default uiButton--brand uiButton']")).click();
        Thread.sleep(2000);
//16. Click Submit on the Add to Campaign pop up
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral button-brand uiButton--default uiButton--brand uiButton']")).click();
		
//17. verify the created Contact under Campaign by clicking "View All"
		Actions a1 = new Actions(driver);
		//scroll down a page
		a1.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//span[@class='view-all-label']")).click();
		
		String text=driver.findElement(By.xpath("(//table)[3]//tbody/tr/td[4]")).getText();
		if(text.contains("Sri Vidhya"))
		{
			System.out.println("Contact is created under compaign");
		}
		else
		{
			System.out.println("Contact is not created under compaign");
		}
		
		
//18. Navigate to Contacts tab
		WebElement element3 = driver.findElement(By.xpath("//span[text()='Contacts']"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		Thread.sleep(2000);
//19. Search for Cantact with your Name
		String text1 = driver.findElement(By.xpath("//table//tbody/tr/th[1]")).getText();
		if(text1.contains("Sri Vidhya"))
		{
			System.out.println("Contact is created under contact");
		}
		else
		{
			System.out.println("Contact is not created under contact");
		}
		

	}

}
