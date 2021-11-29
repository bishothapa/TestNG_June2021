package homeWork5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework_Session5 {
	
	WebDriver driver;
 @BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
				 driver.manage().window().maximize();
				 driver.manage().deleteAllCookies();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 driver.get("https://techfios.com/billing/?ng=admin/");
	}

 @Test
    public void logintest() throws InterruptedException {
    	WebElement userNameElement = driver.findElement(By.xpath("//input[@id='username']"));
    	WebElement passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
    	WebElement loginButtonElement = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
    	 
    	userNameElement.sendKeys("demo@techfios.com");
		passwordElement.sendKeys("abc123");
		loginButtonElement.click();
 
	    WebElement customerElement = driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
	    customerElement.click();
	   
	    WebElement addCustomerElement = driver.findElement(By.xpath("//a[contains(text(),'Add Customer')]"));
    	addCustomerElement.click();
    	
    	WebElement contactsElement = driver.findElement(By.xpath("//h2[contains(text(),'Contacts')]"));
    	
    	String str = "Contacts";
    	Assert.assertEquals(contactsElement.getText(),str, "Contacts page not found");
    	
    	WebElement FullNameElements = driver.findElement(By.xpath("//input[@id='account']"));
    	FullNameElements.sendKeys("Thapa_kazi");
    	
    	WebElement companyElement = driver.findElement(By.xpath("//select[@id='cid']"));
    	
    	Select sel = new Select(companyElement);
    	sel.selectByVisibleText("Techfios");
    	
    	WebElement emailElement  = driver.findElement(By.xpath("//input[@id='email']"));
    	emailElement.sendKeys("Thapa_123@techfios.com");
    	
    	WebElement phoneElement = driver.findElement(By.xpath("//input[@id='phone']"));
    	phoneElement.sendKeys("987654321");
    	
    	WebElement addressElement  = driver.findElement(By.xpath("//input[@id='address']"));
    	addressElement.sendKeys("123 Techfios, carrolton , tx");
    	
    	WebElement CityElement  = driver.findElement(By.xpath("//input[@id='city']"));
    	CityElement.sendKeys("Keller");
    	
    	WebElement stateElement  = driver.findElement(By.xpath("//input[@id='state']"));
    	stateElement.sendKeys("Texas");
    	
    	WebElement zipCodeElement  = driver.findElement(By.xpath("//input[@id='zip']"));
    	zipCodeElement.sendKeys("76038");
    	
    	WebElement countryElement  = driver.findElement(By.xpath("//select[@name='country']"));
    	Select sel2 = new Select(countryElement);
    	sel2.selectByVisibleText("Afghanistan");
    	
    	WebElement tagsElement  = driver.findElement(By.xpath("//select[@id='tags']"));
    	Select sel3 = new Select(tagsElement);
    	sel3.selectByVisibleText("My tags");
    	
    	@SuppressWarnings("unused")
		WebElement saveButtonElement   = driver.findElement(By.xpath("//button[@id='submit']"));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);
    	
    	Thread.sleep(3000);
    	
    	
      
    } 
 
 @AfterMethod
 public void tearDown() {
	 
	 driver.close();
	 driver.quit();
 }
	

}
