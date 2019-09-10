/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.dao.UserDataInter;
import com.bsptech.teachermanagement.entity.User;
import com.bsptech.teachermanagement.service.inter.UserServiceInter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Goshgar
 */
@Service
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    UserDataInter userDataInter;

    @Override
    public User findById(Integer id) {
        return userDataInter.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userDataInter.findAll();
    }

    @Override
    public User save(User user) {
        return userDataInter.save(user);
    }

    @Override
    public User update(User user) {
        return userDataInter.save(user);
    }

    @Override
    public int delete(Integer id) {
        userDataInter.deleteById(id);
        return 0;
    }
}
