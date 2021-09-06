package ru.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.dto.PersonDTO;
import ru.test.project.service.PersonService;

import javax.validation.Valid;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public void savePerson(@Valid PersonDTO person) {
        personService.savePerson(person);
    }
}
