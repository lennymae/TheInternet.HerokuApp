package main.java.Parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import main.java.utils.BaseClass;
import main.java.utils.DataManipulation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserCreation extends BaseClass {
    private static String url = "https://parabank.parasoft.com/parabank/index.htm";
    XSSFWorkbook workBook;
    XSSFSheet sheet;
    String filepath = "resources/ParaBank/UserProfile.xlsx";

    // By locators
    private By registerLink = By.xpath("//a[contains(text(),'Register')]");
    private By firstNameTextbox = By.xpath("//input[@id='customer.firstName']");
    private By lastNameTextbox = By.xpath("//input[@id='customer.lastName']");
    private By addressTextbox = By.xpath("//input[@id='customer.address.street']");
    private By cityTextbox = By.xpath("//input[@id='customer.address.city']");
    private By stateTextbox = By.xpath("//input[@id='customer.address.state']");
    private By zipCodeTextbox = By.xpath("//input[@id='customer.address.zipCode']");
    private By phoneNumberTextbox = By.xpath("//input[@id='customer.phoneNumber']");
    private By ssnTextbox = By.xpath("//input[@id='customer.ssn']");
    private By usernameTextbox = By.xpath("//input[@id='customer.username']");
    private By passwordTextbox = By.xpath("//input[@id='customer.password']");
    private By repeatedPasswordTextbox = By.xpath("//input[@id='repeatedPassword']");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By newElement = By.xpath("//p[contains(text(),\"Your account was created successfully. You are now logged in.\")]");

    @Test
    public void registerNewUser() {
        OpenSite(url);

        driver.findElement(registerLink).click();

        workBook = DataManipulation.getWorkbook(filepath);

        driver.findElement(firstNameTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 0));
        driver.findElement(lastNameTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 1));
        driver.findElement(addressTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 2));
        driver.findElement(cityTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 3));
        driver.findElement(stateTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 4));
        driver.findElement(zipCodeTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 5));
        driver.findElement(phoneNumberTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 6));
        driver.findElement(ssnTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 7));
        driver.findElement(usernameTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 8));
        driver.findElement(passwordTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 9));
        driver.findElement(repeatedPasswordTextbox).sendKeys(DataManipulation.getData(workBook, 0, 1, 9));

        driver.findElement(registerButton).click();

        if (driver.findElement(newElement).isDisplayed())
            System.out.println("User registered successfully.");

        closeBrowser();
    }
}