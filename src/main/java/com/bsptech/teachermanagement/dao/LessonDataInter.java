package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Lesson;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LessonDataInter extends CrudRepository<Lesson, Integer> {

    @Query(value = "select l from Lesson l where l.name=?1 or l.about=?2 or l.thumbnailPath=?3")
    public List<Lesson> getLessonsForSearching(String name,String about,String thumbnailPath);
}
