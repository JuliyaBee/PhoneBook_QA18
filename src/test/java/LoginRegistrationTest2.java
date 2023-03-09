import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginRegistrationTest2 {
    WebDriver wd;
    String correctLogin="mlk111@gmail.com";
    String correctPassword="123P@assword";
    String incorrectLogin="mlk222gmail.com";
    String incorrectPassword="4566666";
    String emptyLogin=" ";
    String emptyPassword=" ";

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        System.out.println("End precondition");
    }
@Test
    public void LoginTestPositive() {
        WebElement inputLogin = wd.findElement(By.xpath("//input[1]"));
        inputLogin.click();
        inputLogin.clear();
        inputLogin.sendKeys(correctLogin);

    WebElement inputPassword = wd.findElement(By.xpath("//input[2]"));
    inputPassword.click();
    inputPassword.clear();
    inputPassword.sendKeys(correctPassword);

    WebElement loginButton = wd.findElement(By.xpath("//button[1]"));
    loginButton.click();
}
@Test
public void LoginTestNegative1(){
    WebElement inputLogin = wd.findElement(By.xpath("//input[1]"));
    inputLogin.click();
    inputLogin.clear();
    inputLogin.sendKeys(incorrectLogin);

    WebElement inputPassword = wd.findElement(By.xpath("//input[2]"));
    inputPassword.click();
    inputPassword.clear();
    inputPassword.sendKeys(incorrectPassword);

    WebElement loginButton = wd.findElement(By.xpath("//button[1]"));
    loginButton.click();

}
    @Test
    public void LoginTestNegative2() {
        WebElement inputLogin = wd.findElement(By.xpath("//input[1]"));
        inputLogin.click();
        inputLogin.clear();
        inputLogin.sendKeys(correctLogin);

        WebElement inputPassword = wd.findElement(By.xpath("//input[2]"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(incorrectPassword);

        WebElement loginButton = wd.findElement(By.xpath("//button[1]"));
        loginButton.click();
    }

    @Test
    public void LoginTestNegative3() {
        WebElement inputLogin = wd.findElement(By.xpath("//input[1]"));
        inputLogin.click();
        inputLogin.clear();
        inputLogin.sendKeys(emptyLogin);

        WebElement inputPassword = wd.findElement(By.xpath("//input[2]"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(incorrectPassword);

        WebElement loginButton = wd.findElement(By.xpath("//button[1]"));
        loginButton.click();
    }
    @Test
    public void LoginTestNegative4() {
        WebElement inputLogin = wd.findElement(By.xpath("//input[1]"));
        inputLogin.click();
        inputLogin.clear();
        inputLogin.sendKeys(correctLogin);

        WebElement inputPassword = wd.findElement(By.xpath("//input[2]"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(emptyPassword);

        WebElement loginButton = wd.findElement(By.xpath("//button[1]"));
        loginButton.click();
    }
@AfterMethod
public void  pastCondition(){
    System.out.println("Start pastCondition");
    //wd.close;
    System.out.println("End pastCondition");
}}