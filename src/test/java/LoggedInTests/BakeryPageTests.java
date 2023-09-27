package LoggedInTests;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class BakeryPageTests extends BaseTests {
    private WebDriver driver;
    String emailAddress = "tanada9020@armablog.com";
    String password = "P@ssw0rd@2023";
    String FirstName = "Amro";


    @BeforeClass
    public void Login(){
        homePage.clickAccountButton();
        homePage.clickSignInButton();
        signinPage.setEmail(emailAddress);
        signinPage.clickContinueButton();
        Assert.assertEquals(signinPage.getWelcomeBackMsg(), "Welcome back!");
        signinPage.setPassword(password);
        signinPage.clickLoginBtn();
        Assert.assertEquals(homePage.getAccountText(), "Hi, "+FirstName);
    }

    @Test (groups = "Bakery Page Tests", priority = 1)
    public void ValidateNavigatingToBakeryPageHappensCorrectly(){
        homePage.HoverOnSuperMarket();
        homePage.clickBakeryBtn();
        Assert.assertEquals(bakeryPage.GetBakeryPageTitle(), "Bakery");
    }

    @Test (groups = "Bakery Page Tests", priority = 2)
    public void ValidateThatItemsAreAddedToCart() throws InterruptedException {
        homePage.HoverOnSuperMarket();
        homePage.clickBakeryBtn();
        bakeryPage.AddItemsToCart();
        Assert.assertEquals(bakeryPage.GetNotificationBannerText(),"Product added successfully");
        bakeryPage.RevertBackAddedItems();
    }
}
