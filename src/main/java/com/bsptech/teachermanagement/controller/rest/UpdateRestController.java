package com.bsptech.teachermanagement.controller.rest;

import com.bsptech.teachermanagement.dao.FAQDataInter;
import com.bsptech.teachermanagement.entity.FAQ;
import com.bsptech.teachermanagement.entity.Post;
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
}
