package sprint2.day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sprint1.day1.BaseClass;

public class TC018_EditCompaign extends BaseClass{

	public  void runEditCompaign() throws InterruptedException {
		
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
		Thread.sleep(2000);
//4. Click on  Campaigns tab  
		WebElement element2 =driver.findElement(By.xpath("//span[text()='Campaigns']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
//5. Click Bootcamp link
		//driver.findElement(By.xpath("//a[@title='BootCamp']")).click();
//6. Click on Details tab
		
        //driver.findElement(By.xpath("//div[@class='uiPopupTrigger']//a")).click();
        //driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement element3 = driver.findElement(By.xpath("//tbody/tr/td[10]//a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(2000);
//7. Change the End Date as Today+4
    	driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]")).click();
		driver.findElement(By.xpath("(//span[text()='29'])[2]")).click();
//8. Update the Expected Revenue as 1000000
//9. Update the Budget Cost in Campaign as 100000
		driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber']")).sendKeys("1000000");
		driver.findElement(By.xpath("(//input[@class='input uiInputSmartNumber'])[2]")).sendKeys("100000");
//10. Click on Save and verify the updated values
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toast')]")));
			String toastText = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
			System.out.println("Toast message is : " + toastText);
//Expexted Result:
//The Compaign should be edited successfully.
			if(toastText.contains("Bootcamp"))
			{
				System.out.println("Edited successfully");
			}
			else {
				System.out.println("Not edited successfully");
			}
		

	}

}
