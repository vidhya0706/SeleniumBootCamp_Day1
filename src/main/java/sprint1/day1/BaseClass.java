package sprint1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public  void preConditions(String url,String username,String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		driver =new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

	}
	
	@AfterMethod
	public  void postConditions() {
		
	driver.close();
	}
	
	}


