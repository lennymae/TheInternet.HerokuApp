//Packages
package main.java.Heroku;

//Frameworks
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;

//Inherited Classes
import main.java.utils.BaseClass;;

public class BrokenImage extends BaseClass{
	private String url = "https://the-internet.herokuapp.com/";
		
		@Test
		public void validateFirstImageIsBroken(){
			//Access url 
			OpenSite(url);
		    //Click link to Broken Images page
		    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[4]/a")).click();
		    //Validate if image is broken
			for (WebElement image : driver.findElements(By.cssSelector("#content > div > img:nth-child(2)")))
			{
			    BaseClass.isImageBroken(image);
			    System.out.println("Image is broken");
			}
			closeBrowser();
		}
		@Test
		public void validateThirdImageIsPlaceholder() {
			//Open browser
			OpenSite(url);
		    //Click link to Broken Images page
		    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[4]/a")).click();
		    //Get image element to validate
		    WebElement imageElement = driver.findElement(By.xpath("//*[@id=\'content\']/div/img[3]"));
		    String imageSrc = imageElement.getAttribute("src");
		    String placeholderImageUrl = "img/avatar-blank.jpg";
		    imageElement.click();
		    //Validate that image is a placeholder
			if (imageSrc.contains(placeholderImageUrl))
			{
			    System.out.println(imageSrc+" is a placeholder");
			}
			else {
				System.out.println(imageSrc+" is not a placeholder");
			}
			BaseClass.closeBrowser();
		}
	

}



