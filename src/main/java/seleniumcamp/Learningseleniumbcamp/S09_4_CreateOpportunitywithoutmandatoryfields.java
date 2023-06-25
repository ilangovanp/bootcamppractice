package seleniumcamp.Learningseleniumbcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S09_4_CreateOpportunitywithoutmandatoryfields {
	
	@Test
	
	
	public void createOpportunity() {
	
	
	WebDriverManager.chromedriver().setup();

	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	
	driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	driver.findElement(By.id("password")).sendKeys("Leaf@1234");
	driver.findElement(By.id("Login")).click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.findElement(By.xpath("//div[@role='navigation']/button")).click();
	WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	WebElement bn=driver.findElement(By.xpath("//span[text()='Opportunities']"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", bn);
	
	driver.findElement(By.xpath("//div[text()='New']")).click();
	
	
	////input[@name="CloseDate"]
	driver.findElement(By.xpath("//input[@name=\"CloseDate\"]")).click();
	
	driver.findElement(By.xpath("//span[text()='26']")).click();
	
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	
	String errormsg= driver.findElement(By.xpath("//div[@class=\"slds-popover__body\"]")).getText();
	System.out.println(errormsg);
	}
	
	

}
