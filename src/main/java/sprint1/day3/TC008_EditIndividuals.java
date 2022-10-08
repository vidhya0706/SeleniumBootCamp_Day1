package sprint1.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;
import sprint1.day1.RetryFailedTests;

public class TC008_EditIndividuals extends BaseClass {

	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/editIndividuals.xlsx";
	}
@Test(dataProvider="sendData",retryAnalyzer =RetryFailedTests.class)
	public  void runEditIndividuals(String name,String fname) throws InterruptedException {


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
//5. Search the Individuals 'vidhya'
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(name  +Keys.ENTER);
		Thread.sleep(2000);
		

//6. Click on the Dropdown icon and Select Edit
        WebElement element2 = driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
		
        driver.findElement(By.xpath("//a[@title='Edit']")).click();

//7.Select Salutation as 'Mrs'
        
        WebElement drDown = driver.findElement(By.xpath("//a[@class='select']"));
        drDown.click();
        driver.findElement(By.xpath("//a[@title='Mrs.']")).click();
//8.Enter the first name as 'Sri'.
        driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys(fname);
//9. Click on Save and Verify the first name as 'sri'
        
       driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
      Thread.sleep(200);
      
       String text = driver.findElement(By.xpath("//tbody/tr[1]/th//a")).getText();
       
       System.out.println(text);
       if(text.contains(fname))
       {
    	   System.out.println("Edited successfully");
       }
       else
       {
    	   System.out.println("Not edited");
       }
     
}
}
