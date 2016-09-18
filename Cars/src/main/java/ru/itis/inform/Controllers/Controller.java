package ru.itis.inform.Controllers;

import ru.itis.inform.Dao.Models.Car;
import ru.itis.inform.Services.CarsService;
import ru.itis.inform.Services.CarsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        return "main";
    }

    @RequestMapping(value = "/changeOwner")
    public String changeOwner(@RequestParam("id") int id, @RequestParam("owner") String owner) {
        carsService.buyCar(id, owner);
        return "main";
    }

    @RequestMapping(value = "/changeNumber")
    public String changeNumberplate(@RequestParam("id") int id, @RequestParam("numberplate") String numberplate) {
        carsService.changeNumberplate(id, numberplate);
        return "main";
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
