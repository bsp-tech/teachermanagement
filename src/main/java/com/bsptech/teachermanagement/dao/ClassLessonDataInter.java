/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.ClassLesson;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author murad_isgandar
 */
public interface ClassLessonDataInter extends CrudRepository<ClassLesson, Integer>{
    
}
