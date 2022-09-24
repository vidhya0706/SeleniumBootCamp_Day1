package sprint1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC012_CreateWorkType extends BaseClass {
	
	@Test
	public  void runCreateWorkType() throws InterruptedException {
		
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
		
//8) Enter Work Type Name as 'Salesforce Project'
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Salesforce Project");
//9) Enter Description as 'Specimen'
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("Specimen");
//10) Create new operating hours by Entering a name as 'UK Shift'
		driver.findElement(By.xpath("//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")).sendKeys("UK Shift");
//11) Enter Estimated Duration as '7'
		driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber']")).sendKeys("7");
//12 Click on Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
//13 Verify the Created message 
		String text=driver.findElement(By.xpath("//div[text()='Work Type']/following::div")).getText();
		System.out.println(text);
		//Expexted Result:
		//The New Work Type should be created successfully 
		
		if(text.contains("Salesforce")) {
			System.out.println("New Work Type created successfully");
		}
			else
			{
		    System.out.println("New Work Type not created");	
			}
	
		}
	
}
