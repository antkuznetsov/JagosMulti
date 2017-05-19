package ru.innopolis.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.exceptions.CustomGenericException;

/**
 * Created by Kuznetsov on 08/05/2017.
 */
/*
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex) {

        ModelAndView mav = new ModelAndView("pages/static-page");
        mav.addObject("title", "Ошибка " + ex.getErrCode());
        mav.addObject("content", ex.getErrMsg());

        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {

        ModelAndView mav = new ModelAndView("pages/static-page");

        mav.addObject("title", "Ошибка");
        mav.addObject("content", "Нам очень жаль, но что-то пошло не так :(");

        return mav;
    }
}
*/
