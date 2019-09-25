package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.StatusDataInter;
import com.bsptech.teachermanagement.entity.Status;
import com.bsptech.teachermanagement.service.inter.StatusServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusServiceInter {


    @Autowired
    StatusDataInter statusDataInter;


    @Override
    public Status findById(Integer id) {

        return statusDataInter.findById(id).get();
    }
}
