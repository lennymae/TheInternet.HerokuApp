//Package
package TestScripts;
//Frameworks
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
//Inherited Classes
import Base.BaseClass;

public class FormAuthentication extends BaseClass{
	//Variables
	private String url = "https://the-internet.herokuapp.com";
	private String correctUsername = "tomsmith";
	private String correctPass = "SuperSecretPassword!";
	private String incorrectPass = "pass";
	private String successMessage = "You logged into a secure area!";
	private String errorMessage = "Your password is invalid!";
	
	//Login using correct credentials
	@Test
	public void loginCorrectCredentials() 
	{	
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    //Access url
	    driver.get(url);
	    //Click Form Authentication link
	    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[21]/a")).click();
	    //Enter username and password
	    driver.findElement(By.xpath("//*[@id='username']")).sendKeys(correctUsername);
	    driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys(correctPass);
	    //Click Sign In
	    driver.findElement(By.xpath("//*[@id=\'login\']/button/i")).click();
	    //Validate that login is successful and Secure Area page is displayed
	    String loginMessage = driver.findElement(By.xpath("//*[@id='flash']")).getAttribute("innerText");
	    Assert.assertTrue((loginMessage.contains(successMessage)));
	    //Click logout
	    driver.findElement(By.xpath("//*[@id=\'content\']/div/a")).click();
	    BaseClass.closeBrowser(driver);
	}
	
	//Login using incorrect pass
	@Test
	public void loginIncorrectPassword() 
	{	
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    //Access url
	    driver.get(url);
	    //Click Form Authentication link
	    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[21]/a")).click();
	    //Enter username and password
	    driver.findElement(By.xpath("//*[@id='username']")).sendKeys(correctUsername);
	    driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys(incorrectPass);
	    //Click Sign In
	    driver.findElement(By.xpath("//*[@id=\'login\']/button/i")).click();
	    //Validate that login is failed and error message is displayed
	    String loginMessage = driver.findElement(By.xpath("//*[@id=\'flash\']")).getAttribute("innerText");
	    Assert.assertTrue((loginMessage.contains(errorMessage)));
	    BaseClass.closeBrowser(driver);
	}
	
}