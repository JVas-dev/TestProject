package ru.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.service.ClearService;

@RestController
public class ClearController {
    @Autowired
    ClearService clearService;

    @GetMapping("/clear")
    public void clear() {
        clearService.clear();
    }
}
