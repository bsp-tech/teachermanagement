package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.PostDataInter;
import com.bsptech.teachermanagement.entity.Post;
import com.bsptech.teachermanagement.service.inter.PostServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostServiceInter {


    @Autowired
    PostDataInter postDataInter;

    @Override
    public List<Post> findAll() {
        return (List<Post>) postDataInter.findAll();
    }
}
