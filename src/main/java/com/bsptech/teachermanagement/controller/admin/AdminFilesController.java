package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.FileDataInter;
import com.bsptech.teachermanagement.dao.SectionDataInter;
import com.bsptech.teachermanagement.entity.File;
import com.bsptech.teachermanagement.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/files")
public class AdminFilesController {

    @Autowired
    FileDataInter fileDataInter;

    @Autowired
    SectionDataInter sectionDataInter;

    @GetMapping
    public ModelAndView files(ModelAndView modelAndView, @RequestParam(name = "sid",required = false) Integer id){

        List<File> files = new ArrayList<>();

        if(id == null){
            files = (List<File>) fileDataInter.findAll();
        } else {
            files = fileDataInter.findAllBySectionIdId(id);
        }

        List<Section> sections = (List<Section>) sectionDataInter.findAll();

        modelAndView.addObject("sections",sections);
        modelAndView.addObject("files",files);
        modelAndView.setViewName("admin/files");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addFile(ModelAndView modelAndView,@ModelAttribute("file") File file,
                                 @RequestParam(name = "sectionId") Integer id){

        Section section = sectionDataInter.findById(id).get();

        file.setId(3);
        file.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        file.setSectionId(section);
        fileDataInter.save(file);
        modelAndView.setViewName("redirect:/admin/files");
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateFile(ModelAndView modelAndView,
                                   @ModelAttribute("file") File f,
                                   @RequestParam(name = "sectionId") Integer sectionId){

        File file = fileDataInter.findById(f.getId()).get();
        Section section = sectionDataInter.findById(sectionId).get();

        file.setName(f.getName());
        file.setUrl(f.getUrl());
        file.setSectionId(section);
        file.setLastUpdateTime(new java.sql.Date(new Date().getTime()));

        fileDataInter.save(file);

        modelAndView.setViewName("redirect:/admin/files");
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteFile(ModelAndView modelAndView,@RequestParam(name = "id") Integer id){

        if(id == null){
            modelAndView.setViewName("/admin/files?success=false");
        } else {
            File file = fileDataInter.findById(id).get();
            fileDataInter.delete(file);
            modelAndView.setViewName("redirect:/admin/files");
        }

        return modelAndView;
    }
}