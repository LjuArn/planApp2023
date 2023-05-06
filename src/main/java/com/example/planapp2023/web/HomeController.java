package com.example.planapp2023.web;


import com.example.planapp2023.service.TaskService;
import com.example.planapp2023.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        String loggedUsername = currentUser.getUsername();
        if (currentUser.getId() == null) {
            modelAndView.setViewName("index");
        } else {
            Long curUserId = currentUser.getId();
            modelAndView.addObject("loggedUsername", loggedUsername);
            modelAndView.addObject("allTasks", taskService.findAllTasksNoUser(curUserId));
            modelAndView.addObject("myTasks", taskService.findMyTasks(curUserId));

            Long totalTasks = taskService.countTasks(curUserId);
            modelAndView.addObject("totalUnassignedTasks", totalTasks);


            Long myTotalTasks = taskService.countMyTasks(curUserId);
            modelAndView.addObject("totalMyTasks", myTotalTasks);

            modelAndView.setViewName("home");
        }

        return modelAndView;
    }
}






