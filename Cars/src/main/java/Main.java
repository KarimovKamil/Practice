import Dao.Models.Car;
import Services.CarsJpaBasedServiceImpl;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        CarsJpaBasedServiceImpl jpa = new CarsJpaBasedServiceImpl();
        jpa.delete(1);
    }
}
