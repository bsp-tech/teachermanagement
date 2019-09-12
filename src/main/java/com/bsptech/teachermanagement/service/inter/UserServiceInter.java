/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.service.inter;

import com.bsptech.teachermanagement.entity.User;
import java.util.List;

/**
 *
 * @author Goshgar
 */
public interface UserServiceInter {
    public User findById(Integer id);

    public List<User> findAll();

    public User save(User user);

    public User update(User user);

    public int delete(Integer id);
}
