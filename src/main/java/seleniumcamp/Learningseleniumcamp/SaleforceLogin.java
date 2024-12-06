package seleniumcamp.Learningseleniumcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaleforceLogin {
	public WebDriver driver;
	@BeforeTest
	public void browserinvoke() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		driver.get("https://qeagle-dev-ed.lightning.force.com/lightning/page/home");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		
	}
	

	
	
	@Test
	public void accountcreation() {
		// TODO Auto-generated method stub
		

		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//div[@role='navigation']/button")).click();
		
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement ab = driver.findElement(By.xpath("//a[@title='Accounts']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ab);

		driver.findElement(By.xpath("//a[@title='New']/div")).click();

		
		  //driver.findElement(By.xpath("//input[starts-with(@id,'input-')]")).sendKeys("Ilangovan");
		  
		  driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Ilangovan P");
		  
		 
		  
		  WebElement d=driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div"));
		  js.executeScript("arguments[0].scrollIntoView(true);", d);
		  driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")).click();
		  driver.findElement(By.xpath("//span[text()='Public']")).click();
		  driver.findElement(By.xpath("//button[text()='Save']")).click();
		  
		  ////div[@role="alertdialog"]//following-sibling::div//div/div/span
		 String av= driver.findElement(By.xpath("//div[@role=\"alertdialog\"]//following-sibling::div//div/div/span")).getText();
		 System.out.println(av);
		 
		 Assert.assertEquals(av, "Account \"Ilangovan\" was created");
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}
	}


