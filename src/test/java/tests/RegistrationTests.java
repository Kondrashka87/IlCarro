package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase
{
        @BeforeMethod
        public void preCondition()
        {
            if (app.getHelperUser().isLogged())
            {
                app.getHelperUser().logout();
            }

        }
    @Test
    public void registrationSuccess()
    {
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withName("Anna").withLastname("Kondrateva").withEmail("doshka"+i+"@mail.ru").withPassword("Koshka12$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

    }
    @Test
    public void registrationWrongEmail()
    {
        User user = new User().withName("Anna").withLastname("Kondrateva").withEmail("doshkamail.com").withPassword("Koshka12$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorFormatEmail(),"Wrong email format");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
        @Test
        public void registrationWrongPassword()
        {
            User user = new User().withName("Anna").withLastname("Kondrateva").withEmail("doshka@mail.com").withPassword("Koshka12");

            app.getHelperUser().openRegistrationForm();
            app.getHelperUser().fillRegistrationForm(user);
            app.getHelperUser().checkPolicy();
            app.getHelperUser().submit();
            Assert.assertEquals(app.getHelperUser().getErrorFormatPassword(),"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
            Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        }


    @AfterMethod
    public void postCondition()
    {
        app.getHelperUser().closeDialogContainer();
    }

}