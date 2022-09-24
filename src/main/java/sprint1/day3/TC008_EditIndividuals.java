package sprint1.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_EditIndividuals {

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

//2. Click on the toggle menu button from the left corner
		WebElement element = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
			
//3. Click View All and click Individuals from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");
		Thread.sleep(2000);
		
		WebElement element1 =driver.findElement(By.xpath("//p[@class='slds-truncate']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);	
		Thread.sleep(200);
		
//4. Click on the Individuals tab 
//5. Search the Individuals 'Kumar'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Vidhya"+Keys.ENTER);
		Thread.sleep(200);
		

//6. Click on the Dropdown icon and Select Edit
        WebElement element2 = driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
		
        driver.findElement(By.xpath("//a[@title='Edit']")).click();

//7.Select Salutation as 'Mrs'
        
        WebElement drDown = driver.findElement(By.xpath("//a[@class='select']"));
        drDown.click();
        driver.findElement(By.xpath("//a[@title='Mrs.']")).click();
//8.Enter the first name as 'Sri'.
        driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Sri");
//9. Click on Save and Verify the first name as 'sri'
        
       driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
      Thread.sleep(200);
      
       String text = driver.findElement(By.xpath("//tbody/tr[1]/th//a")).getText();
       
       System.out.println(text);
       if(text.contains("Sri"))
       {
    	   System.out.println("Edited successfully");
       }
       else
       {
    	   System.out.println("Not edited");
       }
}
}
