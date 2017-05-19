package ru.innopolis.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.models.entities.Course;
import ru.innopolis.models.entities.Lesson;
import ru.innopolis.services.interfaces.LessonService;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class LessonsController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @Autowired
    private LessonService lessonServices;

    @RequestMapping(value = "/lessons/", method = RequestMethod.GET)
    public ModelAndView courses(@RequestParam(value="action", required=false) String action,
                                @RequestParam(value="id", required=false) String id,
                                @RequestParam(value="course", required=false) String course, Model model) {

        ModelAndView mav = new ModelAndView("pages/courses/list");

        int courseId = 0;

        if (course != null){
            courseId = Integer.parseInt(course);
        }

        if ("add".equals(action)) {

            model.addAttribute("title", "Добавить урок");
            model.addAttribute("action", "/lessons/add/");

            Lesson lesson = new Lesson();
            lesson.setCourseId(courseId);

            mav = new ModelAndView("pages/lessons/add-edit", "command", lesson);

        } else if ("edit".equals(action)) {

            Lesson lesson = lessonServices.getById(Integer.parseInt(id));

            model.addAttribute("title", "Изменить урок");
            model.addAttribute("action", "/lessons/edit/");
            model.addAttribute("lesson", lesson);

            mav = new ModelAndView("pages/lessons/add-edit", "command", lesson);

        } else if ("delete".equals(action)) {

            lessonServices.delete(Integer.parseInt(id));

            mav = new ModelAndView("redirect:/courses/?action=edit&id=" + courseId);

        }
        return mav;
    }

    @RequestMapping(value="/lessons/add/", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("lessons") Lesson lesson){
        lessonServices.add(lesson);
        return new ModelAndView("redirect:/courses/?action=edit&id=" + lesson.getCourseId());
    }

    @RequestMapping(value="/lessons/edit/", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("lessons") Lesson lesson){
        lessonServices.update(lesson);
        return new ModelAndView("redirect:/courses/?action=edit&id=" + lesson.getCourseId());
    }

}
