package sprint1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateNewOpportunity {

	public static void main(String[] args) throws InterruptedException {
		
		
	WebDriverManager.chromedriver().setup();
	ChromeOptions option =new ChromeOptions();
	option.addArguments("--disable-notifications");
		
//1. Login to https://login.salesforce.com
	
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
	
//4. Click on Opportunity tab 
	
	WebElement element2=driver.findElement(By.xpath("//span[text()='Opportunities']"));
	JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	executor2.executeScript("arguments[0].click();", element2);
			
//5. Click on New button
	
	driver.findElement(By.xpath("//div[text()='New']")).click();
			
//6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Srividhya");
			
	
//7. Choose close date as Today
	driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
	WebElement element3=driver.findElement(By.xpath("//button[@name='today']"));
	JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	executor3.executeScript("arguments[0].click();", element3);
	
//8. Select 'Stage' as Need Analysis
	
	driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
	driver.findElement(By.xpath("(//span[@class='slds-media__body'])[4]")).click();
	
//9. click Save and VerifyOppurtunity Name
	
	driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
    Thread.sleep(2000);
	
//Expected Result:
//New Opportunity should be created with name as  'Salesforce Automation by Your Name'
    
  String OppName= driver.findElement(By.xpath("//div[text()='Opportunity']//following-sibling::slot//lightning-formatted-text")).getText();
  System.out.println(OppName);
  
  
  if(OppName.contains("Salesforce Automation by Srividhya"))
  {
	System.out.println("Opportunity is created");  
  }
  else {
	  System.out.println("Opportunity is not created");
  }
  
	}

}
