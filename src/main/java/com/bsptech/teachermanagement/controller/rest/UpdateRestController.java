package com.bsptech.teachermanagement.controller.rest;

import com.bsptech.teachermanagement.dao.ClassDataInter;
import com.bsptech.teachermanagement.dao.DepartmentDataInter;
import com.bsptech.teachermanagement.dao.LessonDataInter;
import com.bsptech.teachermanagement.dao.SectionDataInter;
import com.bsptech.teachermanagement.dao.WebsiteSettingDataInter;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.entity.Post;
import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.entity.Department;
import com.bsptech.teachermanagement.entity.Section;
import com.bsptech.teachermanagement.entity.WebsiteSettings;
import com.bsptech.teachermanagement.service.inter.PostServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/getData")
public class UpdateRestController {

    @Autowired
    PostServiceInter postServiceInter;

    
    
    
    
    
    
    
    
    
    
    @Autowired
    WebsiteSettingDataInter websiteSettingDataInter;

    @Autowired
    LessonDataInter lessonDataInter;
    
    @Autowired
    ClassDataInter classDataInter;
    
    @Autowired
    DepartmentDataInter departmentDataInter;
    
    @Autowired
    SectionDataInter sectionDataInter;
    
    
    @RequestMapping("/blog/{id}")
    public Map<String, String> getPostDetails(@PathVariable("id") Integer id) {
        Post post = postServiceInter.findById(id);
        Map<String, String> data = new HashMap<>();
        data.put("title", post.getTitle());
        data.put("thumbnailPath", post.getThumbnailPath());
        data.put("content", post.getContent());
        System.out.println("I am sended data");
        return data;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @RequestMapping("/settings/{id}")
    public Map<String, String> getWebSettingsDetails(@PathVariable("id") Integer id) {
        WebsiteSettings settings = websiteSettingDataInter.findById(id).get();
        Map<String, String> data = new HashMap<>();
        data.put("author_name", settings.getAuthor_name());
        data.put("autobiography", settings.getAutobiography());
        data.put("description", settings.getDescription());
        data.put("phone", settings.getPhone());
        data.put("email", settings.getEmail());
        data.put("aboutImgPath", settings.getAboutImgPath());
        data.put("bannerPath", settings.getBannerPath());
        data.put("contactImgPath", settings.getContactImgPath());
        data.put("introduceVideoUrl", settings.getIntroduceVideoUrl());
        data.put("facebookUrl", settings.getFacebookUrl());
        data.put("instagramUrl", settings.getInstagramUrl());
        data.put("youtubeUrl", settings.getYoutubeUrl());
        data.put("whatsappUrl", settings.getWhatsappUrl());
        
        return data;
    }
    
    
    @RequestMapping("/lesson/{id}")
    public Map<String, String> getlessonDetails(@PathVariable("id") Integer id) {
        Lesson lesson = lessonDataInter.findById(id).get();
        Map<String, String> data = new HashMap<>();
        data.put("name", lesson.getName());
        data.put("about", lesson.getAbout());
        data.put("thumbnailPath", lesson.getThumbnailPath());
        return data;
    }
    
    
    @RequestMapping("/class/{id}")
    public Map<String, String> getclasseDetails(@PathVariable("id") Integer id) {
        Class classs = classDataInter.findById(id).get();
        Map<String, String> data = new HashMap<>();
        data.put("name", classs.getName());
        return data;
    }
    
    @RequestMapping("/department/{id}")
    public Map<String, String> getDepartmentDetails(@PathVariable("id") Integer id) {
        Department department = departmentDataInter.findById(id).get();
        Map<String, String> data = new HashMap<>();
        data.put("name", department.getName());
        return data;
    }
    
    @RequestMapping("/section/{id}")
    public Map<String, String> getSectionDetails(@PathVariable("id") Integer id) {
        Section section = sectionDataInter.findById(id).get();
        Map<String, String> data = new HashMap<>();
        data.put("name", section.getName());
        data.put("about", section.getAbout());
        data.put("playlistUrl", section.getPlaylistUrl());
        data.put("threadFilesPath", section.getThreadFilesPath());
        data.put("thumbnailPath", section.getThumbnailPath());
        data.put("price", String.valueOf(section.getPrice()));
        
        return data;
    }
    
}
