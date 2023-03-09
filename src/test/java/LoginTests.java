import org.testng.annotations.Test;

public class LoginTests extends TestBase{
   @Test
    public void loginPositivTest(){
       String email = "abcd@gmail.com";
       String password = "Konorejka$7";
       openLoginRegistrationForm();
       fillLoginRegistrationForm(email, password);
       submitLogin();
   }
}
