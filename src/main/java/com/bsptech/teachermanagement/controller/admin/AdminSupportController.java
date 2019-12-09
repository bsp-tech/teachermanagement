package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.StatusDataInter;
import com.bsptech.teachermanagement.dao.SupportDataInter;
import com.bsptech.teachermanagement.entity.Status;
import com.bsptech.teachermanagement.entity.Support;
import org.apache.logging.log4j.status.StatusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/supports")
public class AdminSupportController {

    @Autowired
    SupportDataInter supportDataInter;

    @Autowired
    StatusDataInter statusDataInter;

    @GetMapping
    public ModelAndView supports(ModelAndView modelAndView){
        List<Support> supports = supportDataInter.findByOrderByStatusIdIdDescInsertDateTimeAsc();
        modelAndView.addObject("supports",supports);
        modelAndView.setViewName("admin/supports");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView solved(ModelAndView modelAndView, @PathVariable("id") Integer id){
        Status status = statusDataInter.findById(1).get();

        Support support =  supportDataInter.findById(id).get();
        support.setSolvedDateTime(new java.sql.Date(new Date().getTime()));
        support.setStatusId(status);

        supportDataInter.save(support);

        modelAndView.setViewName("redirect:/admin/supports");
        return modelAndView;
    }

}
