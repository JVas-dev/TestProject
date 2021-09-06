package ru.test.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.test.project.domain.Car;

public interface CarRepo extends JpaRepository<Car, Long> {
    boolean existsById(Long id);
    Car[] findAllByOwnerId(Long id);
}
