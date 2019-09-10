/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Goshgar
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("blog/index");
        return modelAndView;
    }

    @RequestMapping(path = "/detail")
    public ModelAndView page(ModelAndView modelAndView) {
        modelAndView.setViewName("blog/details");
        return modelAndView;
    }

}
