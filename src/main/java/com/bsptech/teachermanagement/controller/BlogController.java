/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.entity.Post;
import com.bsptech.teachermanagement.service.inter.ClassServiceInter;
import com.bsptech.teachermanagement.service.inter.LessonServiceInter;
import com.bsptech.teachermanagement.service.inter.PostServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Goshgar
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {


    @Autowired
    PostServiceInter postServiceInter;

    @Autowired
    private LessonServiceInter lessonServiceInter;

    @Autowired
    private ClassServiceInter classServiceInter;


   @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {

        List<Post> posts = postServiceInter.findAll();
        List<Lesson> lessons = lessonServiceInter.findAll();
        List<Class> classes = classServiceInter.findAll();

        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("classes", classes);

        modelAndView.addObject("posts", posts);
        modelAndView.setViewName("blog/index");
        return modelAndView;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ModelAndView details(ModelAndView modelAndView, @PathVariable("id") Integer id) {
        modelAndView.addObject("post", postServiceInter.findById(id));
        List<Lesson> lessons = lessonServiceInter.findAll();
        List<Class> classes = classServiceInter.findAll();

        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("classes", classes);
        modelAndView.setViewName("blog/details");
        return modelAndView;
    }

}
