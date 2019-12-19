/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.SectionDataInter;
import com.bsptech.teachermanagement.dao.SectionFeedbackDataInter;
import com.bsptech.teachermanagement.entity.Section;
import com.bsptech.teachermanagement.entity.SectionFeedback;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author murad_isgandar
 */
@Controller
@RequestMapping("/admin/sectionfeedbacks")
public class AdminSectionFeedbackController {

    @Autowired
    private SectionFeedbackDataInter sectionFeedbackDataInter;

    @Autowired
    private SectionDataInter sectionDataInter;

    @GetMapping
    public ModelAndView page(@RequestParam(value = "sectionId", required = false) Integer id, ModelAndView modelAndView) {

        if (id != null) {

            Section section = sectionDataInter.findById(id).get();
            List<SectionFeedback> sectionFeedbacks = section.getSectionFeedbackList();
            modelAndView.addObject("sectionfeedbacks", sectionFeedbacks);
        } else {
            modelAndView.addObject("sectionfeedbacks", sectionFeedbackDataInter.findAll());
            modelAndView.addObject("sections", sectionDataInter.findAll());
        }

        modelAndView.setViewName("admin/sectionfeedbacks");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("sectionFeedback") SectionFeedback sectionFeedback) {
        sectionFeedback.setInsertDateTime(new java.sql.Date(new Date().getTime()));

        sectionFeedbackDataInter.save(sectionFeedback);

        return new ModelAndView("redirect:/admin/sectionfeedbacks");
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("sectionfeedback") SectionFeedback sf) {
        SectionFeedback sectionFeedback = sectionFeedbackDataInter.findById(sf.getId()).get();
        sectionFeedback.setAuthorName(sf.getAuthorName());
        sectionFeedback.setContent(sf.getContent());
        sectionFeedback.setSectionId(sf.getSectionId());

        sectionFeedback.setLastUpdateTime(new java.sql.Date(new Date().getTime()));
        sectionFeedbackDataInter.save(sectionFeedback);
        
        return new ModelAndView("redirect:/admin/sectionfeedbacks");
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "id") Integer id) {

        sectionFeedbackDataInter.deleteById(id);
        return new ModelAndView("redirect:/admin/sectionfeedbacks");
    }

}
