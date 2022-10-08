package sprint1.day3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;
import sprint1.day1.RetryFailedTests;

public class TC011_VerifyIndividualSortByName extends BaseClass {

	@Test(retryAnalyzer =RetryFailedTests.class)
	public  void runVerifyIndividualSortByName() throws InterruptedException {
	
//2. Click on the toggle menu button from the left corner
		WebElement element = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//3. Click View All and click Individuals from App Launcher
//4. Click on the Individuals tab 
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");
		Thread.sleep(2000);
		
		WebElement element1 =driver.findElement(By.xpath("//p[@class='slds-truncate']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);	
		Thread.sleep(200);
//5. Click the sort arrow in the Name
		
		List<WebElement> rowCount =driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
		  int size = rowCount.size();
		  Thread.sleep(200);
		  System.out.println(size);
		  List<String> namelist= new ArrayList<String>();
		  
		  for(int i=1;i<=size;i++) {
			  String name = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+i+"]/th")).getText();
			  namelist.add(name);
		  }
		  Collections.sort(namelist);
		  System.out.println(namelist);
		  
		  Thread.sleep(2000);
		  
		WebElement element2 = driver.findElement(By.xpath("//span[@title='Name']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);	
//6. Verify the Individuals displayed in ascending order by Name.
		
	  List<WebElement> rowCount1 =driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
	  int size1 = rowCount1.size();
	  Thread.sleep(2000);

	
	  System.out.println(size1);
	  List<String> namelist1= new ArrayList<String>();
	  
	  for(int i=1;i<=size1;i++) {
		  String name1 = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr["+i+"]/th")).getText();
		  namelist1.add(name1);
	  }
	 
	  System.out.println(namelist1);
	 
	//Expected Result:
	//Individual Should be displayed in ascending order by 
	  
	  if(namelist1==namelist) {
		  System.out.println("Individuals displayed in ascending order by Name");
	  }
		  else
		  {
			  System.out.println("Individuals Not displayed in ascending order by Name");
		  }
	  
	  }
                  
	}


