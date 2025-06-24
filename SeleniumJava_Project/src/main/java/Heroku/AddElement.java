//Packages
package main.java.Heroku;


//Frameworks
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.utils.BaseClass;

public class AddElement extends BaseClass{
	private static String url = "https://the-internet.herokuapp.com/";
	
	
	    @Test
		public void addElement(){
	    	//Open url in browser
			OpenSite(url);
		    //Click link to Add Element page
		    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[2]/a")).click();
		    driver.findElement(By.xpath("//*[@id=\'content\']/div/button")).click();
		    WebElement newElement = driver.findElement(By.xpath("//*[@id=\'elements\']/button"));
		    if(newElement.isDisplayed())
		    	System.out.println("New element is displayed");
		    BaseClass.closeBrowser();
			
		}
	    
	    @Test
		public void deleteElement(){
			//Open url in browser
			OpenSite(url);
		   //Add element to the page
		    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[2]/a")).click();
		    driver.findElement(By.xpath("//*[@id=\'content\']/div/button")).click();
		    driver.findElement(By.xpath("//*[@id=\'elements\']/button")).click();
		    BaseClass.assertElementNotPresent(driver,"//*[@id=\'elements\']/button");
		    BaseClass.closeBrowser();
		}
		
		
}



