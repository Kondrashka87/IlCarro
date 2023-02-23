package tests;

import model.Car;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase
{
    @BeforeMethod
    public void preCondition()
    {
        if(!app.getHelperUser().isLogged())
        {
            app.getHelperUser().login(new User().withEmail("doshka@mail.ru").withPassword("Koshka12$"));
            app.getHelperCar().pause(500);
        }

    }

    @Test
    public void addNewCarSuccess()
    {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Car car = Car.builder()

                .location("Haifa, Israel")
                .manufacture("BMW")
                .model("N5")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .clasS("C")
                .carRegNumber("55-00-" + i)
                .price("65")
                .about("very nice car")

                .build();

        logger.info("Tests start with data : " + car.toString());

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\Users\\size7\\Desktop\\Education\\QA\\IlCarro\\corvett.jpeg");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isTitleMessageContains("Car added"));
    }






}
