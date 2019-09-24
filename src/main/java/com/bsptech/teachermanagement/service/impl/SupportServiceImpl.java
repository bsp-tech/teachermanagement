package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.SupportDataInter;
import com.bsptech.teachermanagement.entity.Support;
import com.bsptech.teachermanagement.service.inter.SupportServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements SupportServiceInter {



    @Autowired
    SupportDataInter supportDataInter;


    @Override
    public Support save(Support support) {
        return supportDataInter.save(support);
    }
}
