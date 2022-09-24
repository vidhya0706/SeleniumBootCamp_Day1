package sprint1.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC004_CreateAccount extends BaseClass {

	@Test
	public  void runCreateAccount() throws InterruptedException {
		
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
			
//4. Click on Accounts tab 
		WebElement element2=driver.findElement(By.xpath("//span[text()='Accounts']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);
		
//5. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
			
//6. Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Srividhya");
			
//7. Select Ownership as Public  
		WebElement element3=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		
		
		driver.findElement(By.xpath("//span[text()='Public']")).click();
//8. Click save and verify Account name 
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
			//Expected Result:
			//Account shoul be created Successfully
		String Account= driver.findElement(By.xpath("//div[@class='testonly-outputNameWithHierarchyIcon slds-grid sfaOutputNameWithHierarchyIcon']//lightning-formatted-text")).getText();
		System.out.println(Account);
		 
		 if(Account.contains("Srividhya"))
		  {
			System.out.println("Account is created");  
		  }
		  else {
			  System.out.println("Account is not created");
		  }
		
			}
		  
		
	}

