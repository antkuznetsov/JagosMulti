package ru.innopolis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kuznetsov on 08/05/2017.
 */

@Controller
public class ErrorsController {

    @RequestMapping(value = "/errors/", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView mav = new ModelAndView("pages/static-page");
        String errorMsg = "";

        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Internal Server Error";
                break;
            }
        }
        mav.addObject("title", "Ошибка " + httpErrorCode);
        mav.addObject("content", errorMsg);

        return mav;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }
}
