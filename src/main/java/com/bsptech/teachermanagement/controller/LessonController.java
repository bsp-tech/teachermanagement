/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.entity.Section;
import com.bsptech.teachermanagement.entity.WebsiteSettings;
import com.bsptech.teachermanagement.service.inter.ClassServiceInter;
import com.bsptech.teachermanagement.service.inter.LessonServiceInter;
import com.bsptech.teachermanagement.service.inter.SectionServiceInter;
import com.bsptech.teachermanagement.service.inter.WebsiteSettingsInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Goshgar
 */
@Controller
@RequestMapping(value = "/lessons")
public class LessonController {

    @Autowired
    private LessonServiceInter lessonServiceInter;

    @Autowired
    private SectionServiceInter sectionServiceInter;

    @Autowired
    private ClassServiceInter classServiceInter;


    @Autowired
    private WebsiteSettingsInter websiteSettingsInter;

    @RequestMapping("/details/{sectionId}")
    public ModelAndView details(@PathVariable("sectionId") Integer sectionId, ModelAndView modelAndView) {
        Section section = sectionServiceInter.findById(sectionId);
        modelAndView.addObject("section", section);
        modelAndView.setViewName("lesson/details");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sections/{lessonId}")
    public ModelAndView sections(@PathVariable("lessonId") Integer lessonId, ModelAndView modelAndView) {
        Integer id = 1;
        Lesson lesson = lessonServiceInter.findById(lessonId);
        WebsiteSettings settings=websiteSettingsInter.findById(id);
        List<Lesson> lessons = lessonServiceInter.findAll();
        List<Class> classes = classServiceInter.findAll();
        lesson.getLessonSectionList();
        modelAndView.addObject("lesson", lesson);
        modelAndView.addObject("settings",settings);
        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("classes", classes);
        modelAndView.setViewName("lesson/sections");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        List<Lesson> lessons = lessonServiceInter.findAll();
        List<Class> classes = classServiceInter.findAll();
        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("classes", classes);
        modelAndView.setViewName("lesson/lessons");
        return modelAndView;
    }


}
