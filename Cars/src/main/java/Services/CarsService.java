package Services;

import Dao.Models.Car;

import java.util.List;

public interface CarsService {

    public void addCar(Car car);

    public void buyCar(int id, String owner);

    public void deleteCar(int id);

    public void changeNumberplate(int id, String numberplate);

    public Car getCarInfo(int id);

    public List<Car> getTable();
}
