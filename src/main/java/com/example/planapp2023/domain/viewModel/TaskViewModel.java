package com.example.planapp2023.domain.viewModel;

import com.example.planapp2023.domain.entity.UserEntity;
import com.example.planapp2023.domain.entity.enums.PriorityNameEnum;
import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityNameEnum priorityNameEnum;
    private UserEntity user;


    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public PriorityNameEnum getPriorityNameEnum() {
        return priorityNameEnum;
    }

    public TaskViewModel setPriorityNameEnum(PriorityNameEnum priorityNameEnum) {
        this.priorityNameEnum = priorityNameEnum;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public TaskViewModel setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
