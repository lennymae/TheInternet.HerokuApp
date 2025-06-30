package main.java.Parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import main.java.utils.BaseClass;
import main.java.utils.DataManipulation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SubmitCustomerInquiry extends BaseClass {
    private static String url = "https://parabank.parasoft.com/parabank/index.htm";
    XSSFWorkbook workBook;
    XSSFSheet sheet;
    String filepath = "resources/ParaBank/CustomerInquiry.xlsx";

    // By locators
    private By customerInquiryButton = By.xpath("//a[contains(text(),\"contact\")]");
    private By custNameTextbox = By.xpath("//input[@id=\"name\"]");
    private By emailTextbox = By.xpath("//input[@id=\"email\"]");
    private By phoneNumberTextbox = By.xpath("//input[@id=\"phone\"]");
    private By messageTextbox = By.xpath("//textarea[@id=\"message\"]");
    private By submitInquiryButton = By.xpath("//input[@value=\"Send to Customer Care\"]");
    private By confirmationMessage = By.xpath("//p[contains(text(),\"A Customer Care Representative will be contacting you.\")]");

    @Test
    public void submitCustomerInquiry() {
        OpenSite(url);

        driver.findElement(customerInquiryButton).click();

        workBook = DataManipulation.getWorkbook(filepath);

        driver.findElement(custNameTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 0));
        driver.findElement(emailTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 1));
        driver.findElement(phoneNumberTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 2));
        driver.findElement(messageTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 3));
        driver.findElement(submitInquiryButton).click();


        if (driver.findElement(confirmationMessage).isDisplayed())
            System.out.println("Customer Inquiry submitted successfully.");

        closeBrowser();
    }
}