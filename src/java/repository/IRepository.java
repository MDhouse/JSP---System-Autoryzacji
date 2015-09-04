package repository;

import domain.Entity;
import java.util.List;

public interface  IRepository<TEntity extends Entity> 
{
    public void add(TEntity entity);
    public void delete(TEntity entity);
    public void update(TEntity entity);
    public List<TEntity> getAll();
}