/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.WebsiteSettingDataInter;
import com.bsptech.teachermanagement.entity.WebsiteSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author murad_isgandar
 */
@Controller
@RequestMapping("/admin")
public class WebsiteSettingsController {
    
    @Autowired
    WebsiteSettingDataInter websiteSettingDataInter;
    
    @GetMapping("/setting")
    public ModelAndView page(ModelAndView modelAndView) {
        Iterable<WebsiteSettings> settings = websiteSettingDataInter.findAll();
        
        
        
        modelAndView.addObject("settings",settings);
        modelAndView.setViewName("admin/websitesetting");
        return modelAndView;
    }
    
}
