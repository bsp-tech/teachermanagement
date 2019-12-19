package com.bsptech.teachermanagement.controller.rest;

import com.bsptech.teachermanagement.dao.FAQDataInter;
import com.bsptech.teachermanagement.dao.FeedbackDataInter;
import com.bsptech.teachermanagement.dao.FileDataInter;
import com.bsptech.teachermanagement.dao.VideoDataInter;
import com.bsptech.teachermanagement.entity.*;
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
    FAQDataInter faqDataInter;

    @Autowired
    FileDataInter fileDataInter;

    @Autowired
    VideoDataInter videoDataInter;

    @Autowired
    FeedbackDataInter feedbackDataInter;

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

    @RequestMapping("/faq/{id}")
    public Map<String, String> getFaqDetails(@PathVariable("id") Integer id){
        FAQ faq = faqDataInter.findById(id).get();
        Map<String, String> data = new HashMap<>();
        data.put("header",faq.getHeader());
        data.put("content",faq.getContent());
        return data;
    }

    @RequestMapping("/file/{id}")
    public Map<String, Object> getFileDetails(@PathVariable("id") Integer id){
        File file = fileDataInter.findById(id).get();
        Map<String,Object> data = new HashMap<>();
        data.put("name",file.getName());
        data.put("url",file.getUrl());
        data.put("sectionId",file.getSectionId().getId());
        return data;
    }

    @RequestMapping("/video/{id}")
    public Map<String, Object> getVideoDetails(@PathVariable("id") Integer id){
        Video video = videoDataInter.findById(id).get();
        Map<String, Object> data = new HashMap<>();
        data.put("header",video.getHeader());
        data.put("url",video.getUrl());
        data.put("sectionId",video.getSectionId().getId());
        return data;
    }

    @RequestMapping("/feedback/{id}")
    public Map<String, String> getFeedbackDetails(@PathVariable("id") Integer id){
        Feedback feedback = feedbackDataInter.findById(id).get();
        Map<String , String> data = new HashMap<>();
        data.put("authorName", feedback.getAuthorName());
        data.put("content",feedback.getContent());
        return data;
    }
}
