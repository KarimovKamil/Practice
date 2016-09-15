package Services;

import Dao.Models.Car;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarsJpaBasedServiceImpl implements CarsJpaBasedService {
    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public void add(Car car){
        em.getTransaction().begin();
        Car carFromDB = em.merge(car);
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Car get(int id){
        return em.find(Car.class, id);
    }

    public void update(Car car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public List<Car> getAll(){
        TypedQuery<Car> namedQuery = em.createNamedQuery("Car.getAll", Car.class);
        return namedQuery.getResultList();
    }
}