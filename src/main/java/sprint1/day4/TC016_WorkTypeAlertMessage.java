package sprint1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;
import sprint1.day1.RetryFailedTests;

public class TC016_WorkTypeAlertMessage extends BaseClass {
	
	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/editworktypealert.xlsx";
	}
	
	
@Test(dataProvider="sendData",retryAnalyzer =RetryFailedTests.class)
	public  void runWorkTypeAlertMessage(String name) throws InterruptedException {
	
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
		Thread.sleep(2000);
	//7) Click on New
		WebElement element2 = driver.findElement(By.xpath("//div[text()='New']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
	//8) Enter Work Type Name as 'Bootcamp'
	//9) Click on Save
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(name);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	
	//Expexted Result:
	//"Complete this field." alert message should be displayed for Estimated Duration
		
	String text = driver.findElement(By.xpath("//li[contains(text(),'Estimated Duration')]")).getText();
	if(text.contains("Estimated Duration")) {
		System.out.println("Error is displayed");
	}
	else {
		System.out.println("Error is not displayed");
	}

	}

}
