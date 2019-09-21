package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Class;
import org.springframework.data.repository.CrudRepository;

public interface ClassDataInter extends CrudRepository<Class,Integer> {
}
