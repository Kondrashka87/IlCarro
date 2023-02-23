package manager;

import model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void openRegistrationForm()
    {
       click(By.xpath("//a[text()=' Sign up ']"));
       //click(By.cssSelector("[href^='/registration']"));
    }

    public void fillLoginRegistrationForm(String email, String password)
    {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrationForm(User user)
    {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastname());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());

    }

    public void fillLoginRegistrationForm(User user)
    {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
       // return isElementPresent(By.cssSelector("div.header a:nth-child(5)"));
    }

    public void logout() {
        //click(By.xpath("//button[text()=' Logout ']"));
        click(By.cssSelector("div.header a:nth-child(5)"));
    }


    public String getMessage() {
        return wd.findElement(By.cssSelector("div.dialog-container>h2")).getText();
    }

    public void closeDialogContainer()
    {
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
        {
            click(By.xpath("//button[text()='Ok']"));
        }

    }

    public String getErrorText()
    {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isErrorMessageContains(String message)
    {
        return wd.findElement(By.cssSelector(".error")).getText().contains(message);
    }

//    public String getErrorFormatPassword()
//    {
//        return wd.findElement(By.cssSelector("div.error.ng-star-inserted")).getText();
//    }

    public boolean isYallaButtonNotActive()
    {
        // return isElementPresent(By.cssSelector("button[disabled]"));
        return !wd.findElement(By.cssSelector("button[disabled]")).isEnabled();
    }

    public void checkPolicy()
    {
        //click(By.id("terms-of-use")); ne rabotaet
        //click(By.cssSelector("label[for='terms-of-use']"));
        //click(By.cssSelector("div[class='checkbox-container']"));toze mozno
        if(!wd.findElement(By.id("terms-of-use")).isSelected())
        {
            click(By.cssSelector(".checkbox-container"));
        }

    }

    public void checkPolicyXY()
    {
        Dimension size = wd.manage().window().getSize();
        System.out.println("Window Height "+ size.getHeight());
        System.out.println("Window Width "+ size.getWidth());

        WebElement label =wd.findElement(By.cssSelector("label[for='terms-of-use']"));

        Rectangle rect = label.getRect();
        int xOffset = rect.getWidth()/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label,-xOffset,0).click().release().perform();


    }

    public void checkPolicyJS()//Java Script
    {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').checked=false;");
    }

    public void login(User user)
    {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submit();
        closeDialogContainer();
    }


}

