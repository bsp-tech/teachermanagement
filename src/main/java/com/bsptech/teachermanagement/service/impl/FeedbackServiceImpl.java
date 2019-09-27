package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.FeedbackDataInter;
import com.bsptech.teachermanagement.entity.Feedback;
import com.bsptech.teachermanagement.service.inter.FeedbackServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackServiceInter {

    @Autowired
    FeedbackDataInter feedbackDataInter;

    @Override
    public List<Feedback> findAll() {
        List<Feedback> result = (List<Feedback>) feedbackDataInter.findAll();
        return result;
    }
}
