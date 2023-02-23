package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser
{
    @DataProvider
    public Iterator<Object[]>  xxx()
    {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>  LoginData()
    {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("doshka@mail.ru").withPassword("Koshka12$")});
        list.add(new Object[]{new User().withEmail("doshka@mail.ru").withPassword("Koshka12$")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>  LoginDataFile()
    {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

}
