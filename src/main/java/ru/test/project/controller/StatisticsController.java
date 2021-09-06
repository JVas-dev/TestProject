package ru.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.project.dto.StatisticsDTO;
import ru.test.project.service.StatisticsService;

@RestController
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;
    @GetMapping("/statistics")
    public StatisticsDTO getStatistics() {
        return statisticsService.getStatistics();
    }

}
