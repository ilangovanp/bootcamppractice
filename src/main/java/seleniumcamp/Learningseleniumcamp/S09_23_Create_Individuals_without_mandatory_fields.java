package seleniumcamp.Learningseleniumcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Argument;

public class S09_23_Create_Individuals_without_mandatory_fields {
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
	public void individuals() throws InterruptedException {
//1. Login to https://login.salesforce.com
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
//2. Click on the toggle menu button from the left corner
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//div[@role='navigation']//button")).click();
//3. Click View All and click Individuals from App Launcher
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		

		
		WebElement individual=driver.findElement(By.xpath("//p[text()=\"Individuals\"]"));
		Actions a = new Actions(driver);
		a.scrollToElement(individual).build().perform();
		driver.findElement(By.xpath("//p[text()=\"Individuals\"]")).click();
//4. Click on the Dropdown icon in the Individuals tab
	
		driver.findElement(By.xpath("(//a[@title=\"Individuals\"]//following::one-app-nav-bar-menu-button)[1]")).click();
//5. Click on New Individual
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		WebElement nwi=driver.findElement(By.xpath("//span[text()='New Individual']"));
		Actions act = new Actions(driver);
		act.moveToElement(nwi).click().build().perform();
		System.out.println("moved");
		//WebElement nwiio=driver.findElement(By.xpath("//span[text()='New Individual']"));
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click;",nwi);
		//System.out.println("clicked");
		Thread.sleep(1000);
//7.Select Salutation as 'Mr'
		
		driver.findElement(By.xpath("//div[contains(@class,\"salutation\")]")).click();
		driver.findElement(By.xpath("//a[@title=\"Mr.\"]")).click();
		
//8.Enter the first name as 'Ganesh'.
	
		
		driver.findElement(By.xpath("//input[@placeholder=\"First Name\"][contains(@class,\"firstName\")]")).sendKeys("Ganesh");
		
//9. Click on Save
	
		driver.findElement(By.xpath("//button[@title=\"Save\"]")).click();
//10. Verify the Alert message (Complete this field) displayed for the Last Name
		
		String lastnameerrormsg = driver.findElement(By.xpath("//ul[@class=\"errorsList\"]/li")).getText();
		System.out.println(lastnameerrormsg);
//Expected Result:Complete this field message should be displayed for last Name field
		
		Assert.assertEquals(lastnameerrormsg, "These required fields must be completed: Last Name");
		
		
	}
	
	/*
	 * @AfterTest public void teardown() {
	 * 
	 * driver.quit(); }
	 */
	
	

}
