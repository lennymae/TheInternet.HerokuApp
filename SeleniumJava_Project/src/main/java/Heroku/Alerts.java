//Package
package main.java.Heroku;
//Frameworks
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
//Inherited Classes
import main.java.utils.BaseClass;

public class Alerts extends BaseClass{
	//Variables
	private String url = "https://the-internet.herokuapp.com";
	private String alertPromptValue = "Test123";
	private String successAlertMessage = "You successfully clicked an alert";
	private String confirmOkMessage = "You clicked: Ok";
	private String confirmCancelMessage = "You clicked: Cancel";
	private String result;
	
		//Test JS Alert
		@Test
		public void clickJSAlertPrompt() 
		{	
		    //Access url
		    OpenSite(url);
		    //Click Alerts link
		    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[29]/a")).click();
		    //Click JS Alert button
		    driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[1]/button")).click();
		    //Click OK in the alert prompt
		    driver.switchTo().alert().accept();
		    //Validate result message
		    result = driver.findElement(By.xpath("//*[@id=\'result\']")).getText();
		    Assert.assertTrue(result.contains(successAlertMessage));
		    closeBrowser();
		}
	
	    //Test JS Confirm prompt 
		@Test
		public void clickJSConfirmPrompt() 
		{	
			//Access url
			OpenSite(url);
		    //Click Alerts link
		    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[29]/a")).click();
		    //Click JS Confirm button
		    driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[2]/button")).click();
		    //Click OK in the alert prompt
		    driver.switchTo().alert().accept();
		    //Validate success message
		    String result = driver.findElement(By.xpath("//*[@id=\'result\']")).getText();
		    Assert.assertTrue(result.contains(confirmOkMessage));
		    //Click JS Confirm button
		    driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[2]/button")).click();
		    //Click Cancel in the alert prompt
		    driver.switchTo().alert().dismiss();
		    //Validate result message
		    result = driver.findElement(By.xpath("//*[@id=\'result\']")).getText();
		    Assert.assertTrue(result.contains(confirmCancelMessage));
		    closeBrowser();
		}
		
		//Test JS Prompt
		@Test
		public void clickJSPrompt() 
		{	
			//Access url
			OpenSite(url);
		    //Click Alerts link
		    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[29]/a")).click();
		    //Click JS Prompt button
		    driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[3]/button")).click();
		    //Enter value and click OK in the alert prompt
		    driver.switchTo().alert().sendKeys(alertPromptValue);
		    driver.switchTo().alert().accept();
		    //Validate result message
		    result = driver.findElement(By.xpath("//*[@id=\'result\']")).getText();
		    Assert.assertTrue(result.contains("You entered: " + alertPromptValue));
		    closeBrowser();
		}
	
}