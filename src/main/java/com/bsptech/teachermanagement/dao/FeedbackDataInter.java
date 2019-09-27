package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackDataInter extends CrudRepository<Feedback,Integer> {
}
