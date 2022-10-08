package sprint1.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002_EditOpportunity extends BaseClass {
	
	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/EditOpp.xlsx";
	}
	
	@Test(dataProvider="sendData",retryAnalyzer =RetryFailedTests.class)
	public  void runEditOpportunity(String description) throws InterruptedException {
			
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
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Salesforce Automation by Srividhya"+Keys.ENTER);
		Thread.sleep(2000);
		
		
//6. Click on the Dropdown icon and Select Edit
		
		WebElement element3 = driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		
//7. Choose close date as Tomorrow date
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		WebElement element4=driver.findElement(By.xpath("//button[@class='slds-button slds-align_absolute-center slds-text-link']"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", element4);
		
//8. Select 'Stage' as Perception Analysis
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='slds-media__body'])[7]")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
//9. Select Deliver Status as In Progress
		
		WebElement element6=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]"));
		JavascriptExecutor executor6 = (JavascriptExecutor)driver;
		executor6.executeScript("arguments[0].click();", element6);
		driver.findElement(By.xpath("//span[text()='In progress']")).click();
			
		//10. Enter Description as SalesForce
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(description);
		
		//11. Click on Save and Verify Stage as Perception Analysis
		
		WebElement element5=driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
		executor5.executeScript("arguments[0].click();", element5);
		
		//Expected Result:
		//The Oppurtunity is Edited Successfully
		String OppName= driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
		System.out.println(OppName);
		if(OppName.contains("Perception Analysis"))
		  {
			System.out.println("Opportunity is Edited");  
		  }
		  else {
			  System.out.println("Opportunity is not edited");
		  }
		
	}

}
