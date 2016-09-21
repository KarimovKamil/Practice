package ru.itis.inform.Controllers;

import org.springframework.web.bind.annotation.*;
import ru.itis.inform.Dao.Models.Car;
import ru.itis.inform.Services.CarsService;
import ru.itis.inform.Services.CarsServiceImpl;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private CarsService carsService = new CarsServiceImpl();

    @RequestMapping(value = "")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCar() {
        return new ModelAndView("creating");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCar(@RequestParam("mark") String mark, @RequestParam("releaseDate") String releaseDate) {
        Car car = new Car(mark, releaseDate);
        carsService.addCar(car);
        return "main";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteCar() {
        return new ModelAndView("deleting");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCar(@RequestParam("id") int id) {
        carsService.deleteCar(id);
        return "main";
    }

    @RequestMapping(value = "/changeOwner", method = RequestMethod.GET)
    public ModelAndView changeOwner() {
        return new ModelAndView("changeOwner");
    }

    @RequestMapping(value = "/changeOwner", method = RequestMethod.POST)
    public String changeOwner(int id, String owner) {
        carsService.changeOwner(id, owner);
        return "main";
    }

    @RequestMapping(value = "/changeNumber", method = RequestMethod.GET)
    public ModelAndView changeNumberplate() {
        return new ModelAndView("changeNumber");
    }

    @RequestMapping(value = "/changeNumber", method = RequestMethod.POST)
    public String changeNumberplate(int id, String numberplate) {
        carsService.changeNumberplate(id, numberplate);
        return "main";
    }

    @RequestMapping(value = "/info/{id}")
    @ResponseBody
    public String carInfo(@PathVariable("id") int id) {
        return carsService.getCarInfo(id).toString();
    }

    @RequestMapping(value = "/table")
    @ResponseBody
    public List<Car> carTable() {
        return carsService.getTable();
    }
}
