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
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S09_42_VerifyWorkType {

	public static void main(String[] args) {
		

//1) Launch the app
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://qeagle-dev-ed.lightning.force.com/lightning/page/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//2) Click Login
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
		a.scrollToElement(worktype).build().perform();
		driver.findElement(By.xpath("//p[text()='Work Types']")).click();
	
	
		
//7) Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();

//8) Enter Work Type Name as 'Bootcamp'
		driver.findElement(By.xpath("(//span[text()='Work Type Name']//following-sibling::span//following::input)[1]"))
		.sendKeys("Bootcamp");	
		
//9) Click on Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
//Expected Result:"Complete this field." alert message should be displayed for Estimated Duration
		

		String errormsg=driver.findElement(By.xpath("//*[@class=\"errorsList\"]/li")).getText();
		if(errormsg.equalsIgnoreCase("These required fields must be completed: Estimated Duration")) {
			System.out.println("Expected Result verified");
		}else {
			System.out.println("Expected Result failed");
		}
			
		

	}

}
