//Package
package main.java.Heroku;
//Frameworks
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.utils.BaseClass;

public class InputValidation extends BaseClass{
	//Variables
	private String url = "https://the-internet.herokuapp.com";
	private String enteredNumber = "3";
	
	//Login using correct credentials
	@Test
	public void validateInputValueNumber() 
	{	
		OpenSite(url);
	    //Click Input link
	    driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[27]/a")).click();
	    //Enter value in textbox
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys(enteredNumber);
	    String val = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).getAttribute("value");
	    //Validate that input is number
	    boolean isNumber = isNumeric(val);
        Assert.assertEquals(isNumber,true);
	    System.out.println("Value entered is numeric");
	    BaseClass.closeBrowser();
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
}