/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.dao;

import com.bsptech.teachermanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Goshgar
 */

public interface UserDataInter extends CrudRepository<User, Integer>{
}
