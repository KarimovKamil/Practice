package Controllers;

import Dao.Models.Car;
import Services.CarsJpaBasedService;
import Services.CarsJpaBasedServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value = "/jpa")
@org.springframework.stereotype.Controller
public class ControllerJPA {
    private CarsJpaBasedService carsService = new CarsJpaBasedServiceImpl();

    @RequestMapping(value = "/")
    public String main() {
        return "mainJPA";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getBookForm() {
        return new ModelAndView("creating");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("mark") String mark, @RequestParam("releaseDate") String releaseDate) {
        Car car = new Car(mark, releaseDate);
        carsService.add(car);
        return "main";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id) {
        carsService.delete(id);
        return "success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update() {
        return new ModelAndView("updating");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") int id,
                         @RequestParam("mark") String mark,
                         @RequestParam("numberplate") String numberplate,
                         @RequestParam("releaseDate") String releaseDate,
                         @RequestParam("owner") String owner) {
        carsService.update(new Car(id, mark, numberplate, releaseDate, owner));
        return "main";
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public String carInfo(@RequestParam("id") int id) {
        return carsService.get(id).toString();
    }

    @RequestMapping(value = "/table")
    @ResponseBody
    public List<Car> carTable() {
        return carsService.getAll();
    }
}
