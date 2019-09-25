package com.bsptech.teachermanagement.service.inter;

import com.bsptech.teachermanagement.entity.Lesson;

import java.util.List;
public interface LessonServiceInter {
    public List<Lesson> findAll();
    public Lesson findById(Integer id);

}