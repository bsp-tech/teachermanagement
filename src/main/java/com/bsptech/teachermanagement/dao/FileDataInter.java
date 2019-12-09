package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.File;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FileDataInter extends CrudRepository<File,Integer> {

    List<File> findAllBySectionIdId(Integer id);
}
