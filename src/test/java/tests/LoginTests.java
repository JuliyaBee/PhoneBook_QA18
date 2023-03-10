package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
   String correctEmail = "tulip@gmail.com";
   String correctPassword = "Kanareyka17$";
   String incorrectEmail = "tulipgmail.com";
   String incorrectPassword = "Kanareyka17";
   String emptyEmail = "";
   String emptyPassword = "";
   @Test

    public void loginPositiveTest(){

       app.getUser().openLoginRegistrationForm();
       app.getUser().fillLoginRegistrationForm(correctEmail, correctPassword);
      app.getUser().submitLogin();
      Assert.assertTrue(app.getUser().isLogged());
   }
   @Test
   public void loginNegativeEmailTest(){

      app.getUser().openLoginRegistrationForm();
      app.getUser().fillLoginRegistrationForm(incorrectEmail, correctPassword);
      app.getUser().submitLogin();
   }
   @Test
   public void loginNegativePasswordTest(){

      app.getUser().openLoginRegistrationForm();
      app.getUser().fillLoginRegistrationForm(correctEmail, incorrectPassword);
      app.getUser().submitLogin();
   }
   @Test
   public void loginEmailPasswordEmptyTest(){

      app.getUser().openLoginRegistrationForm();
      app.getUser().fillLoginRegistrationForm(emptyEmail, emptyPassword);
      app.getUser().submitLogin();
   }
}
