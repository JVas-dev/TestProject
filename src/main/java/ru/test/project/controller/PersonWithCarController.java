package ru.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.dto.PersonWithCarsDTO;
import ru.test.project.service.PersonWithCarsService;

@RestController
public class PersonWithCarController {
    @Autowired
    PersonWithCarsService personWithCarsService;

    @GetMapping("/personwithcars")
    public PersonWithCarsDTO getPersonWithCars(@RequestParam Long personId) {
      return personWithCarsService.getPersonWithCars(personId);

    }
}
