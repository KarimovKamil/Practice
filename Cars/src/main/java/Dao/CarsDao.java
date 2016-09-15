package Dao;

import Dao.Models.Car;

import java.util.List;

public interface CarsDao {

    public void addCar (Car car);

    public void updateCarOwner(int id, String owner);

    public void updateCarNumberplate(int id, String numberplate);

    public void deleteCar(int id);

    public Car getCarInfo(int id);

    public List<Car> getTable();
}
