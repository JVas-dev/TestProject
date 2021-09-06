package ru.test.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.test.project.domain.Person;
import ru.test.project.dto.PersonDTO;
import ru.test.project.repo.PersonRepo;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    public void savePerson(PersonDTO personDTO) {
        Person person = new Person(
                personDTO.getId(),
                personDTO.getName(),
                personDTO.getBirthdate()
        );
        boolean isExistPerson = personRepo.existsById(person.getId());
        if (isExistPerson) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person exist!");
        } else {
            personRepo.save(person);
        }
    }
}
