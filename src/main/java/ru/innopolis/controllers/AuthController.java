package ru.innopolis.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kuznetsov on 29/04/2017.
 */

@Controller
public class AuthController {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

    @RequestMapping(value = "/auth/", method = RequestMethod.GET)
    public ModelAndView auth(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView mav = new ModelAndView();

        mav.addObject("title", "Авторизация");

        if (error != null) {
            mav.addObject("error", "Неправильный e-mail или пароль!");
        }

        if (logout != null) {
            mav.addObject("msg", "Вы успешно вышли!");
        }

        mav.setViewName("pages/auth");

        return mav;
    }
}