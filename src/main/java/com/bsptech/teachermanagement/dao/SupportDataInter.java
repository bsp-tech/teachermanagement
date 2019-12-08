package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Support;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupportDataInter extends CrudRepository<Support, Integer> {

    List<Support> findByOrderByStatusIdIdDescInsertDateTimeAsc();

}
