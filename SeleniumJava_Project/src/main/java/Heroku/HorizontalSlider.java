//Package
package main.java.Heroku;
//Frameworks
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
//Inherited Classes
import main.java.utils.BaseClass;

public class HorizontalSlider extends BaseClass{
	//Variables
	private String url = "https://the-internet.herokuapp.com/horizontal_slider";
	
		//Drag element
		@Test
		public void dragAndDropSlider() 
		{	
			OpenSite(url);
		    //Click slider
		    WebElement sourceElement = driver.findElement(By.xpath("//*[@id=\'content\']/div/div/input"));
	        // Create an Actions object
	        Actions actions = new Actions(driver);
	        // Perform the drag-and-drop action by specifying the x and y offsets
	        actions.dragAndDropBy(sourceElement, 50, 0).build().perform();
	        //Validate that slider has moved
	        Assert.assertTrue((driver.findElement(By.xpath("//*[@id=\'range\']")).getAttribute("innerText")).contains("4.5"));
	        closeBrowser();
		}
}