package RegistrationTests;

import base.BaseTests;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests {
    String emailAddress = GenerateRandomEmail();
    String password = "P@ssw0rd@2023";
    String FirstName = "Amro";
    String LastName = "Ehab";
    String PhoneNum = "01112085533";

    public String GenerateRandomEmail(){
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return generatedString+"@armablog.com";
    }

    @Test
    public void ValidateUserCanRegisterAccountSuccessfully() throws InterruptedException {
        homePage.clickAccountButton();
        homePage.clickSignInButton();
        signinPage.setEmail(emailAddress);
        signinPage.clickContinueButton();
        createAccountPage.setPassword(password);
        createAccountPage.ConfirmPassword(password);
        Thread.sleep(1000);
        createAccountPage.clickContinueRegistrationBtn();
        personalDetailsPage.setFirstName(FirstName);
        personalDetailsPage.setLastName(LastName);
        personalDetailsPage.setPhoneNum(PhoneNum);
        personalDetailsPage.clickConfirmRegistrationBtn();
        personalDetailsPage.openGenderDropdwn();
        personalDetailsPage.selectMaleGender();
        personalDetailsPage.setBirthdate();
        personalDetailsPage.TickCheckbox();
        personalDetailsPage.clickConfirmRegistrationBtn2();
        personalDetailsPage.GetPageTitle();
        Assert.assertEquals(personalDetailsPage.GetSuccessMsg(), "Amro, Your account has been created!");
    }
}
