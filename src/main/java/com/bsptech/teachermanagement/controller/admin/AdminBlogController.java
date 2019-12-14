/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.PostDataInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author murad_isgandar
 */
@Controller
@RequestMapping("/admin/blogs")
public class AdminBlogController {
    
    @Autowired
    private PostDataInter postdataInter;
    
    
    @GetMapping
    public ModelAndView page(ModelAndView modelAndView) {
        
        modelAndView.addObject("blogs", postdataInter.findAll());
        modelAndView.setViewName("admin/blogs");
        return modelAndView;
    }
    
}
