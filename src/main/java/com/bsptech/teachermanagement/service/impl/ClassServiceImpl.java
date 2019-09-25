package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.ClassDataInter;
import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.service.inter.ClassServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassServiceInter {

    @Autowired
    ClassDataInter classDataInter;

    @Override
    public List<Class> findAll() {
        return (List<Class>) classDataInter.findAll();
    }
}
