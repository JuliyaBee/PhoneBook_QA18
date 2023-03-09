import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationTest2 extends TestBase2 {
    //WebDriver wd;
    int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
    String correctEmail = "tulip" + i + "@gmail.com";
    String correctPassword = "Kanareyka17$";
    String incorrectEmail = "tulip" + i + "gmail.com";
    String incorrectPassword = "Kanareyka17";
    String emptyEmail = "";
    String emptyPassword = "";
    // FluentWait<WebDriver>wait;

    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logOut();

        }
    }
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        // wait = new FluentWait<>(wd);
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//    }


    @Test
    public void regPositiveTest() {
//       1.open  login/registration form
//         wd.findElement(By.xpath("//a[@href='/login']")).click();
        openLoginRegistrationForm();
//        2. fill  login/registration form
        //      int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        fillLoginRegistrationForm(correctEmail, correctPassword);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(correctEmail);
//
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(correctPassword);

        //       3.submit by click registration button
        submitRegistration();
        // wd.findElement(By.xpath("//button[2]")).click();
        //  pause(10000);

//        4.assert
        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));

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
        openLoginRegistrationForm();
//        WebElement login = wd.findElement(By.xpath("//a[@href='/login']"));
//        login.click();

        fillLoginRegistrationForm(incorrectEmail, correctPassword );
//        WebElement email1 = wd.findElement(By.xpath("//input[1]"));
//        email1.click();
//        email1.clear();
//        email1.sendKeys(incorrectEmail);
//
//        WebElement password1 = wd.findElement(By.xpath("//input[2]"));
//        password1.click();
//        password1.clear();
//        password1.sendKeys(correctPassword);
        submitRegistration();
//        WebElement btnReg1 = wd.findElement(By.xpath("//button[2]"));
//        btnReg1.click();

     //   Assert.assertFalse(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    }

    @Test
    public void regWrongPasswordTest() {
        openLoginRegistrationForm();
      //  wd.findElement(By.xpath("//a[@href='/login']")).click();

         fillLoginRegistrationForm(correctEmail, incorrectPassword );
//        WebElement email = wd.findElement(By.xpath("//input[1]"));
//        email.click();
//        email.clear();
//        email.sendKeys(correctEmail);
//
//        WebElement password = wd.findElement(By.xpath("//input[2]"));
//        password.click();
//        password.clear();
//        password.sendKeys(incorrectPassword);
          submitRegistration();
       // wd.findElement(By.xpath("//button[2]")).click();
      // Assert.assertFalse(wd.findElement(By.xpath("//a[text='ADD']")).getText().equals("ADD"));
    }

    @Test
    public void regEmpty() {
        openLoginRegistrationForm();
       // wd.findElement(By.xpath("//a[@href='/login']")).click();

         fillLoginRegistrationForm(emptyEmail, emptyPassword);
//        WebElement email = wd.findElement(By.xpath("//input[1]"));
//        email.click();
//        email.clear();
//        email.sendKeys(emptyEmail);
//
//        WebElement password = wd.findElement(By.xpath("//input[2]"));
//        password.click();
//        password.clear();
//        password.sendKeys(emptyPassword);
          submitRegistration();
//        wd.findElement(By.xpath("//button[2]")).click();
        //  Assert.assertFalse(wd.findElement(By.xpath("//a[text='ADD']")).getText().equals("ADD"));
    }


//    @AfterMethod
//    public void tearDown() {
//        // wd.quit();
//    }

}