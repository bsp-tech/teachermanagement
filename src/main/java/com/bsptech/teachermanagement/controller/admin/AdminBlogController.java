/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.PostDataInter;
import com.bsptech.teachermanagement.entity.Post;
import com.bsptech.teachermanagement.entity.User;
import com.google.gson.Gson;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author murad_isgandar
 */
@Controller
@RequestMapping("/admin/blogs")
public class AdminBlogController {

    @Autowired
    private PostDataInter postdataInter;


    @GetMapping
    public ModelAndView page(ModelAndView modelAndView) {

        modelAndView.addObject("blogs", postdataInter.findAll());
        modelAndView.setViewName("admin/blogs");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addPost(@ModelAttribute("post") Post post) {
        post.setApproved((short) 0);
        post.setInsertDateTime(new Date());
        postdataInter.save(post);
        return new ModelAndView("redirect:/admin/blogs");
    }

    @PostMapping("/update")
    public ModelAndView updatePost(@ModelAttribute("post") Post post, @RequestParam("id") Integer id) {
        post.setId(id);
        post.setLastUpdateTime(new Date());
        postdataInter.save(post);
        return new ModelAndView("redirect:/admin/blogs");
    }

    @RequestMapping("delete/{id}")
    public ModelAndView delete(ModelAndView modelAndView, @PathVariable("id") Integer id) {
        postdataInter.deleteById(id);
        modelAndView.setViewName("redirect:/admin/blogs");
        return modelAndView;
    }
}