package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By closeButton = By.xpath("//*[@id=\'pop\']/div/section/button");
    private By accountButton = By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label");
    private By signInButton = By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/div/div/div/a");
    private By supermarketBtn = By.xpath("//*[@id=\'jm\']/main/div[1]/div[1]/div[1]/div/a[1]/span");
    private By bakeryBtn = By.linkText("Bakery");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SignInPage clickSignInButton(){
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

    public BakeryPage clickBakeryBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(bakeryBtn)).click();
        return new BakeryPage(driver);
    }
    public void clickCloseButton(){
        driver.findElement(closeButton).click();
    }

    public void clickAccountButton(){
        driver.findElement(accountButton).click();
    }

    public String getAccountText(){
        return driver.findElement(accountButton).getText();
    }

    public void HoverOnSuperMarket(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(supermarketBtn));
        Actions actions = new Actions(driver);
        WebElement Btn = driver.findElement(supermarketBtn);
        actions.moveToElement(Btn).build().perform();
    }
}
