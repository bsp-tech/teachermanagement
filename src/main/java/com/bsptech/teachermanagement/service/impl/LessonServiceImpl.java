package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.LessonDataInter;
import com.bsptech.teachermanagement.entity.Lesson;
import com.bsptech.teachermanagement.service.inter.LessonServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LessonServiceImpl implements LessonServiceInter {
    @Autowired
    private LessonDataInter lessonDataInter;
    @Override
    public List<Lesson> findAll() {
        return (List<Lesson>) lessonDataInter.findAll();
    }

    @Override
    public Lesson findById(Integer id) {
        return lessonDataInter.findById(id).get();
    }
}
