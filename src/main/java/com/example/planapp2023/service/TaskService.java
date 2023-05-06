package com.example.planapp2023.service;

import com.example.planapp2023.domain.serviceModel.TaskServiceModel;
import com.example.planapp2023.domain.viewModel.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskServiceModel taskServiceModel);

   // List<TaskViewModel> findAllTasksOtherUser(Long curUserId);

    List<TaskViewModel> findMyTasks(Long curUserId);

    List<TaskViewModel> findAllTasksNoUser(Long curUserId);

    long countTasks(Long curUserId);

    void assaignMeTask(Long id);

    void returnTask(Long id);

    void del(Long id);

    Long countMyTasks(Long curUserId);
}
