package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.ClassDataInter;
import com.bsptech.teachermanagement.entity.Class;
import com.bsptech.teachermanagement.service.inter.ClassInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassImpl implements ClassInter {

    @Autowired
    ClassDataInter classDataInter;

    @Override
    public List<Class> findAll() {
        return (List<Class>) classDataInter.findAll();
    }
}
