package sprint1.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;
import sprint1.day1.RetryFailedTests;

public class TC006_DeleteAccount extends BaseClass {
	
	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/createAccount.xlsx";
	}

	@Test(dataProvider="sendData",retryAnalyzer =RetryFailedTests.class)
	public  void runDeleteAccount(String name) throws InterruptedException {
		
//2. Click on toggle menu button from the left corner
		WebElement element = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		Thread.sleep(2000);
//3. Click view All and click Sales from App Launcher		
		WebElement element1 =driver.findElement(By.xpath("(//p[@class='al-app-tile-description'])[3]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);	
//4. Click on Accounts tab		
		WebElement element2=driver.findElement(By.xpath("//span[text()='Accounts']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);
//5. Search the account 'Your Name'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Srividhya"+Keys.ENTER);
		Thread.sleep(2000);
//6. Click on  the Dropdown icon and Select Delete
		WebElement element3 = driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
//7. Verify Whether account is Deleted using account Name
		boolean Account = driver.findElement(By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']")).isEnabled();
		System.out.println(Account);
		
//Expected Result:
//The Account should be deleted successfully
		
		if(Account=true)
		  {
			System.out.println("Account is deleted");  
		  }
		  else {
			  System.out.println("Account is not deleted");
	}
		

	}
}
