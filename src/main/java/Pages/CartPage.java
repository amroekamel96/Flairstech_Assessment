package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private By Item1Name = By.xpath("//*[@id=\'jm\']/main/div/div[1]/article/article[1]/a/div[2]/h3");
    private By Item2Name = By.xpath("//*[@id=\'jm\']/main/div/div[1]/article/article[2]/a/div[2]/h3");
    private By Subtotal = By.xpath("//*[@id=\'jm\']/main/div/div[2]/div/article/div[1]/p[2]");
    private By Item1RemoveBtn = By.xpath("//*[@id=\'jm\']/main/div/div[1]/article/article[1]/footer/button");
    private By LastItemRemoveBtn = By.xpath("//*[@id=\'jm\']/main/div/div[1]/article/article/footer/button");
    private By ConfirmRemoveItemBtn = By.xpath("//*[@id=\'pop\']/div/section/div/div/form[2]/button/span");
    private By CartIsEmpty = By.xpath("//*[@id=\'jm\']/main/div/div[1]/div/h2");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String GetItem1Name(){
        return driver.findElement(Item1Name).getText();
    }

    public String GetItem2Name(){
        return driver.findElement(Item2Name).getText();
    }

    public Integer GetSubtotal(){
        String PriceText = driver.findElement(Subtotal).getText();
        String Price = PriceText.substring(4,PriceText.length()-3);
        return Integer.parseInt(Price);
    }

    public void ClickRemoveItem1Btn(){
        driver.findElement(Item1RemoveBtn).click();
    }

    public void ClickRemoveLastItemBtn() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(LastItemRemoveBtn).click();
    }

    public void ClickConfirmRemoveItemBtn(){
        driver.findElement(ConfirmRemoveItemBtn).click();
    }

    public String GetCartIsEmptyText(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartIsEmpty));
        return driver.findElement(CartIsEmpty).getText();
    }
}
