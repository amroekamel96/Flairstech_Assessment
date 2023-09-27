package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SignInPage {

    private WebDriver driver;
    private By EmailField =  By.id("input_identifierValue");
    private By ContinueButton = By.xpath("/html/body/div/div[4]/form/div/div[3]/div[2]/button/span[3]");
    private By PasswordField = By.name("password");
    private By WelcomeBackMsg = By.xpath("//*[@id=\'passwordForm\']/div/div[1]/h2");
    private By LoginBtn = By.xpath("//*[@id=\'loginButton\']/span[3]");


    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String Email){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailField));
        driver.findElement(EmailField).sendKeys(Email);
    }

    public CreateAccountPage clickContinueButton(){
        driver.findElement(ContinueButton).click();
        return new CreateAccountPage(driver);
    }

    public void setPassword(String Password){
        driver.findElement(PasswordField).sendKeys(Password);
    }

    public String getWelcomeBackMsg(){
        return driver.findElement(WelcomeBackMsg).getText();
    }

    public HomePage clickLoginBtn(){
        driver.findElement(LoginBtn).click();
        return new HomePage(driver);
    }

}
