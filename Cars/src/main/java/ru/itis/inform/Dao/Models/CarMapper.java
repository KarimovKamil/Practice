package ru.itis.inform.Dao.Models;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    public Car mapRow (ResultSet resultSet, int rowNum) throws SQLException {
        Car car = new Car(resultSet.getInt("id"),
                resultSet.getString("mark"),
                resultSet.getString("numberplate"),
                resultSet.getString("release_date"),
                resultSet.getString("car_owner"));
        return car;
    }
}
