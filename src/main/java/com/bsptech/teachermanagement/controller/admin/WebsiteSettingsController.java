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
@RequestMapping("/admin/settings")
public class WebsiteSettingsController {

    @Autowired
    WebsiteSettingDataInter websiteSettingDataInter;

    @GetMapping
    public ModelAndView page(ModelAndView modelAndView) {
        Iterable<WebsiteSettings> settings = websiteSettingDataInter.findAll();
        modelAndView.addObject("settings", settings);
        modelAndView.setViewName("admin/websitesetting");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("admin") WebsiteSettings websiteSettings) {
        long l = websiteSettingDataInter.count();

        if (l == 0) {
            websiteSettings.setInsertDateTime(new java.sql.Date(new Date().getTime()));
            websiteSettingDataInter.save(websiteSettings);
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/admin/settings");

        return modelAndView;
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute("settings") WebsiteSettings settings, @RequestParam(name = "id", required = false) Integer id
    ) {

        WebsiteSettings websiteSettings = websiteSettingDataInter.findById(id).get();
        websiteSettings.setAuthor_name(settings.getAuthor_name());
        websiteSettings.setAutobiography(settings.getAutobiography());
        websiteSettings.setDescription(settings.getDescription());
        websiteSettings.setEmail(settings.getEmail());
        websiteSettings.setPhone(settings.getPhone());
        websiteSettings.setAboutImgPath(settings.getAboutImgPath());
        websiteSettings.setBannerPath(settings.getBannerPath());
        websiteSettings.setContactImgPath(settings.getContactImgPath());
        websiteSettings.setIntroduceVideoUrl(settings.getIntroduceVideoUrl());
        websiteSettings.setFacebookUrl(settings.getFacebookUrl());
        websiteSettings.setInstagramUrl(settings.getInstagramUrl());
        websiteSettings.setYoutubeUrl(settings.getYoutubeUrl());
        websiteSettings.setWhatsappUrl(settings.getWhatsappUrl());
        websiteSettings.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));

        websiteSettingDataInter.save(websiteSettings);
        return new ModelAndView("redirect:/admin/settings");
    }

}
