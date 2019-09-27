package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.entity.WebsiteSettings;
import com.bsptech.teachermanagement.service.inter.WebsiteSettingsInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/about")
public class AboutController {

    @Autowired
    WebsiteSettingsInter websiteSettingsInter;

    @GetMapping
    public ModelAndView about(ModelAndView modelAndView) {
        Integer id = 1;
        WebsiteSettings websiteSettings = websiteSettingsInter.findById(id);
        modelAndView.addObject("settings", websiteSettings);
        modelAndView.setViewName("about");
        return modelAndView;
    }
}
