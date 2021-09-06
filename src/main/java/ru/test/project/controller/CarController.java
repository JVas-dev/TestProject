package ru.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.domain.Car;
import ru.test.project.dto.CarDTO;
import ru.test.project.service.CarService;

import javax.validation.Valid;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/car")
    public void savePerson(@Valid CarDTO car) {
        carService.saveCar(car);
    }
}
