package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.DepartmentDataInter;
import com.bsptech.teachermanagement.entity.Department;
import com.bsptech.teachermanagement.service.inter.DepartmentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentServiceInter {

    @Autowired
    DepartmentDataInter departmentDataInter;


    @Override
    public List<Department> findAll() {

        return (List<Department>) departmentDataInter.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentDataInter.findById(id).get();
    }
}
