package LoggedInTests;

import Pages.CartPage;
import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CartPageTests extends BaseTests {
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


    @Test
    public void ValidateThatItemsExistInCart() throws InterruptedException {
        homePage.HoverOnSuperMarket();
        homePage.clickBakeryBtn();
        String Item1Bakery = bakeryPage.GetItem1Name();
        String Item2Bakery = bakeryPage.GetItem2Name();
        bakeryPage.AddItemsToCart();
        bakeryPage.clickCartBtn();
        String Item1Cart = cartPage.GetItem1Name();
        String Item2Cart = cartPage.GetItem2Name();
        Assert.assertEquals(Item1Bakery, Item1Cart);
        Assert.assertEquals(Item2Bakery, Item2Cart);
    }

    @Test
    public void ValidateThatSubtotalIsCalculatedCorrectly() throws InterruptedException {
        homePage.HoverOnSuperMarket();
        homePage.clickBakeryBtn();
        bakeryPage.AddItemsToCart();
        Integer ExpectedTotalPrice = bakeryPage.GetItem1Price() + bakeryPage.GetItem2Price();
        bakeryPage.clickCartBtn();
        Integer ActualTotalPrice = cartPage.GetSubtotal();
        Assert.assertEquals(ExpectedTotalPrice, ActualTotalPrice);
    }

    @AfterMethod
    public void RemoveItemsFromCart() throws InterruptedException {
        cartPage.ClickRemoveItem1Btn();
        cartPage.ClickConfirmRemoveItemBtn();
        cartPage.ClickRemoveLastItemBtn();
        cartPage.ClickConfirmRemoveItemBtn();
        Assert.assertEquals(cartPage.GetCartIsEmptyText(), "Your cart is empty!");
    }
}
