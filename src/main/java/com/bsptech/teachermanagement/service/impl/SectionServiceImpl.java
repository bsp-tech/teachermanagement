package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.SectionDataInter;
import com.bsptech.teachermanagement.entity.Section;
import com.bsptech.teachermanagement.service.inter.SectionServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements SectionServiceInter {
    @Autowired
    private SectionDataInter sectionDataInter;
    @Override
    public Section findById(Integer id)
    {
        return sectionDataInter.findById(id).get();
    }
}
