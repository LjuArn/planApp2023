package com.example.planapp2023.domain.entity;

import com.example.planapp2023.domain.entity.enums.PriorityNameEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "priorities")
public class PriorityEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private PriorityNameEnum name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority", fetch = FetchType.EAGER)
    private Set<TaskEntity> taskEntitySet;

    public PriorityEntity() {
    }


    public PriorityNameEnum getName() {
        return name;
    }

    public PriorityEntity setName(PriorityNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PriorityEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<TaskEntity> getTaskEntitySet() {
        return taskEntitySet;
    }

    public PriorityEntity setTaskEntitySet(Set<TaskEntity> taskEntitySet) {
        this.taskEntitySet = taskEntitySet;
        return this;
    }
}
