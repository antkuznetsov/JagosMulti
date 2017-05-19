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
import ru.innopolis.models.entities.User;
import ru.innopolis.services.interfaces.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class UsersController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ModelAndView users(@RequestParam(value="action", required=false) String action,
                              @RequestParam(value="id", required=false) String id, Model model) {

        ModelAndView mav = new ModelAndView("pages/users/list");

        if ("add".equals(action)) {

            Map<Integer, String> groups = new HashMap<Integer, String>();
            groups.put(1, "Администраторы");
            groups.put(2, "Пользователи");

            model.addAttribute("title", "Добавить пользователя");
            model.addAttribute("action", "/users/add/");
            model.addAttribute("groups", groups);

            mav = new ModelAndView("pages/users/add-edit", "command", new User());

        } else if ("edit".equals(action)) {

            Map<Integer, String> groups = new HashMap<Integer, String>();
            groups.put(1, "Администраторы");
            groups.put(2, "Пользователи");

            User user = userService.getById(Integer.parseInt(id));

            model.addAttribute("title", "Изменить пользователя");
            model.addAttribute("action", "/users/edit/");
            model.addAttribute("groups", groups);

            mav = new ModelAndView("pages/users/add-edit", "command", user);

        } else if ("delete".equals(action)) {

            userService.delete(Integer.parseInt(id));

            mav = new ModelAndView("redirect:/users/");

        } else {

            List<User> users = userService.getList();
            model.addAttribute("title", "Пользователи");
            model.addAttribute("users", users);

        }
        return mav;
    }

    @RequestMapping(value="/users/add/", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("user") User user){
        userService.add(user);
        return new ModelAndView("redirect:/users/");
    }

    @RequestMapping(value="/users/edit/", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("user") User user){
        userService.update(user);
        return new ModelAndView("redirect:/users/");
    }
}