package repository;

import domain.Adres;
import domain.Customer;
import java.util.ArrayList;

public class DummyDB 
{
    public ArrayList<Customer> customers;
    public ArrayList<Adres> adreses;

    public DummyDB() 
    {
        customers = new ArrayList<Customer>();
        adreses = new ArrayList<Adres>();
    }
}