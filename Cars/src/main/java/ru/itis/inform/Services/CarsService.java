package ru.itis.inform.Services;

import ru.itis.inform.Dao.CarsDao;
import ru.itis.inform.Dao.Models.Car;

import java.util.List;

public interface CarsService {

    void setCarsDao(CarsDao carsDao);

    void addCar(Car car);

    void changeOwner(int id, String owner);

    void deleteCar(int id);

    void changeNumberplate(int id, String numberplate);

    Car getCarInfo(int id);

    List<Car> getTable();
}
