/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.controller.admin;

import com.bsptech.teachermanagement.dao.DepartmentDataInter;
import com.bsptech.teachermanagement.entity.Department;
import java.util.Date;
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
@RequestMapping("/admin/departments")
public class AdminDepartmentController {

    @Autowired
    private DepartmentDataInter departmentDataInter;

    @GetMapping
    public ModelAndView page(ModelAndView modelAndView) {

        modelAndView.addObject("departments", departmentDataInter.findAll());
        modelAndView.setViewName("admin/departments");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("department") Department department) {

        department.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        departmentDataInter.save(department);
        return new ModelAndView("redirect:/admin/departments");
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute("UpdateDepartmens") Department d, @RequestParam(value = "id") Integer id) {

        Department department = departmentDataInter.findById(id).get();
        department.setName(d.getName());
        department.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
        departmentDataInter.save(department);

        return new ModelAndView("redirect:/admin/departments");
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam(value = "id") Integer id) {

        departmentDataInter.deleteById(id);
        return new ModelAndView("redirect:/admin/departments");
    }

}
