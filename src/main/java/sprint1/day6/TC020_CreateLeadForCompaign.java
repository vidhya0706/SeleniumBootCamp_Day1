package sprint1.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC020_CreateLeadForCompaign extends BaseClass {

	@Test
	public  void runCreateLeadForCompaign() throws InterruptedException {
		
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
//6. Click Add Leads
		driver.findElement(By.xpath("//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']")).click();
//7. Click on New Lead
		driver.findElement(By.xpath("//a[@title='New Lead']")).click();
//8. Pick Salutation as 'Mr.'
//9. Enter first name as <your First Name>
//10. Enter last name as <your last name>
		driver.findElement(By.xpath("//a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[@title='Mrs.']")).click();
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Sri");
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Vidhya");
//11. Enter company as 'TestLeaf'
		driver.findElement(By.xpath("(//input[@class=' input'])[3]")).sendKeys("TestLeaf");
//12. Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		Thread.sleep(2000);
//13. Click Next
		
		WebElement element3 =driver.findElement(By.xpath("//div[@title='Add Leads']"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);	
		
		driver.findElement(By.xpath("//input[@title='Search Leads']")).sendKeys("Sri vidhya"+Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='slds-checkbox--faux'])[7]")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral button-brand uiButton--default uiButton--brand uiButton']")).click();
	  Thread.sleep(2000);
//14. Click Submit on the Add to Campaign pop up
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral button-brand uiButton--default uiButton--brand uiButton']")).click();
//15. verify the created Lead under Campaign
		driver.findElement(By.xpath("(//span[@class='view-all-label'])[2]")).click();
		String text = driver.findElement(By.xpath("(//table)[3]/tbody/tr/td[4]")).getText();
		if(text.contains("Sri Vidhya"))
		{
			System.out.println("Lead is created under compaign");
		}
		else
		{
			System.out.println("Lead is not created under compaign");
		}
		
//16. Navigate to Leads tab
//17. Search for Lead with your Name
		
		WebElement element4 =driver.findElement(By.xpath("//span[text()='Leads']"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", element4);	
		
		driver.findElement(By.xpath("//input[@name='Lead-search-input']")).sendKeys("Sri Vidhya"+Keys.ENTER);
		String text1 = driver.findElement(By.xpath("//table/tbody/tr/th")).getText();
	   if(text1.contains("Sri Vidhya"))
	   {
			System.out.println("Lead is created under Leads Tab");
		}
		else
		{
			System.out.println("Lead is not created under Leads Tab");
		}
		

			//Expected Result:
			//Lead should be created in Leads tab and associated to Campaign

	}

}
