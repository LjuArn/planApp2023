package com.example.planapp2023.init;

import com.example.planapp2023.service.PriorityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements CommandLineRunner {

    private final PriorityService priorityService;

    public InitDB(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @Override
    public void run(String... args) throws Exception {

        priorityService.initCategories();
    }
}
