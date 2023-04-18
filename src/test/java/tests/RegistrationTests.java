package tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    WebDriver wd;
    int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
    String correctEmail = "tulip" + i + "@gmail.com";
    String correctPassword = "Kanareyka17$";
    String incorrectEmail = "tulip" + i + "gmail.com";
    String incorrectPassword = "Kanareyka17";
    String emptyEmail = "";
    String emptyPassword = "";
    // FluentWait<WebDriver>wait;

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();

        }
    }
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        // wait = new FluentWait<>(wd);
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//    }


    @Test(groups={"smoke"})
    public void regPositiveTest() {

        User user = User.builder().
                email(correctEmail).
                password(correctPassword).
                build();

        app.getUser().openLoginRegistrationForm();
        logger.info("regPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        logger.info("regPositiveTest completed");
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.='ADD']")));
    }
    @Test(dataProvider = "registrationCSV()", dataProviderClass = ProviderData.class,groups={"smoke"})
    public void regPositiveTestCSV(User user) {

//        User user = User.builder().
//                email(correctEmail).
//                password(correctPassword).
//                build();

        app.getUser().openLoginRegistrationForm();
       // logger.info("regPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        logger.info("regPositiveTest completed");
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.='ADD']")));
    }



    //  public void pause(int time) {
//    try {
//        Thread.sleep(time);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }

    //wait.withTimeout(Duration.ofSeconds(time));


    @Test
    public void regWrongEmailTest() {
        User user = User.builder().
                email(incorrectEmail).
                password(correctPassword).
                build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isErrorFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void regWrongPasswordTest() {
        User user = User.builder().
                email(correctEmail).
                email(incorrectPassword).build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isErrorFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @Test
    public void regEmpty() {

        User user = User.builder().
                email(emptyEmail).
                password(emptyPassword).build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isErrorFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }


   @AfterMethod(alwaysRun = true)
  public void tearDown() {
//        wd.quit();
  }}
//
//}