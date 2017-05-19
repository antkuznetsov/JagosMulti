package ru.innopolis.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.services.interfaces.CourseService;
import ru.innopolis.services.interfaces.LessonService;
import ru.innopolis.services.interfaces.UserService;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class DashboardController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @Autowired
    private UserService userServices;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/dashboard/")
    public String dashboard(Model model) {

        model.addAttribute("title", "Панель управления");
        model.addAttribute("usersCount", userServices.getCount());
        model.addAttribute("lessonsCount", lessonService.getCount());
        model.addAttribute("coursesCount", courseService.getCount());

        return "pages/dashboard";
    }
}