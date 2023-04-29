package com.example.planapp2023.service;

import com.example.planapp2023.domain.entity.TaskEntity;
import com.example.planapp2023.domain.serviceModel.TaskServiceModel;
import com.example.planapp2023.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final PriorityService priorityService;

    public TaskServiceImpl(TaskRepository taskRepository,
                           ModelMapper modelMapper,
                           PriorityService priorityService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.priorityService = priorityService;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {

        TaskEntity task = modelMapper.map(taskServiceModel, TaskEntity.class);

        task.setPriority(priorityService.findByPriorityNameEnum(taskServiceModel.getPriorityNameEnum()));


        //task.setUser(userRepository.findById(currentUser.getId()).orElse(null));

        taskRepository.saveAndFlush(task);


    }




}
