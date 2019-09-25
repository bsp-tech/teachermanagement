package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonDataInter extends CrudRepository<Lesson,Integer> {
}
