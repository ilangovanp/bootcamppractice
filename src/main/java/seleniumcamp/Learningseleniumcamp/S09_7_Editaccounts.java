package seleniumcamp.Learningseleniumcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class S09_7_Editaccounts {
	
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
	public void editacc() throws InterruptedException {
		
	
		
		//2) Click Login
        //3) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		
		//4) Click on the App Laucher Icon left to Setup
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//div[@role='navigation']//button")).click();
		
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//click on accounts
		
		WebDriverWait  wait2 = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Accounts']")));
		WebElement ab = driver.findElement(By.xpath("//a[@title='Accounts']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ab);
		//6) Search for the Account Using the unique account name created by you
		driver.findElement(By.xpath("//input[@type=\"search\" and @placeholder=\"Search this list...\"]")).sendKeys("Ilangovan P",Keys.ENTER);
		
	//7) Click on the displayed Account Dropdown icon and select Edit
		//WebElement dp=driver.findElement(By.xpath("//span[text()='Show Actions']/parent::span"));
		/*
		 * Actions a = new Actions(driver); a.moveToElement(dp).build().perform();
		 */
		
		/*
		 * Actions action = new Actions(driver);
		 * action.moveByOffset(0,0).click().build().perform();
		 */
		
			
		/*
		 * WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(20));
		 * wait3.until(ExpectedConditions.refreshed(ExpectedConditions.
		 * presenceOfElementLocated(By.
		 * xpath("//span[text()='Show Actions']/parent::span"))));
		 */
			 
		

		//driver.findElement(By.xpath("(//span[text()='Show Actions']/parent::span)[1]")).click();
		driver.findElement(By.xpath("//span[text()='Show more actions']/parent::span")).click();
		driver.findElement(By.xpath("//a[@title=\"Edit\"]")).click();
		Thread.sleep(1000);

		 
		
		//8) Select Type as Technology Partner 
		driver.findElement(By.xpath("//label[text()='Type']//following-sibling::div")).click();
		driver.findElement(By.xpath("//span[@title=\"Technology Partner\"]")).click();
		
		Thread.sleep(1000);
		//9) Select Industry as Healthcare
		driver.findElement(By.xpath("//label[text()='Industry']//following-sibling::div")).click();
		driver.findElement(By.xpath("//span[@title=\"Healthcare\"][text()='Healthcare']")).click();
		
        //10)Enter Billing Address
		driver.findElement(By.xpath("(//textarea[@autocomplete=\"street-address\" and @name=\"street\"])[1]"))
		.sendKeys("No.,34, Laststreet, Billing address");
		//11)Enter Shipping Address
		driver.findElement(By.xpath("(//textarea[@autocomplete=\"street-address\" and @name=\"street\"])[2]"))
		.sendKeys("No.,54, Midstreet, Shipping address");
		
		//12)Select Customer Priority as Low
		driver.findElement(By.xpath("//button[contains(@aria-label,\"Customer Priority\")]")).click();
		driver.findElement(By.xpath("//span[@title=\"Low\"]")).click();
		//13)Select SLA as Silver 17)Click on save and verfiy Phone number 
		driver.findElement(By.xpath("//label[text()='SLA']//following::div[1]")).click();
		driver.findElement(By.xpath("//span[@title=\"Silver\"]")).click();
		
		//14) Select Active as NO
         driver.findElement(By.xpath("//button[contains(@aria-label,\"Active\")]")).click();
		driver.findElement(By.xpath("(//span[@title=\"No\"])[2]")).click();
		
		//15) Enter Unique Number in Phone Field
		driver.findElement(By.xpath("//input[@name=\"Phone\"]")).sendKeys("1234567890");
	
		//16)Select Upsell Oppurtunity as No
		driver.findElement(By.xpath("//button[contains(@aria-label,\"Upsell Opportunity\")]")).click();
		driver.findElement(By.xpath("//span[@title=\"No\"]")).click();
		//input[@name="Phone"]
		
		
		//17)Click on save and verfiy Phone number 
		//button[@name="SaveEdit"]
		driver.findElement(By.xpath("//button[@name=\"SaveEdit\"]")).click();
		
		//Expected Result:The Account is Edited Successfully
		String editaccountmessage=driver.findElement(By.xpath("//span[contains(@class,\"toastMessage\")]")).getText();
		System.out.println(editaccountmessage);
		
		if(editaccountmessage.equalsIgnoreCase("Account \"Ilangovan\" was saved")) {
			System.out.println("expected result is verified");
		}else {
			System.out.println("failed");
		}
					
		
	}
	/*
	 * @AfterTest public void teardown() {
	 * 
	 * driver.quit(); }
	 */
	
	

}
