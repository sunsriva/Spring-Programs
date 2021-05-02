package com.github.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController is used for swagger-ui
 * @author Sunny Srivastava
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView swagger() {
        return new ModelAndView("redirect:/swagger-ui.html");
    }

}
