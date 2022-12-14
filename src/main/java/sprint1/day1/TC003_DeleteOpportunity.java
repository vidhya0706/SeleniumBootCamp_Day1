package sprint1.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_DeleteOpportunity extends BaseClass {
	
	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/deleteOpp.xlsx";
	}

	@Test(dataProvider="sendData",retryAnalyzer =RetryFailedTests.class)
	public  void runDeleteOpportunity(String name) throws InterruptedException {
			
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
			
//5. Search the Opportunity 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(name +Keys.ENTER);
		Thread.sleep(2000);
		
//6. Click on  the Dropdown icon and Select Delete
		WebElement element3 = driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
//7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name
//Expected result:
//Oppurtunity is Successfully deleted
		
		String Name= driver.findElement(By.xpath("//span[text()='Opportunity Name']")).getText();
		System.out.println(Name);
		if(Name.contains("Srividhya"))
		  {
			System.out.println("Opportunity is not deleted");  
		  }
		  else {
			  System.out.println("Opportunity is deleted");
		  }
		

	}

}
