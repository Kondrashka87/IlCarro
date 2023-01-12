package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @BeforeMethod
    public void preCondition()
    {
        if(app.getHelperUser().isLogged())
        {
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess()
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("doshka@mail.ru","Koshka12$");
        app.getHelperUser().submitLogin();
    }
    @Test
    public void loginWrongEmail()
    {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("doshkamail.ru","Koshka12$");
        //app.getHelperUser().submitLogin();
    }
    @Test
    public void loginWrongPassword()
    {

    }
    @Test
    public void loginUnregisterUser()
    {

    }






}