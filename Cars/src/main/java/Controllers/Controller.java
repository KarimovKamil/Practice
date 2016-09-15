package Controllers;

import Dao.Models.Car;
import Services.CarsService;
import Services.CarsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private CarsService carsService = new CarsServiceImpl();

    @RequestMapping(value = "/")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getBookForm() {
        return new ModelAndView("creating");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("mark") String mark, @RequestParam("releaseDate") String releaseDate) {
        Car car = new Car(mark, releaseDate);
        carsService.addCar(car);
        return "main";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id) {
        carsService.deleteCar(id);
        return "success";
    }

    @RequestMapping(value = "/changeOwner")
    public String changeOwner(@RequestParam("id") int id, @RequestParam("owner") String owner) {
        carsService.buyCar(id, owner);
        return "success";
    }

    @RequestMapping(value = "/changeNumber")
    public String changeNumberplate(@RequestParam("id") int id, @RequestParam("numberplate") String numberplate) {
        carsService.changeNumberplate(id, numberplate);
        return "success";
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public String carInfo(@RequestParam("id") int id) {
        return carsService.getCarInfo(id).toString();
    }

    @RequestMapping(value = "/table")
    @ResponseBody
    public List<Car> carTable() {
        return carsService.getTable();
    }
}
