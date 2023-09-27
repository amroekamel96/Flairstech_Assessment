package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    private WebDriver driver;
    private By PasswordField = By.xpath("//*[@id=\'card_password\']/div[3]/label/input");
    private By ConfirmPasswordField = By.xpath("//*[@id=\'card_password\']/div[4]/label/input");
    private By ContinueRegistrationBtn = By.xpath("//*[@id=\'card_password\']/div[5]/div/button/span[3]");

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void setPassword(String Password){
        driver.findElement(PasswordField).sendKeys(Password);
    }

    public void ConfirmPassword(String Password){
        driver.findElement(ConfirmPasswordField).sendKeys(Password);
    }

    public PersonalDetailsPage clickContinueRegistrationBtn(){
        driver.findElement(ContinueRegistrationBtn).click();
        return new PersonalDetailsPage(driver);
    }
}
