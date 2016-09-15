package Services;

import Dao.CarsDao;
import Dao.CarsDaoJdbcTemplateBasedImpl;
import Dao.Models.Car;

import java.util.List;

public class CarsServiceImpl implements CarsService {

    private CarsDao carsDao = new CarsDaoJdbcTemplateBasedImpl();

    public void addCar(Car car) {
        carsDao.addCar(car);
    }

    public void buyCar(int id, String newOwner) {
        carsDao.updateCarOwner(id, newOwner);
    }

    public void deleteCar(int id) {
        carsDao.deleteCar(id);
    }

    public void changeNumberplate(int id, String numberplate) {
        carsDao.updateCarNumberplate(id, numberplate);
    }

    public Car getCarInfo(int id) {
        return carsDao.getCarInfo(id);
    }

    public List<Car> getTable() {
        return carsDao.getTable();
    }
}
