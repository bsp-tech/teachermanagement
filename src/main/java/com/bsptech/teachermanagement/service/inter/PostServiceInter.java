package com.bsptech.teachermanagement.service.inter;

import com.bsptech.teachermanagement.entity.Post;


import java.util.List;

public interface PostServiceInter {

    List<Post> findAll();
    Post findById(Integer id);
}
