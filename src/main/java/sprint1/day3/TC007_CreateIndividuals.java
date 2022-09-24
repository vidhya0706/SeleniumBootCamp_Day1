package sprint1.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC007_CreateIndividuals extends BaseClass {

	@Test
	public  void runCreateIndividuals() throws InterruptedException {
		
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
		Thread.sleep(200);
		
//4. Click on the Dropdown icon in the Individuals tab
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']")).click();
//5. Click on New Individual
		WebElement element2 = driver.findElement(By.xpath("//span[text()='New Individual']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
//6. Enter the Last Name as 'Vidhya'
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Vidhya");
		
//7.Click save and verify Individuals Name
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		boolean enabled = driver.findElement(By.xpath("(//div[text()='Individual']//following::div)[1]")).isEnabled();
		System.out.println(enabled);
		
		String text = driver.findElement(By.xpath("(//div[text()='Individual']//following::div)[1]")).getText();
		//System.out.println(text);
		
//Expected result:
//The Individuals is created Successfully
		if(text.contains("Vidhya"))
		{
			System.out.println("created Successfully");
		}
		else
		{
			System.out.println("Not created Successfully");	
		}
		
			
		
	}

}
