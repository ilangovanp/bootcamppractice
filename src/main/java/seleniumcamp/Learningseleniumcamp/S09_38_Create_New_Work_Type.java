package seleniumcamp.Learningseleniumcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S09_38_Create_New_Work_Type {
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
	public void createnewworktype() {

//2)Click Login
//3) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		

//4) Click on the App Laucher Icon left to Setup
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//div[@role='navigation']//button")).click();
		
//5) Click on View All
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
//6) Click on Work Types
		WebElement worktype=driver.findElement(By.xpath("//p[text()='Work Types']"));
		Actions a = new Actions(driver);
		a.scrollToElement(worktype).perform();
		driver.findElement(By.xpath("//p[text()='Work Types']")).click();
//7) Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();
//8) Enter Work Type Name as 'Salesforce Project'
		driver.findElement(By.xpath("(//span[text()='Work Type Name']//following-sibling::span//following::input)[1]"))
		.sendKeys("Salesforce Project");
//9) Enter Description as 'Specimen'
	
		driver.findElement(By.xpath("//span[text()='Description']//following::textarea")).sendKeys("Specimen");
		
//10) Create new operating hours by Entering a name as 'UK Shift'
		//input[@title="Search Operating Hours"]
		driver.findElement(By.xpath("//input[@title=\"Search Operating Hours\"]")).sendKeys("UK Shift");
//11) Enter Estimated Duration as '7'
		//(//span[text()='Estimated Duration']//following-sibling::span//following::input)[1]
		driver.findElement(By.xpath("(//span[text()='Estimated Duration']//following-sibling::span//following::input)[1]")).sendKeys("7");
//12 Click on Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
//13 Verify the Created message 
		
		String createdmessage=driver.findElement(By.xpath("//span[@data-aura-class=\"forceActionsText\"]")).getText();
		System.out.println(createdmessage);
//Expected Result:The New Work Type should be created successfully
		if(createdmessage.equalsIgnoreCase("Work Type \"Salesforce Project\" was created.")) {
			System.out.println("Expected Result verified");	
		}else {
			System.out.println("failed");
		}
		
		}
	@AfterTest
	public void teardown() {
		
		driver.quit();
	}

}
