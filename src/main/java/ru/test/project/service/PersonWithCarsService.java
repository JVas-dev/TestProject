package ru.test.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.test.project.domain.Car;
import ru.test.project.domain.Person;
import ru.test.project.dto.PersonWithCarsDTO;
import ru.test.project.repo.CarRepo;
import ru.test.project.repo.PersonRepo;

import java.util.Optional;

@Service
public class PersonWithCarsService {
    @Autowired
    PersonRepo personRepo;
    @Autowired
    CarRepo carRepo;

    public PersonWithCarsDTO getPersonWithCars(Long id){
        Optional<Person> person = personRepo.findById(id);
        if (!person.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found!");
        }
        PersonWithCarsDTO personWithCars = new PersonWithCarsDTO(person.get());
        personWithCars.setCars(getUserCars(personWithCars.getId()));

        return personWithCars;
    }

    public Car[] getUserCars(Long id) {
        return carRepo.findAllByOwnerId(id);
    }
}
