/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.LessonDataInter;
import com.bsptech.teachermanagement.dao.LessonSectionDataInter;
import com.bsptech.teachermanagement.dao.SectionDataInter;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.entity.LessonSection;
import com.bsptech.teachermanagement.entity.Section;
import java.util.Date;
import java.util.List;
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
@RequestMapping("/admin/lessons")
public class AdminLessonController {

    @Autowired
    private LessonDataInter lessonDataInter;

    @Autowired
    private SectionDataInter sectionDataInter;

    @Autowired
    private LessonSectionDataInter lessonSectionDataInter;

    @GetMapping
    public ModelAndView page(ModelAndView modelAndView) {

        Iterable<Lesson> lessons = lessonDataInter.findAll();
        Iterable<Section> sections = sectionDataInter.findAll();
        Iterable<LessonSection> lessonsection = lessonSectionDataInter.findAll();
        modelAndView.addObject("lessons", lessons);
        modelAndView.addObject("sections", sections);
        modelAndView.addObject("lessonsections", lessonsection);
        modelAndView.setViewName("admin/lessons");

        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam("name") String name,
            @RequestParam("about") String about,
            @RequestParam("thumbnailPath") String thumbnailPath,
            ModelAndView modelAndView) {
        if ((name != null && !name.isEmpty()) || (about != null && !about.isEmpty()) || (thumbnailPath != null && !thumbnailPath.isEmpty())) {
            List<Lesson> result = lessonDataInter.getLessonsForSearching(name, about, thumbnailPath);
            modelAndView.addObject("lessons", result);
            modelAndView.setViewName("admin/lessons");
        } else {
            return new ModelAndView("redirect:/admin/lessons");
        }

        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("lesson") Lesson lessons) {

        lessons.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        lessonDataInter.save(lessons);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/lessons");

        return modelAndView;
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute("updateLesson") Lesson l, @RequestParam(name = "id") Integer id
    ) {

        Lesson lesson = lessonDataInter.findById(id).get();
        lesson.setName(l.getName());
        lesson.setAbout(l.getAbout());
        lesson.setThumbnailPath(l.getThumbnailPath());
        
        lesson.setLastUpdateTime(new java.sql.Date(new Date().getTime()));

        lessonDataInter.save(lesson);

        ModelAndView modelAndView = new ModelAndView("redirect:/admin/lessons");
        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam("id") Integer id) {
        lessonDataInter.deleteById(id);

        ModelAndView modelAndView = new ModelAndView("redirect:/admin/lessons");
        return modelAndView;
    }

    @PostMapping(value = "/addLessonSection")
    public ModelAndView addLessonSection(@ModelAttribute("lessonSection") LessonSection lessonSection) {

        lessonSectionDataInter.save(lessonSection);
        return new ModelAndView("redirect:/admin/lessons");
    }

    @PostMapping(value = "/deleteLessonSection")
    public ModelAndView deleteLessonSection(@RequestParam("id") Integer id) {

        lessonSectionDataInter.deleteById(id);
        return new ModelAndView("redirect:/admin/lessons");
    }

}
