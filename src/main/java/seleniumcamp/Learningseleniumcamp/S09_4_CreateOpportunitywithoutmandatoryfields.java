package seleniumcamp.Learningseleniumcamp;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class S09_4_CreateOpportunitywithoutmandatoryfields {
	
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
		
	}
    @Test
	public void CreateOpportunity() throws InterruptedException {
	
	
	
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	driver.findElement(By.id("password")).sendKeys("Leaf@1234");
	driver.findElement(By.id("Login")).click();
	
	//2. Click on toggle menu button from the left corner
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.findElement(By.xpath("//div[@role='navigation']//button")).click();
	
	//3. Click view All and click Sales from App Launcher
	WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	//4. Click on Opportunity tab
	
	/*
	 * WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(50));
	 * wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//span[text()='Opportunities']")));
	 */
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  WebElement vh=driver.findElement(By.xpath("//a[@title=\"Opportunities\"]"));
	  System.out.println("hi");
	  Actions sd = new Actions(driver);
	  sd.moveToElement(vh).build().perform();
	  Thread.sleep(1000);
	System.out.println("clicked opp");
	
	  WebElement vh1=driver.findElement(By.xpath("//a[@title=\"Opportunities\"]"));
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();",vh1);
		 
		  System.out.println("clicked opp1");
	
	
		
		  //5. Click on New button
	 
		  driver.findElement(By.xpath("//div[text()='New']")).click(); 
			
			  //6. Choose Close date as Tomorrow Date
			  driver.findElement(By.xpath("//input[@name=\"CloseDate\"]")).click();
			  driver.findElement(By.xpath("//span[text()='26']")).click();
			  
			  //7. Click on save
			  driver.findElement(By.xpath("//button[text()='Save']")).click();
			  
			  //8. Verify the Alert message (Complete this field) displayed for Name and
			  //Stage
			  String alertmessage = "";
			  List<WebElement> errormsg=driver.findElements(By.xpath("//ul[contains(@class,'errorsList ')]/li"));
			  for(int i=0;i<errormsg.size();i++) 
			    { 
				   String alertm=errormsg.get(i).getText();
				   alertmessage=alertmessage+" "+alertm;
				  }
			  
			System.out.println(alertmessage); 
		}
	
	

}
