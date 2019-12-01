/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.ClassDataInter;
import com.bsptech.teachermanagement.dao.ClassLessonDataInter;
import com.bsptech.teachermanagement.dao.LessonDataInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.entity.ClassLesson;
import com.bsptech.teachermanagement.entity.Lesson;
import java.util.Date;
import java.util.Optional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author murad_isgandar
 */
@Controller
@RequestMapping("/admin/classes")
public class AdminClassController {

    @Autowired
    private ClassDataInter classDataInter;
    
    @Autowired
    private LessonDataInter lessonDataInter;
    
    @Autowired
    private ClassLessonDataInter classLessonDataInter;
    
    @GetMapping
    public ModelAndView page(ModelAndView modelAndView) {

        Iterable<Class> classes = classDataInter.findAll();
        Iterable<Lesson> lessons = lessonDataInter.findAll();
        Iterable<ClassLesson> classLessons = classLessonDataInter.findAll();
        modelAndView.addObject("classes", classes);
        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("classLessons", classLessons);
        modelAndView.setViewName("admin/classes");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("class") Class classes) {

        classes.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        classDataInter.save(classes);
        
        return new ModelAndView("redirect:/admin/classes");
    }
    
    @PostMapping(value = "/update")
    public ModelAndView update(@RequestParam(name = "id") Integer id,@RequestParam(name = "name",required = false) String name) {

        if(name!=null && !name.isEmpty()){
            Optional<Class> result = classDataInter.findById(id);
            Class clss = result.get();
            
            clss.setName(name);
            clss.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
            
            classDataInter.save(clss);
        }
        
        return new ModelAndView("redirect:/admin/classes");
    }
    
    @PostMapping(value = "/delete")
    public ModelAndView delete(@ModelAttribute("id") Integer id) {

        classDataInter.deleteById(id);
        return new ModelAndView("redirect:/admin/classes");
    }
    
    @PostMapping(value = "/addClassLesson")
    public ModelAndView addClassLesson(@ModelAttribute("classLesson") ClassLesson classLesson) {
        classLessonDataInter.save(classLesson);
        
        return new ModelAndView("redirect:/admin/classes");
    }
    
    @PostMapping(value = "/deleteClassLesson")
    public ModelAndView deleteClassLesson(@RequestParam("id") Integer id) {
        classLessonDataInter.deleteById(id);
        
        return new ModelAndView("redirect:/admin/classes");
    }
    

}
