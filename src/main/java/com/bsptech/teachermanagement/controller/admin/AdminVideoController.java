/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.SectionDataInter;
import com.bsptech.teachermanagement.dao.VideoDataInter;
import com.bsptech.teachermanagement.entity.File;
import com.bsptech.teachermanagement.entity.Section;
import com.bsptech.teachermanagement.entity.Video;
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
@RequestMapping("/admin/videos")
public class AdminVideoController {

    @Autowired
    private VideoDataInter videoDataInter;

    @Autowired
    private SectionDataInter sectionDataInter;

    @GetMapping
    public ModelAndView page(@RequestParam(value = "sectionId", required = false) Integer id, ModelAndView modelAndView) {

        if (id != null) {
            Section section = sectionDataInter.findById(id).get();

            List<Video> videos = section.getVideoId();
            modelAndView.addObject("videos", videos);
        } else {
            modelAndView.addObject("sections", sectionDataInter.findAll());
            modelAndView.addObject("videos", videoDataInter.findAll());
        }

        modelAndView.setViewName("admin/videos");
        return modelAndView;

    }


    @PostMapping(value = "/add")
    public ModelAndView add(@RequestParam(name = "header") String header,
            @RequestParam(name = "url") String url, @RequestParam(name = "sectionId") Section sectionId) {

        Video video = new Video();
        video.setHeader(header);
        video.setUrl(url);
        video.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        video.setSectionId(sectionId);

        videoDataInter.save(video);

        return new ModelAndView("redirect:/admin/videos");

    }

    @PostMapping(value = "/update")
    public ModelAndView update(ModelAndView modelAndView,
                               @ModelAttribute("video") Video v,
                               @RequestParam(name = "sectionId") Integer sectionId) {

        Video video = videoDataInter.findById(v.getId()).get();
        Section section = sectionDataInter.findById(sectionId).get();

        video.setHeader(v.getHeader());
        video.setUrl(v.getUrl());
        video.setSectionId(section);
        video.setLastUpdateTime(new java.sql.Date(new Date().getTime()));

        videoDataInter.save(video);

        return new ModelAndView("redirect:/admin/videos");

    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam("id") Integer id) {

        videoDataInter.deleteById(id);
        return new ModelAndView("redirect:/admin/videos");

    }

}
