package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BakeryPage {

    private WebDriver driver;
    private By BakeryPageTitle = By.xpath("//*[@id='jm']/main/div[2]/div[3]/section/header/div[1]/h1");
    private By Item1 = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[1]/a/div[1]/img");
    private By Item1Name = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[1]/a/div[2]/h3");
    private By Item1AddToCart = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[1]/footer/form/button");
    private By Item1Price = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[1]/a/div[2]/div[1]");
    private By Item1Minus = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[1]/footer/form/button[1]");
    private By Item2 = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[2]/a/div[1]/img");
    private By Item2Name = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[2]/a/div[2]/h3");
    private By Item2AddToCart = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[2]/footer/form/button");
    private By Item2Price = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[2]/a/div[2]/div[1]");
    private By Item2Minus = By.xpath("//*[@id=\'jm\']/main/div[2]/div[3]/section/div[1]/article[2]/footer/form/button[1]");
    private By NotificationBanner = By.xpath("//*[@id=\'jm\']/aside/div/div");
    private By CloseNotBannerBtn = By.xpath("//*[@id=\'jm\']/article/div/button");
    private By CartBtn = By.linkText("Cart");

    public BakeryPage(WebDriver driver){
        this.driver = driver;
    }

    public String GetBakeryPageTitle(){
        return driver.findElement(BakeryPageTitle).getText();
    }

    public void AddItemsToCart(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Item1));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        //Add Item1 To Cart
        WebElement item1 = driver.findElement(Item1);
        js.executeScript("arguments[0].scrollIntoView();", item1);
        actions.moveToElement(item1).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(Item1AddToCart)).click();


        //Add Item2 To Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotificationBanner));
        WebElement item2 = driver.findElement(Item2);
        js.executeScript("arguments[0].scrollIntoView();", item2);
        actions.moveToElement(item2).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(Item2AddToCart)).click();
    }

    public String GetNotificationBannerText(){
        return driver.findElement(NotificationBanner).getText();
    }

    public String GetItem1Name(){
        return driver.findElement(Item1Name).getText();
    }

    public String GetItem2Name(){
        return driver.findElement(Item2Name).getText();
    }

    public CartPage clickCartBtn() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(NotificationBanner));
        driver.findElement(CartBtn).click();
        return new CartPage(driver);
    }

    public Integer GetItem1Price(){
        String PriceText = driver.findElement(Item1Price).getText();
        String Price = PriceText.substring(4,PriceText.length()-3);
        return Integer.parseInt(Price);
    }

    public Integer GetItem2Price(){
        String PriceText = driver.findElement(Item2Price).getText();
        String Price = PriceText.substring(4,PriceText.length()-3);
        return Integer.parseInt(Price);
    }

    public void RevertBackAddedItems() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(Item1Minus).click();

        Thread.sleep(1000);
        driver.findElement(Item2Minus).click();
    }

    public CartPage returnCartPage(){
        return new CartPage(driver);
    }
}
