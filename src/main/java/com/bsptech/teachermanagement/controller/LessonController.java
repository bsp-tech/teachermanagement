/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Goshgar
 */
@Controller
@RequestMapping(value = "/lessons")
public class LessonController {

    @RequestMapping("/details")
    public ModelAndView details(ModelAndView modelAndView) {
        modelAndView.setViewName("lesson/details");
        return modelAndView;
    }

    @RequestMapping("/sections")
    public ModelAndView sections(ModelAndView modelAndView) {
        modelAndView.setViewName("lesson/sections");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("lesson/lessons");
        return modelAndView;
    }


}
