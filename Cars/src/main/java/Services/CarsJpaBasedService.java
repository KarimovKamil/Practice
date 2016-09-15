package Services;

import Dao.Models.Car;
import java.util.List;

public interface CarsJpaBasedService {

    public void add(Car car);

    public void delete(int id);

    public Car get(int id);

    public void update(Car car);

    public List<Car> getAll();
}
