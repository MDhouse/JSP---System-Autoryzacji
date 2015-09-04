package domain;

import java.util.ArrayList;

public class Customer extends Entity
{
    private String login;
    private String password;
    private String email;
    private Privlage privlage;
    private ArrayList<Adres> adres;

    public String getLogin() 
    {
        return login;
    }

    public void setLogin(String login) 
    {
        this.login = login;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public Privlage getPrivlage() 
    {
        return privlage;
    }

    public void setPrivlage(Privlage privlage) 
    {
        this.privlage = privlage;
    }

    public ArrayList<Adres> getAdres() 
    {
        return adres;
    }

    public void setAdres(ArrayList<Adres> adres) 
    {
        this.adres = adres;
    }
}