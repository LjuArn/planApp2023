package com.example.planapp2023.service;

import com.example.planapp2023.domain.entity.TaskEntity;
import com.example.planapp2023.domain.entity.UserEntity;
import com.example.planapp2023.domain.serviceModel.TaskServiceModel;
import com.example.planapp2023.domain.viewModel.TaskViewModel;
import com.example.planapp2023.repository.TaskRepository;
import com.example.planapp2023.repository.UserRepository;
import com.example.planapp2023.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PriorityService priorityService;
    private final CurrentUser currentUser;

    public TaskServiceImpl(TaskRepository taskRepository,
                           UserRepository userRepository, ModelMapper modelMapper,
                           PriorityService priorityService, CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.priorityService = priorityService;
        this.currentUser = currentUser;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {

        TaskEntity task = modelMapper.map(taskServiceModel, TaskEntity.class);
        task.setPriority(priorityService.findByPriorityNameEnum(taskServiceModel.getPriorityNameEnum()));
        //task.setUser(userRepository.findById(currentUser.getId()).orElse(null));
        taskRepository.saveAndFlush(task);
    }



    @Override
    public List<TaskViewModel> findMyTasks(Long curUserId) {
        return taskRepository.findAllByUser_Id(curUserId)
                .stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskViewModel> findAllTasksNoUser(Long curUserId) {
        return taskRepository.findAllByUser_Id(null)
                .stream()
                .map(taskEntity -> modelMapper.map(taskEntity, TaskViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public long countTasks(Long curUserId) {

        return findAllTasksNoUser(curUserId).stream().count();
    }

    @Override
    public Long countMyTasks(Long curUserId) {
        return findMyTasks(curUserId).stream().count();
    }



    @Override
    public void assaignMeTask(Long id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);

        UserEntity findUserOnTask = userRepository.findById(currentUser.getId()).orElse(null);
        TaskEntity taskAssigned = task.setUser(findUserOnTask);

        taskRepository.saveAndFlush(taskAssigned);
    }

    @Override
    public void returnTask(Long id) {

        TaskEntity task = taskRepository.findById(id).orElse(null);
        TaskEntity taskWithNullUser = task.setUser(null);

        taskRepository.saveAndFlush(taskWithNullUser);
    }

    @Override
    public void del(Long id) {
        taskRepository.deleteById(id);
    }




}
