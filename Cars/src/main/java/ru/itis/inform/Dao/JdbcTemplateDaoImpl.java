package ru.itis.inform.Dao;

import ru.itis.inform.Config.WebAppContext;
import ru.itis.inform.Dao.Models.Car;
import ru.itis.inform.Dao.Models.CarMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component("JdbcTemplateDaoImpl")
public class JdbcTemplateDaoImpl implements CarsDao {
    private WebAppContext webAppContext = new WebAppContext();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(webAppContext.dataSource());

    public void addCar(Car car) {
        String sql = "INSERT INTO cars_info (mark, release_date) VALUES (?, ?);";
        jdbcTemplate.update(sql, car.getMark(), car.getReleaseDate());
    }

    public void updateCarOwner(int id, String owner) {
        String sql = "UPDATE cars_info SET car_owner = ? WHERE id = ?;";
        jdbcTemplate.update(sql, owner, id);
    }

    public void updateCarNumberplate(int id, String numberplate) {
        String sql = "UPDATE cars_info SET numberplate = ? WHERE id = ?;";
        jdbcTemplate.update(sql, numberplate, id);
    }

    public void deleteCar(int id) {
        String sql = "DELETE FROM cars_info WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    public Car getCarInfo(int id) {
        String sql = "SELECT * FROM cars_info WHERE id = ?;";
        Car car = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CarMapper());
        return car;
    }

    public List<Car> getTable() {
        List<Car> cars = new LinkedList<>();
        String sql = "SELECT * FROM cars_info;";
        cars = jdbcTemplate.query(sql, new CarMapper());
        return cars;
    }
}
