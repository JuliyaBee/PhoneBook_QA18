package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    WebDriver wd;
    String correctEmail = "tulip@gmail.com";
    String correctPassword = "Kanareyka17$";
    String incorrectEmail = "tulipgmail.com";
    String incorrectPassword = "Kanareyka17";
    String emptyEmail = "";
    String emptyPassword = "";

    @Test

    public void loginPositiveTest() {
        //   new User;//модифицированные сэтторы
        User user = User.builder()
                .email(correctEmail)
                .password(correctPassword)
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.='ADD']")));
    }

    @Test
    public void loginNegativeEmailTest() {
        User user = User.builder().
                email(incorrectEmail).
                password(correctPassword).
                build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }

    @Test
    public void loginNegativePasswordTest() {
        User user = User.builder().
                email(correctEmail).
                password(incorrectPassword).
                build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }

    @Test
    public void loginEmailPasswordEmptyTest() {
        User user = User.builder().
                email(emptyEmail).
                password(emptyPassword).
                build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }
}
