package newpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookMessage {
	
	public static void main(String[] args) {

		String email = "";
		String password = "";
		String message = "";
		int numOfMessages = 10;
		
		// Create driver object for Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Go to messenger.com and log in with username + password
		driver.get("http://messenger.com");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		
		// Go to specific user
		driver.get("https://www.messenger.com/t/[FIRST_NAME.LAST_NAME]");
		
		// Wait until input element is loaded and available
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@contenteditable='true']")));
		
		// Send messages to the user
		while (numOfMessages > 0) { 
			WebElement element = driver.findElement(By.xpath("//div[@contenteditable='true']"));
			element.click();
			element.sendKeys(message, Keys.ENTER);			
			numOfMessages-=1;
		}
		
		driver.quit();	
    }	
}
