package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Support;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportDataInter extends CrudRepository<Support, Integer> {


}
