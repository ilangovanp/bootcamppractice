package excelpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelHandle {
	WebDriver driver;
   @BeforeTest
   public void browseropening() {
	   WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();  
	   
   }
	
	
	@Test(dataProvider="datasendingmethod" ,dataProviderClass=excelpractice.DifferentExcelFileHandling.class)
	public  void excelread(String[] data) {
		
		

		driver.findElement(By.id("username")).sendKeys(data[0]);
		driver.findElement(By.id("password")).sendKeys(data[1]);
		driver.findElement(By.id("Login")).click();	
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	
		
	}
	
	
	

}
