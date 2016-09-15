package Dao;

import Config.PropertiesProvider;
import Dao.Models.Car;
import Dao.Models.CarMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Properties;

public class CarsDaoJdbcTemplateBasedImpl implements CarsDao {
    PropertiesProvider props = new PropertiesProvider();
    Properties properties = props.getProperties();
    private String username = properties.getProperty("username");
    private String password = properties.getProperty("password");
    private String url = properties.getProperty("url");
    private DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public void addCar(Car car) {
        if (car.getCarOwner() != null) {
            jdbcTemplate.execute("INSERT INTO cars_info (mark, numberplate, release_date, car_owner) VALUES ( '"
                    + car.getMark() + "', '"
                    + car.getNumberplate() + "', '"
                    + car.getReleaseDate() + "', '"
                    + car.getCarOwner() + "' )");
        } else {
            jdbcTemplate.execute("INSERT INTO cars_info (mark, release_date) VALUES ( '"
                    + car.getMark() + "', '"
                    + car.getReleaseDate() + "')");
        }
    }

    public void updateCarOwner(int id, String owner) {
        jdbcTemplate.execute("UPDATE cars_info SET car_owner = '" + owner + "' WHERE id = " + id + ";");
    }

    public void updateCarNumberplate(int id, String numberplate) {
        jdbcTemplate.execute("UPDATE cars_info SET numberplate = '" + numberplate + "' WHERE id = " + id + ";");
    }

    public void deleteCar(int id) {
        jdbcTemplate.execute("DELETE FROM cars_info WHERE id = " + id + ";");
    }

    public Car getCarInfo(int id) {
        List<Car> car = jdbcTemplate.query("SELECT * FROM cars_info WHERE id = " + id + ";", new CarMapper());
        return car.get(0);
    }

    public List<Car> getTable() {
        List<Car> cars = jdbcTemplate.query("SELECT * FROM cars_info;", new CarMapper());
        return cars;
    }
}