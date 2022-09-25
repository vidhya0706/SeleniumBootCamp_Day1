package sprint2.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC019_CreateOpporForNewCompaign extends BaseClass  {

@Test
	public  void runCreateOpporForNewCompaign() throws InterruptedException {
		  
		;
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
//4. Click on  Campaigns tab 
		WebElement element2 =driver.findElement(By.xpath("//span[text()='Campaigns']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
//5. Click Bootcamp link
		driver.findElement(By.xpath("//a[@title='BootCamp']")).click();
//6. Click on"New" from Oppurtunities tab
		driver.findElement(By.xpath("(//div[text()='New'])[2]")).click();
		
//7. Enter Opportunity name as 'Opportunity from Your Name'
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Srividhya");
		
//8. Choose close date as Tomorrow
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//span[text()='26']")).click();
//9. Select 'Stage' as Need Analysis
		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
	
		WebElement element3 =driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);	
//10. click Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
//11. Verify new Oppurtunity in Campaign
		String text = driver.findElement(By.xpath("(//div[@class='slds-grid slds-page-header forceRelatedListCardHeader'])[3]/following::div")).getText();
		if(text.contains("Srividhya")) {
			System.out.println("Opportunity is created for compaign");
		}
		else {
			System.out.println("Opportunity is created for compaign");
		}
//12. Click on Opportunities Tab
		WebElement element4=driver.findElement(By.xpath("//span[text()='Opportunities']"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", element4);
//13. Verify the newly created Opportunity (Oppotunity from your name)
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Srividhya"+Keys.ENTER);
		
		String OppName= driver.findElement(By.xpath("//tbody/tr/th[1]")).getText();
		  System.out.println(OppName);
		  
		  
		 if(OppName.contains("Salesforce Automation by Srividhya"))
		  {
			System.out.println("Opportunity is created");  
		  }
		  else {
			  System.out.println("Opportunity is not created");
		  }

		
		//Expected Result:
		//1. New Opportunity should be Created under Bootcamp campaign
		//2. New Opportunity should be displayed under Opportunities tab

}
}
