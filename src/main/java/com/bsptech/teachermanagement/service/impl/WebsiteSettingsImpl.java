package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.WebsiteSettingDataInter;
import com.bsptech.teachermanagement.entity.WebsiteSettings;
import com.bsptech.teachermanagement.service.inter.WebsiteSettingsInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebsiteSettingsImpl implements WebsiteSettingsInter {

    @Autowired
    WebsiteSettingDataInter websiteSettingDataInter;

    @Override
    public WebsiteSettings find() {
        List<WebsiteSettings> list =(List<WebsiteSettings>) websiteSettingDataInter.findAll();
        return list.get(0);
    }
}

