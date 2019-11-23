
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.dao.FAQDataInter;
import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.entity.Feedback;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.entity.WebsiteSettings;
import com.bsptech.teachermanagement.service.inter.ClassServiceInter;
import com.bsptech.teachermanagement.service.inter.FeedbackServiceInter;
import com.bsptech.teachermanagement.service.inter.LessonServiceInter;
import com.bsptech.teachermanagement.service.inter.WebsiteSettingsInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Goshgar
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private WebsiteSettingsInter websiteSettingsInter;

    @Autowired
    private FeedbackServiceInter feedbackServiceInter;
@Autowired
    FAQDataInter faqDataInter;
    @Autowired
    private LessonServiceInter lessonServiceInter;

    @Autowired
    private ClassServiceInter classServiceInter;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        Integer id = 1;
        WebsiteSettings websiteSettings = websiteSettingsInter.findById(id);
        List<Feedback> feedbacks = feedbackServiceInter.findAll();
        List<Class> classes = classServiceInter.findAll();
        List<Lesson> lessons = lessonServiceInter.findAll();
        Lesson lesson = lessonServiceInter.findById(id);
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("settings", websiteSettings);
        modelAndView.addObject("sections", lesson.getLessonSectionList());
        modelAndView.addObject("feedbacks", feedbacks);
        modelAndView.addObject("faqs",faqDataInter.findAll());
        modelAndView.setViewName("layouts/footer");
        modelAndView.setViewName("index");
        return modelAndView;
    }

}

