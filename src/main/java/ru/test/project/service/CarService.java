package ru.test.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.test.project.domain.Car;
import ru.test.project.domain.Person;
import ru.test.project.dto.CarDTO;
import ru.test.project.repo.CarRepo;
import ru.test.project.repo.PersonRepo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepo carRepo;
    @Autowired
    PersonRepo personRepo;

    public void saveCar(CarDTO carDTO) {
        Car car = new Car(
                carDTO.getId(),
                carDTO.getModel(),
                carDTO.getHorsepower(),
                carDTO.getOwnerId()
        );
        if (isExistCar(car)
                || isExistOwnerId(car)
                || isValidAge(car)
                || isValidModel(car)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car exist!");
        } else {
            carRepo.save(car);
        }
    }

    public boolean isExistCar(Car car) {
        return carRepo.existsById(car.getId());
    }

    public boolean isExistOwnerId(Car car) {
        return !personRepo.existsById(car.getOwnerId());
    }

    public boolean isValidAge(Car car) {
        Optional<Person> person = personRepo.findById(car.getOwnerId());
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
       return !calendar.getTime().after(person.get().getBirthdate());
    }

    public boolean isValidModel(Car car) {
        String[] model = car.getModel().split("-");
        return model.length == 2;
    }
}
