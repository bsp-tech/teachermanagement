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
    public ModelAndView update(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "author_name", required = false) String author_name,
            @RequestParam(name = "autobiography", required = false) String autobiography, @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "phone", required = false) String phone, @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "aboutImgPath", required = false) String aboutImgPath,
            @RequestParam(name = "bannerPath", required = false) String bannerPath,
            @RequestParam(name = "contactImgPath", required = false) String contactImgPath,
            @RequestParam(name = "introduceVideoUrl", required = false) String introduceVideoUrl,
            @RequestParam(name = "facebookUrl", required = false) String facebookUrl,
            @RequestParam(name = "instagramUrl", required = false) String instagramUrl,
            @RequestParam(name = "youtubeUrl", required = false) String youtubeUrl,
            @RequestParam(name = "whatsappUrl", required = false) String whatsappUrl
    ) {

        if ((author_name != null && !author_name.isEmpty()) || (autobiography != null && !autobiography.isEmpty())
                || (description != null && !description.isEmpty()) || (phone != null && !phone.isEmpty())
                || (email != null && !email.isEmpty()) || (aboutImgPath != null && !aboutImgPath.isEmpty())
                || (bannerPath != null && !bannerPath.isEmpty()) || (contactImgPath != null && !contactImgPath.isEmpty())
                || (introduceVideoUrl != null && !introduceVideoUrl.isEmpty())
                || (facebookUrl != null && !facebookUrl.isEmpty())
                || (instagramUrl != null && !instagramUrl.isEmpty())
                || (youtubeUrl != null && !youtubeUrl.isEmpty())
                || (whatsappUrl != null && !whatsappUrl.isEmpty())) {
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
            if (facebookUrl != null && !facebookUrl.isEmpty()) {
                settings.setFacebookUrl(facebookUrl);
            }
            if (instagramUrl != null && !instagramUrl.isEmpty()) {
                settings.setInstagramUrl(instagramUrl);
            }
            if (youtubeUrl != null && !youtubeUrl.isEmpty()) {
                settings.setYoutubeUrl(youtubeUrl);
            }
            if (whatsappUrl != null && !whatsappUrl.isEmpty()) {
                settings.setWhatsappUrl(whatsappUrl);
            }

            settings.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));

            websiteSettingDataInter.save(settings);

        }

        ModelAndView modelAndView = new ModelAndView("redirect:/admin/settings");
        return modelAndView;
    }

}
