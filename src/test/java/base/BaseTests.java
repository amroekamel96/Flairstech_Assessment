package base;

import Pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected SignInPage signinPage;
    protected CreateAccountPage createAccountPage;
    protected PersonalDetailsPage personalDetailsPage;
    protected BakeryPage bakeryPage;
    protected CartPage cartPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jumia.com.eg/");
        homePage = new HomePage(driver);
        homePage.clickCloseButton();

        signinPage = new SignInPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        personalDetailsPage = new PersonalDetailsPage(driver);
        bakeryPage = new BakeryPage(driver);
        cartPage = new CartPage(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.jumia.com.eg/");


    }

//    @AfterClass
//    public void TearDown(){
//        driver.quit();
//    }
}
