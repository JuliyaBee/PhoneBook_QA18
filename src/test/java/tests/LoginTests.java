package tests;

import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;





@Listeners(NGListener.class)
public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }
    WebDriver wd;
   String correctEmail = "tulip@gmail.com";

    String correctPassword = "Kanareyka17$";
    String incorrectEmail = "tulipgmail.com";
    String incorrectPassword = "Kanareyka17";
    String emptyEmail = "";
    String emptyPassword = "";

    @Test(dataProvider = "loginModelDto", dataProviderClass = ProviderData.class,
            invocationCount = 1, groups={"smoke"})

    public void loginPositiveTest(User user) {
//          new User;//модифицированные сэтторы
//        User user = User.builder()
//                .email(correctEmail)
//                .password(correctPassword)
//                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.='ADD']")));
    }
    @Test(invocationCount = 1, groups={"smoke"})

    public void loginPositiveTestCSV(User user) {
//          new User;//модифицированные сэтторы
//        User user = User.builder()
//                .email(correctEmail)
//                .password(correctPassword)
//                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.='ADD']")));
    }
    @Test
    public void loginPositiveTestConfig() {
//          new User;//модифицированные сэтторы
//        User user = User.builder()
//                .email(correctEmail)
//                .password(correctPassword)
//                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.='ADD']")));
    }

    @Test(groups = {"smoke", "regress"})
    public void loginNegativeEmailTest() {
        User user = User.builder().
                email(incorrectEmail).
                password(correctPassword).
                build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }

    @Test(groups= {"regress"})
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
//    @AfterMethod(alwaysRun = true)
//   public void postCondition() {
////    app.getUser().clickOkButton();
//    }
    }

