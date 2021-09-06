package ru.test.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.project.domain.Car;
import ru.test.project.dto.StatisticsDTO;
import ru.test.project.repo.CarRepo;
import ru.test.project.repo.PersonRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StatisticsService {
    @Autowired
    CarRepo carRepo;
    @Autowired
    PersonRepo personRepo;

    public StatisticsDTO getStatistics() {
        List<Car> cars = carRepo.findAll();
        return new StatisticsDTO(
                (long) personRepo.findAll().size(),
                (long )cars.size(),
                getUniqueModel(cars)
        );
    }

    public Long getUniqueModel(List<Car> cars) {
        Set<String> model = new HashSet<>();
        cars.forEach(i -> model.add(i.getModel().toLowerCase()));
        return (long) model.size();
    }


}
