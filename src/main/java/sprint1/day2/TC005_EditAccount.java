package sprint1.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sprint1.day1.BaseClass;

public class TC005_EditAccount extends BaseClass {
	
	@BeforeTest
	public void setdata() {
		 excelfilename= "./data/editAccount.xlsx";
	}
	
	@Test(dataProvider="sendData")
	public  void runEditAccount(String name,String shipaddress,String billingaddress,String phno) throws InterruptedException {
		
//4) Click on the App Laucher Icon left to Setup
		WebElement element = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales");
		Thread.sleep(2000);
		
		WebElement element1 =driver.findElement(By.xpath("(//p[@class='al-app-tile-description'])[3]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);	
		
		WebElement element2=driver.findElement(By.xpath("//span[text()='Accounts']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);
//6) Search for the Account Using the unique account name created by you 
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(name +Keys.ENTER);
		Thread.sleep(2000);
//7) Click on the displayed Account Dropdown icon and select Edit
		WebElement element3 = driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", element3);
		
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
//8) Select Type as Technology Partner
		WebElement element4=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", element4);
		
		driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
//9) Select Industry as Healthcare 
		WebElement element5=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]"));
		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
		executor5.executeScript("arguments[0].click();", element5);
		
		WebElement element6=driver.findElement(By.xpath("//span[text()='Healthcare']"));
		JavascriptExecutor executor6 = (JavascriptExecutor)driver;
		executor6.executeScript("arguments[0].click();", element6);
//10)Enter Billing Address
		driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys(billingaddress);
//11)Enter Shipping Address
		driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys(shipaddress);
//12)Select Customer Priority as Low
		WebElement element7=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[5]"));
		JavascriptExecutor executor7 = (JavascriptExecutor)driver;
		executor7.executeScript("arguments[0].click();", element7);
		
		driver.findElement(By.xpath("//span[text()='Low']")).click();
//13)Select SLA as Silver
		WebElement element8=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[6]"));
		JavascriptExecutor executor8= (JavascriptExecutor)driver;
		executor8.executeScript("arguments[0].click();", element8);
		
		driver.findElement(By.xpath("//span[text()='Silver']")).click();
//14) Select Active as NO 
		WebElement element9=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[8]"));
		JavascriptExecutor executor9= (JavascriptExecutor)driver;
		executor9.executeScript("arguments[0].click();", element9);
		
		driver.findElement(By.xpath("//span[text()='No']")).click();
		
//15) Enter Unique Number in Phone Field
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys(phno);
//16)Select Upsell Oppurtunity as No
		WebElement element10=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[7]"));
		JavascriptExecutor executor10= (JavascriptExecutor)driver;
		executor10.executeScript("arguments[0].click();", element10);
		
		driver.findElement(By.xpath("//span[text()='No']")).click();
		
//17)Click on save and verfiy Phone number
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		boolean phoneno = driver.findElement(By.xpath("//span[@class='forceOutputPhone slds-truncate']")).isEnabled();
		System.out.println(phoneno);
//Expected Result:
//The Account is Edited Successfully
		if(phoneno=true)
		  {
			System.out.println("Account is Edited");  
		  }
		  else {
			  System.out.println("Account is not edited");
		  }
		
	
	}

}
