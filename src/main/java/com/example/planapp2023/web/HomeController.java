package com.example.planapp2023.web;


import com.example.planapp2023.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

private  final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        String loggedUsername = currentUser.getUsername();
        if (currentUser.getId() == null) {
            modelAndView.setViewName("index");
        } else {

            modelAndView.addObject("loggedUsername", loggedUsername);
            modelAndView.setViewName("home");

        }

        return modelAndView;
    }
}

// Long curUserId = currentUser.getId();
// Long totalTasks = Long.valueOf(taskService.countTasks(curUserId));
// modelAndView.addObject("allTasks", taskService.findAllTasksOtherUser(curUserId));
// modelAndView.addObject("allTasksNoUser", taskService.findAllTasksNoUser(curUserId));
// modelAndView.addObject("myTasks", taskService.findMyTasks(curUserId));
// modelAndView.addObject("totalUnassignedTasks", totalTasks);