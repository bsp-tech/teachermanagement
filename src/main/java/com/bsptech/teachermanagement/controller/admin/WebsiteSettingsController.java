/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.WebsiteSettingDataInter;
import com.bsptech.teachermanagement.entity.WebsiteSettings;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class WebsiteSettingsController {

    @Autowired
    WebsiteSettingDataInter websiteSettingDataInter;

    @GetMapping("/setting")
    public ModelAndView page(ModelAndView modelAndView) {
        Iterable<WebsiteSettings> settings = websiteSettingDataInter.findAll();
        modelAndView.addObject("settings", settings);
        modelAndView.setViewName("admin/websitesetting");
        return modelAndView;
    }

    @PostMapping("/addSettings")
    public ModelAndView add(@ModelAttribute("admin") WebsiteSettings websiteSettings, ModelAndView modelAndView) {

        websiteSettings.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        websiteSettingDataInter.save(websiteSettings);
        modelAndView.setViewName("redirect:/admin/setting");
        return modelAndView;
    }

    @PostMapping("/updateSettings")
    public ModelAndView update(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "author_name", required = false) String author_name,
            @RequestParam(name = "autobiography", required = false) String autobiography, @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "phone", required = false) String phone, @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "aboutImgPath", required = false) String aboutImgPath,
            @RequestParam(name = "bannerPath", required = false) String bannerPath,
            @RequestParam(name = "contactImgPath", required = false) String contactImgPath,
            @RequestParam(name = "introduceVideoUrl", required = false) String introduceVideoUrl, ModelAndView modelAndView
    ) {

        Optional<WebsiteSettings> optional = websiteSettingDataInter.findById(id);
        WebsiteSettings settings = optional.get();

        if (author_name != null && !author_name.isEmpty()) {
            settings.setAuthor_name(author_name);
        }
        if (autobiography != null && !autobiography.isEmpty()) {
            settings.setAutobiography(autobiography);
        }
        if (description != null && !description.isEmpty()) {
            settings.setDescription(description);
        }
        if (phone != null && !phone.isEmpty()) {
            settings.setPhone(phone);
        }
        if (email != null && !email.isEmpty()) {
            settings.setEmail(email);
        }
        if (aboutImgPath != null && !aboutImgPath.isEmpty()) {
            settings.setAboutImgPath(aboutImgPath);
        }
        if (bannerPath != null && !bannerPath.isEmpty()) {
            settings.setBannerPath(bannerPath);
        }
        if (contactImgPath != null && !contactImgPath.isEmpty()) {
            settings.setContactImgPath(contactImgPath);
        }
        if (introduceVideoUrl != null && !introduceVideoUrl.isEmpty()) {
            settings.setIntroduceVideoUrl(introduceVideoUrl);
        }

        settings.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));

        websiteSettingDataInter.save(settings);

        modelAndView.setViewName("redirect:/admin/setting");
        return modelAndView;
    }

}
