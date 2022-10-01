package sprint2.day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC022_DeleteContact {
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
//	4. Click on Contacts tab 
		WebElement element2 =driver.findElement(By.xpath("//span[text()='Contacts']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
//5. Search for Contact with name as <your name>
		driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys("Sri Vidhya" +Keys.ENTER);
//6. Click on dropdown icon for the Lead and Select Delete
		WebElement element3 =driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
//			7. Confirm the Delete for Lead
//			8. Click on Campaign tab 
//			9. Click Bootcamp link
//			10. Verify the associated Contact

}
}
