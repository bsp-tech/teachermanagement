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
@RequestMapping(value = "/about")
public class AboutController {

    @Autowired
    WebsiteSettingsInter websiteSettingsInter;

    @Autowired
    private LessonServiceInter lessonServiceInter;

    @Autowired
    private ClassServiceInter classServiceInter;

    @GetMapping
    public ModelAndView about(ModelAndView modelAndView) {
        Integer id = 1;
        WebsiteSettings websiteSettings = websiteSettingsInter.findById(id);
        List<Lesson> lessons = lessonServiceInter.findAll();
        List<Class> classes = classServiceInter.findAll();
        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("settings", websiteSettings);
        modelAndView.setViewName("about");
        return modelAndView;
    }
}
