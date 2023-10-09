package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload extends BaseClass{
	private static String url = "https://the-internet.herokuapp.com/";
	private static String fileName = "C:\\Users\\lrogero\\Downloads\\btn_AddNewSheet.png";
		  @Test
		  public void fileUpload(){
			    //Access URL 
				WebDriverManager.chromedriver().setup();
			    ChromeDriver driver = new ChromeDriver();    
			    driver.get(url);
			    //Click link to File upload page
			    driver.findElement(By.xpath("//*[@id=\'content\']/ul/li[18]/a")).click();
			    //Click Choose File button
			    WebElement uploadPhotoBtn = driver.findElement(By.xpath("//input[@id=\'file-upload\']"));
			    uploadPhotoBtn.sendKeys(fileName);
			    driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();
			    //Validate that upload is successful
			    String uploadSuccessMsg = driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText();
			    Assert.assertTrue((fileName.contains(uploadSuccessMsg)));
			    System.out.println("File has been uploaded successfully");
				BaseClass.closeBrowser(driver);
		  }
}
