/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller;

import com.bsptech.teachermanagement.entity.Support;
import com.bsptech.teachermanagement.service.inter.SupportServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("contact");
        return modelAndView;
    }


    @RequestMapping(path ={"/addContact"} , method = {RequestMethod.POST})
    public @ResponseBody
    String addContact(@RequestParam("comboDepartment") String comboDepartment, @RequestParam("nameSurnameContact") String nameSurnameContact,
                      @RequestParam("emailContact") String emailContact, @RequestParam("subjectContact") String subjectContact,
                      @RequestParam("messageContact") String messageContact) {

        String response = "failed";

        Support support = new Support();
        support.setDepartmentId(Integer.parseInt(comboDepartment));
        support.setFullname(nameSurnameContact);
        support.setEmail(emailContact);
        support.setSubject(subjectContact);
        support.setMessage(messageContact);
        support.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        support.setStatus(1);
        Support sup = supportServiceInter.save(support);

        if (sup.getStatus() == 1) {

            response = "success";

        } else {

            response = "failed";
        }

        return response;
    }


}
