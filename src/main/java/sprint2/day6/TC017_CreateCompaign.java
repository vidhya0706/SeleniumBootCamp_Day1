package sprint2.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC017_CreateCompaign extends BaseClass {

	@Test
	public void runCreateCompaign() throws InterruptedException {
	
		
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
//4. Click on Campaigns tab 
		WebElement element2 =driver.findElement(By.xpath("//span[text()='Campaigns']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
//5. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
//6. Enter Campaign name as 'Bootcamp',Get the text and Store it 
		WebElement comname= driver.findElement(By.xpath("//input[@class=' input']"));
		comname.sendKeys("BootCamp");
		String name = comname.getText();
		System.out.println(name);
		
//7. Choose Start date as Tomorrow
		driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']")).click();
		driver.findElement(By.xpath("//span[text()='26']")).click();
//8. End date as Tomorrow+1
		driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='27']")).click();
		
//9. click Save and Verify the newly created Campaign  
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

//Expected Result:
//New Campaign should be created with name as 'Bootcamp'
		String text = driver.findElement(By.xpath("//div[text()='Campaign']/following::div[@title='BootCampView Campaign Hierarchy']")).getText();
	    System.out.println(text);
	    if(text.contains("BootCamp")) {
	    	System .out.println("Compaign is created successfully");
	    }
	    else {
	    	System.out.println("Compaign is not created");
	    }
	}

}
