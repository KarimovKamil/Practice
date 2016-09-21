package ru.itis.inform.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.itis.inform.Dao.CarsDao;
import ru.itis.inform.Dao.JdbcTemplateDaoImpl;
import ru.itis.inform.Dao.JpaBasedDaoImpl;
import ru.itis.inform.Dao.Models.Car;
import java.util.List;

@Component
public class CarsServiceImpl implements CarsService {

    private CarsDao carsDao = new JpaBasedDaoImpl();

    public void setCarsDao (CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    private Logger log = LoggerFactory.getLogger(CarsServiceImpl.class);

    public void addCar(Car car) {
        carsDao.addCar(car);
        log.info("Added new car with mark & release date: " + car.getMark() + " " + car.getReleaseDate());
    }

    public void changeOwner(int id, String newOwner) {
        carsDao.updateCarOwner(id, newOwner);
        log.info("Changed owner of car with id = " + id);
    }

    public void deleteCar(int id) {
        carsDao.deleteCar(id);
        log.info("Deleted car with id = " + id);
    }

    public void changeNumberplate(int id, String numberplate) {
        carsDao.updateCarNumberplate(id, numberplate);
        log.info("Changed numberplate of car with id = " + id);
    }

    public Car getCarInfo(int id) {
        log.info("Getting info about car with id = " + id);
        return carsDao.getCarInfo(id);
    }

    public List<Car> getTable() {
        log.info("Getting info about all cars");
        return carsDao.getTable();
    }
}
