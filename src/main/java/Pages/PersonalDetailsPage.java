package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalDetailsPage {

    private WebDriver driver;
    private By FirstNameField = By.id("input_first_name");
    private By LastNameField = By.id("input_last_name");
    private By PhoneNumField = By.xpath("//*[@id=\'card_profile_details\']/div[4]/div[2]/label/input");
    private By ContinueRegistrationBtn = By.xpath("//*[@id=\'card_profile_details\']/div[5]/div/button/span[3]");
    private By GenderDropdwn = By.xpath("//*[@id=\'gender\']/div[1]");
    private By MaleGender = By.xpath("//*[@id=\'gender\']/div[2]/ul/li[1]");
    private By BirthdateField = By.id("input_birth_date");
    private By DatePicker = By.xpath("//*[@id=\'card_profile_gender\']/div/div[2]/label");
    private By TermsAndConditionsCheckbox = By.id("acceptTC");
    private By ContinueRegistrationBtn2 = By.xpath("//*[@id=\"confirmBtn\"]/span[3]");

    private By SuccessfulRegistration = By.xpath("//*[@id=\'form_success\']/div/div/div[1]/h2");


    public PersonalDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String FirstName){
        driver.findElement(FirstNameField).sendKeys(FirstName);
    }

    public void setLastName(String LastName){
        driver.findElement(LastNameField).sendKeys(LastName);
    }

    public void setPhoneNum(String PhoneNum){
        driver.findElement(PhoneNumField).sendKeys(PhoneNum);
    }

    public void clickConfirmRegistrationBtn(){
        driver.findElement(ContinueRegistrationBtn).click();
    }

    public void openGenderDropdwn(){
        driver.findElement(GenderDropdwn).click();
    }

    public void selectMaleGender(){
        driver.findElement(MaleGender).click();
    }

    public void setBirthdate() throws InterruptedException {
        driver.findElement(BirthdateField).click();
        Thread.sleep(1000);
        driver.findElement(BirthdateField).sendKeys(
                Keys.NUMPAD1, Keys.NUMPAD4,
                Keys.NUMPAD0, Keys.NUMPAD4,
                Keys.NUMPAD1, Keys.NUMPAD9, Keys.NUMPAD9, Keys.NUMPAD6);
    }

    public void TickCheckbox(){
        driver.findElement(TermsAndConditionsCheckbox).click();
    }

    public void clickConfirmRegistrationBtn2(){
        driver.findElement(ContinueRegistrationBtn2).click();
    }

    public void GetPageTitle(){
        driver.getTitle();
    }

    public String GetSuccessMsg(){
        return driver.findElement(SuccessfulRegistration).getText();
    }

}
