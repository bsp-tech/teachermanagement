/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.entity.WebsiteSettings;
import com.bsptech.teachermanagement.service.inter.ClassServiceInter;
import com.bsptech.teachermanagement.service.inter.LessonServiceInter;
import com.bsptech.teachermanagement.service.inter.WebsiteSettingsInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/class")
public class ClassController {

    @Autowired
    ClassServiceInter classInter;

    @Autowired
    WebsiteSettingsInter websiteSettingsInter;

    @Autowired
    LessonServiceInter lessonServiceInter;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        Integer id = 1;
        List<Class> list = classInter.findAllOrderByName();
        List<Lesson> lessons=lessonServiceInter.findAll();
        WebsiteSettings settings = websiteSettingsInter.findById(id);

        modelAndView.addObject("classes", list);
        modelAndView.addObject("lessons",lessons);
        modelAndView.addObject("settings", settings);
        modelAndView.setViewName("class/index");
        return modelAndView;
    }


}
