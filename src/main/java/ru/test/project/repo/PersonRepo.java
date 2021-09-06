package ru.test.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.project.domain.Person;

import java.util.Optional;

public interface PersonRepo extends JpaRepository <Person, Long> {
    boolean existsById(Long id);
    Optional<Person> findById(Long id);
}
