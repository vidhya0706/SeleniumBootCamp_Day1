package sprint1.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC013_EditWorkTypeNegative {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
		
//1) Launch the app
//2) Click Login
//3) Login with the credentials
		ChromeDriver driver =new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
//4) Click on the App Laucher Icon left to Setup
		WebElement element = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//5) Click on View All
//6) Click on Work Types
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("work types");
		Thread.sleep(2000);
		
		WebElement element1 =driver.findElement(By.xpath("//p[@class='slds-truncate']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);	
		Thread.sleep(200);
//7) Click on the Arrow button at the end of the first result
//8) Click on Edit
		WebElement element2 = driver.findElement(By.xpath("//tbody/tr/td[5]//a"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
//9) Enter Time Frame Start as '9'
		
		WebElement element3=driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		//element3.clear();
		element3.sendKeys("9");
//10) Enter Time Frame End as '6'
		WebElement element4=driver.findElement(By.xpath("(//input[@type='text'])[7]"));
		//element4.clear();
		element4.sendKeys("6");
//11) Click on Save
		WebElement element5=driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
		executor5.executeScript("arguments[0].click();", element5);
//12) Verify the error message
		
//Expexted Result:
//The Error message should be displayed

		}
		

}
