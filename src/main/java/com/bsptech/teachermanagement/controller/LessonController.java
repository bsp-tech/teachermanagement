/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.entity.Section;
import com.bsptech.teachermanagement.service.inter.LessonServiceInter;
import com.bsptech.teachermanagement.service.inter.SectionServiceInter;
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

    @RequestMapping("/details/{sectionId}")
    public ModelAndView details(@PathVariable("sectionId")Integer sectionId,ModelAndView modelAndView) {
        Section section=sectionServiceInter.findById(sectionId);
        modelAndView.addObject("section",section);
        modelAndView.setViewName("lesson/details");
        return modelAndView;
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/sections/{lessonId}")
    public ModelAndView sections(@PathVariable("lessonId")Integer lessonId, ModelAndView modelAndView) {
        Lesson lesson=lessonServiceInter.findById(lessonId);
        lesson.getLessonSectionList();
        modelAndView.addObject("lesson",lesson);
        modelAndView.setViewName("lesson/sections");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        List<Lesson> lessonList=lessonServiceInter.findAll();
        modelAndView.addObject("lessonList",lessonList);
        modelAndView.setViewName("lesson/lessons");
        return modelAndView;
    }


}
