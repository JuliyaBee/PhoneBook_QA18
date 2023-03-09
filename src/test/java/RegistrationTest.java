import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
  //  WebDriver wd;
   // FluentWait<WebDriver> wait;

    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logout();
        }
    }
  //  public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wait = new FluentWait<>(wd);
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);





    @Test



    public void regPositiveTest() {
        //1.open login/registration form
       openLoginRegistrationForm();
     //   WebElement loginButton = wd.findElement(By.xpath("//a[@href='/login']"));
     //   loginButton.click();
        //2. fill login/registration form






         String email = "tulip@gmail.com";
        String password = "Kanareyka17$";
        fillLoginRegistrationForm(email,password);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("tulip" + i + "@gmail.com");
//
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Kanareyka17$");

        //3.submit by click registration button
        submitRegistration();
       // wd.findElement(By.xpath("//button[2]")).click();
  //      pause(5000);

        //4.assert
        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    }

  //  public void pause(int time) {
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //  new FluentWait<>(wd);
        //  wait.withTimeout(Duration.ofMillis(time));



    @Test
    public void registrationWrongEmail() {
        //1.open login/registration form
        WebElement loginButton = wd.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();
        //2. fill login/registration form
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("tulip" + i + "gmail.com");

        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Kanareyka17$");


        //3.submit by click registration button
        wd.findElement(By.xpath("//button[2]")).click();

    }

    @AfterMethod
    public void tearDown() {
        // wd.quit();
    }
}

