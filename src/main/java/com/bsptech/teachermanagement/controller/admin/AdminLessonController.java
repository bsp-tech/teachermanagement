/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.LessonDataInter;
import com.bsptech.teachermanagement.entity.Lesson;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author murad_isgandar
 */
@Controller
@RequestMapping("/admin")
public class AdminLessonController {
    
    @Autowired
    private LessonDataInter lessonDataInter;
    
    @GetMapping("/lessons")
    public ModelAndView page(ModelAndView modelAndView) {
        
        Iterable<Lesson> lessons = lessonDataInter.findAll();
        modelAndView.addObject("lessons",lessons);
        modelAndView.setViewName("/admin/lessons");
        
        return modelAndView;
    }
    
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Integer id,ModelAndView modelAndView) {
        lessonDataInter.deleteById(id);
        
        modelAndView.setViewName("redirect:/admin/lessons");
        
        return modelAndView;
    }
    
    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("admin") Lesson lessons,ModelAndView modelAndView) {
        
        lessons.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        lessonDataInter.save(lessons);
        modelAndView.setViewName("redirect:/admin/lessons");
        
        return modelAndView;
    }
    
}
