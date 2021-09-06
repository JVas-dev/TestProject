package ru.test.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.project.repo.CarRepo;
import ru.test.project.repo.PersonRepo;

@Service
public class ClearService {
    @Autowired
    CarRepo carRepo;
    @Autowired
    PersonRepo personRepo;

    public void clear() {
        carRepo.deleteAll();
        personRepo.deleteAll();
    }
}
