/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.service.inter.ClassServiceInter;
import com.bsptech.teachermanagement.service.inter.LessonServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private LessonServiceInter lessonServiceInter;

    @Autowired
    private ClassServiceInter classServiceInter;

    @RequestMapping(path = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        List<Lesson> lessons = lessonServiceInter.findAll();
        List<Class> classes = classServiceInter.findAll();
        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("classes", classes);
        modelAndView.setViewName("user/form");
        return modelAndView;
    }


}
