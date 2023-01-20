package model;

public class User
{
    private String Name;
    private String Lastname;
    private String Email;
    private String Password;

    public User withName(String name)
    {
        return new User();
    }

    public User withLastname(String lastname)
    {
        Lastname = lastname;
        return this;
    }

    public User withEmail(String email)
    {
        Email = email;
        return this;
    }

    public User withPassword(String password)
    {
        Password = password;
        return this;
    }

    public String getName()
    {
        return Name;
    }

    public String getLastname()
    {
        return Lastname;
    }

    public String getEmail()
    {
        return Email;
    }

    public String getPassword()
    {
        return Password;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
