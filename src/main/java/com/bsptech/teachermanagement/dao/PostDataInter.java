package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDataInter extends CrudRepository<Post,Integer> {

 }
