package repository;

import domain.Customer;
import java.util.List;

public class DummyCustomerRepository 
{
    private DummyDB db;

    public DummyCustomerRepository(DummyDB db) 
    {
        this.db = db;
    }
    
    public void add(Customer entity)
    {
        db.customers.add(entity);
    }
    
    public void delete(Customer entity)
    {
        db.customers.remove(entity);
    }
    
    public List<Customer>getAll()
    {
        return db.customers;
    }
    
}