package ru.itis.inform.Dao;

import ru.itis.inform.Dao.Models.Car;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Component("JpaBasedDaoImpl")
public class JpaBasedDaoImpl implements CarsDao {
    private EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public void addCar(Car car) {
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public void updateCarOwner(int id, String owner) {
        em.getTransaction().begin();
        Car car = getCarInfo(id);
        car.setCarOwner(owner);
        em.getTransaction().commit();
    }

    public void updateCarNumberplate(int id, String numberplate) {
        em.getTransaction().begin();
        Car car = getCarInfo(id);
        car.setNumberplate(numberplate);
        em.getTransaction().commit();
    }

    public void deleteCar(int id) {
        em.getTransaction().begin();
        em.remove(getCarInfo(id));
        em.getTransaction().commit();
    }

    public Car getCarInfo(int id) {
        return em.find(Car.class, id);
    }

    public List<Car> getTable() {
        TypedQuery<Car> namedQuery = em.createNamedQuery("Car.getAll", Car.class);
        return namedQuery.getResultList();
    }
}
