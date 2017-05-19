package ru.innopolis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kuznetsov on 01/05/2017.
 */

@Controller
public class PageController {

    @RequestMapping("/about/")
    public String about(Model model) {

        String content = "Текст о проекте.";

        model.addAttribute("title", "О проекте");
        model.addAttribute("content", content);

        return "pages/static-page";
    }

    @RequestMapping("/help/")
    public String help(Model model) {

        String content = "Текст с помощью.";

        model.addAttribute("title", "Помощь");
        model.addAttribute("content", content);

        return "pages/static-page";
    }

    @RequestMapping("/faq/")
    public String faq(Model model) {

        String content = "Текст с вопросами и ответами.";

        model.addAttribute("title", "Вопросы и ответы");
        model.addAttribute("content", content);

        return "pages/static-page";
    }

    @RequestMapping("/403/")
    public String error403(Model model) {

        String content = "Ошибка 403 — доступ запрещен.";

        model.addAttribute("title", "Доступ запрещен");
        model.addAttribute("content", content);

        return "pages/static-page";
    }
}