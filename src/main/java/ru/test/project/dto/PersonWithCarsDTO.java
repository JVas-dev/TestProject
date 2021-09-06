package ru.test.project.dto;

import ru.test.project.domain.Car;
import ru.test.project.domain.Person;

import java.util.Date;

public class PersonWithCarsDTO extends PersonDTO {
    private Car[] cars;

    public PersonWithCarsDTO(Long id, String name, Date birthdate, Car[] cars) {
        super(id, name, birthdate);
        this.cars = cars;
    }

    public PersonWithCarsDTO(Car[] cars) {
        this.cars = cars;
    }

    public PersonWithCarsDTO(Person person) {
        this.Id = person.getId();
        this.name = person.getName();
        this.birthdate = person.getBirthdate();
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
