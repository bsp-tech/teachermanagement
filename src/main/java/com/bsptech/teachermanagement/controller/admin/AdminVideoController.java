/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.SectionDataInter;
import com.bsptech.teachermanagement.dao.VideoDataInter;
import com.bsptech.teachermanagement.entity.Section;
import com.bsptech.teachermanagement.entity.Video;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView update(@RequestParam("id") Integer id, @RequestParam(name = "header", required = false) String header,
            @RequestParam(name = "url", required = false) String url,
            @RequestParam(name = "sectionId", required = false) Section sectionId) {

        if ((header != null && !header.isEmpty()) || (url != null && !url.isEmpty()) || (sectionId != null)) {
            Video video = videoDataInter.findById(id).get();

            if (header != null && !header.isEmpty()) {
                video.setHeader(header);
            }
            if (url != null && !url.isEmpty()) {
                video.setUrl(url);
            }
            if (sectionId != null) {
                video.setSectionId(sectionId);
            }

            video.setLastUpdateTime(new java.sql.Date(new Date().getTime()));
            videoDataInter.save(video);

        }

        return new ModelAndView("redirect:/admin/videos");

    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam("id") Integer id) {

        videoDataInter.deleteById(id);
        return new ModelAndView("redirect:/admin/videos");

    }

}
