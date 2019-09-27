/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;
import com.bsptech.teachermanagement.entity.Department;
import com.bsptech.teachermanagement.entity.Status;
import com.bsptech.teachermanagement.entity.Support;
import com.bsptech.teachermanagement.service.inter.DepartmentServiceInter;
import com.bsptech.teachermanagement.service.inter.StatusServiceInter;
import com.bsptech.teachermanagement.service.inter.SupportServiceInter;
import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.security.auth.Subject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.Subject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Goshgar
 */
@Controller
public class ContactController {


    @Autowired
    SupportServiceInter supportServiceInter;
    @Autowired
    DepartmentServiceInter departmentServiceInter;

    @Autowired
    StatusServiceInter statusServiceInter;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        List<Department> departments=departmentServiceInter.findAll();
        modelAndView.setViewName("contact");
        modelAndView.addObject("departments",departments);
        return modelAndView;
    }

    @RequestMapping(path ={"/addContact"} , method = {RequestMethod.POST})
    public ModelAndView addContact(@RequestParam("comboDepartment") String comboDepartment, @RequestParam("nameSurnameContact") String nameSurnameContact,
                                   @RequestParam("emailContact") String emailContact, @RequestParam("subjectContact") String subjectContact,
                                   @RequestParam("messageContact") String messageContact) {


        ModelAndView modelAndView=new ModelAndView("redirect:/contact");

        Integer id=1;
        Status status=statusServiceInter.findById(id);
        Department department=departmentServiceInter.findById(Integer.parseInt(comboDepartment));

        Support support = new Support();
        support.setDepartmentId(department);
        support.setFullname(nameSurnameContact);
        support.setEmail(emailContact);
        support.setSubject(subjectContact);
        support.setMessage(messageContact);
        support.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        support.setStatusId(status);
        supportServiceInter.save(support);


        return modelAndView;
    }

}
