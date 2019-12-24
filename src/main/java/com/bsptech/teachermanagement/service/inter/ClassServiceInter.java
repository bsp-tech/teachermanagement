package com.bsptech.teachermanagement.service.inter;

import com.bsptech.teachermanagement.entity.Class;

import java.util.List;

public interface ClassServiceInter {

    List<Class> findAll();
    List<Class> findAllOrderByName();
}
