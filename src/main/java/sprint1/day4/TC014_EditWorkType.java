package sprint1.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;
import sprint1.day1.RetryFailedTests;

public class TC014_EditWorkType extends BaseClass {
	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/editworktype.xlsx";
	}

	@Test(dataProvider="sendData",retryAnalyzer =RetryFailedTests.class)
	public void runEditWorkType(String starttime,String endtime,String name) throws InterruptedException {
		
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
		element3.clear();
		element3.sendKeys(starttime);
//10) Enter Time Frame End as '18'
		WebElement element4=driver.findElement(By.xpath("//input[@id='1542:0']"));
		element4.clear();
		element4.sendKeys(endtime);
//11) Click on Save
		WebElement element5=driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
		executor5.executeScript("arguments[0].click();", element5);
		
//12) Verify the success message
		        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toast')]")));
				String toastText = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
				System.out.println("Toast message is : " + toastText);
//Expexted Result:
//The work Type should be edited successfully.
				if(toastText.contains(name))
				{
					System.out.println("Edited successfully");
				}
				else {
					System.out.println("Not edited successfully");
				}
				
	}

}
