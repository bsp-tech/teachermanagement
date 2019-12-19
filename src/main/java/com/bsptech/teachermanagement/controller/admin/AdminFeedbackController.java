/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.FeedbackDataInter;
import com.bsptech.teachermanagement.entity.Feedback;
import java.util.Date;
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
@RequestMapping("/admin/feedbacks")
public class AdminFeedbackController {

    @Autowired
    private FeedbackDataInter feedbackDataInter;

    @GetMapping
    public ModelAndView page(ModelAndView modelAndView) {

        Iterable<Feedback> feedbacks = feedbackDataInter.findAll();
        modelAndView.addObject("feedbacks", feedbacks);
        modelAndView.setViewName("admin/feedbacks");
        return modelAndView;

    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("feedback") Feedback feedback, ModelAndView modelAndView) {

        feedback.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        feedbackDataInter.save(feedback);
        return new ModelAndView("redirect:/admin/feedbacks");

    }

    @PostMapping(value = "/update")
    public ModelAndView update(@RequestParam(value = "id") Integer id,
            @RequestParam(value = "authorName", required = false) String authorName,
            @RequestParam(value = "content", required = false) String content, ModelAndView modelAndView) {

        if ((authorName != null && !authorName.isEmpty()) || (content != null && !content.isEmpty())) {

            Feedback feedback = feedbackDataInter.findById(id).get();

            if (authorName != null && !authorName.isEmpty()) {
                feedback.setAuthorName(authorName);
            }
            if (content != null && !content.isEmpty()) {
                feedback.setContent(content);
            }

            feedback.setLastUpdateTime(new java.sql.Date(new Date().getTime()));
            feedbackDataInter.save(feedback);

        }
        return new ModelAndView("redirect:/admin/feedbacks");

    }
    
    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam(value = "id") Integer id, ModelAndView modelAndView) {
        
        feedbackDataInter.deleteById(id);
        return new ModelAndView("redirect:/admin/feedbacks");

    }

}
