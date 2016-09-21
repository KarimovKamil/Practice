package ru.itis.inform.Services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import ru.itis.inform.Dao.CarsDao;
import ru.itis.inform.Dao.Models.Car;

import java.util.LinkedList;
import java.util.List;

public class CarsServiceImplTest {
    private CarsService carsService;
    private CarsDao carsDao;
    private Car car = new Car("Merc", "21.10.2015");
    private List<Car> cars = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        cars.add(car);
        carsService = new CarsServiceImpl();
        carsDao = mock(CarsDao.class);
        carsService.setCarsDao(carsDao);
        doNothing().when(carsDao).deleteCar(0);
        doNothing().when(carsDao).addCar(car);
        doNothing().when(carsDao).updateCarOwner(0, "John");
        doNothing().when(carsDao).updateCarNumberplate(0, "SA0912");
        doNothing().when(carsDao).deleteCar(0);
        when(carsDao.getCarInfo(0)).thenReturn(car);
        when(carsDao.getTable()).thenReturn(cars);
    }

    @Test
    public void addCar() throws Exception {
        carsService.addCar(car);
        verify(carsDao).addCar(car);
    }

    @Test
    public void changeOwner() throws Exception {
        carsService.changeOwner(0, "John");
        verify(carsDao).updateCarOwner(0, "John");
    }

    @Test
    public void deleteCar() throws Exception {
        carsService.deleteCar(0);
        verify(carsDao).deleteCar(0);
    }

    @Test
    public void changeNumberplate() throws Exception {
        carsService.changeNumberplate(0, "SA0912");
        verify(carsDao).updateCarNumberplate(0, "SA0912");
    }

    @Test
    public void getCarInfo() throws Exception {
        Car carFromService = carsService.getCarInfo(0);
        assertEquals(carFromService, car);
    }

    @Test
    public void getTable() throws Exception {
        List<Car> carsFromService = carsService.getTable();
        assertEquals(cars, carsFromService);
    }
}