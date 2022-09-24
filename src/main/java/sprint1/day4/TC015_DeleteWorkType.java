package sprint1.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC015_DeleteWorkType extends BaseClass {

	@Test
	public  void runDeleteWorkType() throws InterruptedException {
		
//	4) Click on the App Laucher Icon left to Setup
		WebElement element = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//	5) Click on View All
//	6) Click on Work Types
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("work types");
		Thread.sleep(2000);
		
		WebElement element1 =driver.findElement(By.xpath("//p[@class='slds-truncate']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);	
		Thread.sleep(200);
//	7) Click on the Arrow button at the end of the first result
//	8) Click on Delete
//	9) Click on Delete
		WebElement element2 = driver.findElement(By.xpath("//tbody/tr/td[5]//a"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
//	10) Verify the message
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toast')]")));
		String toastText = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
		System.out.println("Toast message is : " + toastText);
		
//	Expexted Result:
//	The Work Type should be deleted successfully.
		if(toastText.contains("deleted"))
		{
			System.out.println("deleted successfully");
		}
		else {
			System.out.println("Not delted successfully");
		}
		
	}

}
