package sprint1.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;
import sprint1.day1.RetryFailedTests;

public class TC009_DeleteIndividual extends BaseClass {
	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/createIndividuals.xlsx";
	}

	@Test(dataProvider= "sendData",retryAnalyzer =RetryFailedTests.class)
	public void runDeleteIndividual(String name) throws InterruptedException {
		
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
		Thread.sleep(2000);
//4. Click on the Individuals tab 
//5. Search the Individuals 'Vidhya'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(name   +Keys.ENTER);
		Thread.sleep(2000);
//6. Click on the Dropdown icon and Select Delete
		   WebElement element2 = driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
	       JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		   executor2.executeScript("arguments[0].click();", element2);	
			
	        driver.findElement(By.xpath("//a[@title='Delete']")).click();
//7.Click on the Delete option in the displayed popup window.
	        driver.findElement(By.xpath("//span[text()='Delete']")).click();
//8. Verify Whether Individual is Deleted using Individual last name
	        String text = driver.findElement(By.xpath("//tbody/tr[1]/th//a")).getText();
	       
//Expected result:
//The Individual is deleted Successfully 	        
	        System.out.println(text);
	        if(text.equals(name))
	        {
	     	   System.out.println("Deleted successfully");
	        }
	        else
	        {
	     	   System.out.println("Not deleted");
	        }
	        
	     
	}

}
