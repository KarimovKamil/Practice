package ru.itis.inform.Dao;

import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.Dao.Models.Car;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Component
public class JpaBasedDaoImpl implements CarsDao {
    private EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public void addCar(Car car) {
        em.merge(car);
    }

    public void updateCarOwner(int id, String owner) {
        Car car = getCarInfo(id);
        car.setCarOwner(owner);
    }

    public void updateCarNumberplate(int id, String numberplate) {
        Car car = getCarInfo(id);
        car.setNumberplate(numberplate);
    }

    public void deleteCar(int id) {
        em.remove(getCarInfo(id));
    }

    public Car getCarInfo(int id) {
        return em.find(Car.class, id);
    }

    public List<Car> getTable() {
        TypedQuery<Car> namedQuery = em.createNamedQuery("Car.getAll", Car.class);
        return namedQuery.getResultList();
    }
}
