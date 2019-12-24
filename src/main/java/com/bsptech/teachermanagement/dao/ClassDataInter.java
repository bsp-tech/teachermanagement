package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Class;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassDataInter extends CrudRepository<Class,Integer> {
    List<Class> findAllByOrderByNameAsc();
}
