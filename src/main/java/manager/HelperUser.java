package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase
{
    public HelperUser(WebDriver wd)
    {
        super(wd);
    }

    public void openLoginRegistrationForm()
    {
        click(By.cssSelector("[href ^= '/lo']"));
    }

    public void fillLoginRegistrationForm(String email, String password)
    {
        type(By.cssSelector("input[formcontrolname$='email']"),email);
        type(By.cssSelector("input[formcontrolname$='password']"),password);
    }

    public void submitLogin()
    {
        click(By.xpath("//button[.=\"Y’alla!\"]"));
    }

    public boolean isLogged()
    {
        List<WebElement> list = wd.findElements(By.xpath("//a[@href='/registration?url=%2Fsearch']"));
        return list.size() > 0;
    }
    public void logout()
    {
        click(By.xpath("//a[@href='/registration?url=%2Fsearch']"));
    }


}
