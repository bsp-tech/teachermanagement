package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.FAQDataInter;
import com.bsptech.teachermanagement.entity.FAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/faqs")
public class AdminFaqController {

    @Autowired
    FAQDataInter faqDataInter;

    @GetMapping
    public ModelAndView faq(ModelAndView modelAndView){
        List<FAQ> faqs = (List<FAQ>) faqDataInter.findAll();
        modelAndView.addObject("faqs",faqs);
        modelAndView.setViewName("admin/faqs");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addFaq(ModelAndView modelAndView, @ModelAttribute("faq") FAQ faq){

        faq.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        faqDataInter.save(faq);

        modelAndView.setViewName("redirect:/admin/faqs");
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateFaq(ModelAndView modelAndView, @ModelAttribute("faq") FAQ f){

        FAQ faq = faqDataInter.findById(f.getId()).get();

        faq.setHeader(f.getHeader());
        faq.setContent(f.getContent());
        faq.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
        faqDataInter.save(faq);
        modelAndView.setViewName("redirect:/admin/faqs");

        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteFaq(ModelAndView modelAndView, @RequestParam(name = "id") Integer id){

        if(id == null){
            modelAndView.setViewName("redirect:/admin/faqs?success=false");
        } else {
            FAQ faq = faqDataInter.findById(id).get();
            faqDataInter.delete(faq);
            modelAndView.setViewName("redirect:/admin/faqs");
        }
        return  modelAndView;
    }

}
