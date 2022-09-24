package sprint1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ChromeDriver driver;
	
	@BeforeMethod
	public  void preConditions() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		driver =new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

	}
	
	@AfterMethod
	public  void postConditions() {
		
	driver.close();
	}
	
	}


