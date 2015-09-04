package repository;

import domain.Adres;
import java.util.List;

public class DummyAdresRepository 
{
    private DummyDB db;

    public DummyAdresRepository(DummyDB db) 
    {
        this.db = db;
    }
    
    public void add (Adres entity)
    {
        db.adreses.add(entity);
    }
    
    public void delete (Adres entity)
    {
        db.adreses.remove(entity);
    }
    
    public List<Adres>getAll()
    {
        return db.adreses;
    }
}