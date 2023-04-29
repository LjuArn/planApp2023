package com.example.planapp2023.domain.serviceModel;

import com.example.planapp2023.domain.entity.enums.PriorityNameEnum;


import java.time.LocalDate;

public class TaskServiceModel {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityNameEnum priorityNameEnum;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityNameEnum getPriorityNameEnum() {
        return priorityNameEnum;
    }

    public TaskServiceModel setPriorityNameEnum(PriorityNameEnum priorityNameEnum) {
        this.priorityNameEnum = priorityNameEnum;
        return this;
    }
}
