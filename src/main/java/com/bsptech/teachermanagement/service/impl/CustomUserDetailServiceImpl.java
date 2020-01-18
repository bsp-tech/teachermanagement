package com.bsptech.teachermanagement.service.impl;

import com.bsptech.teachermanagement.bean.CustomUserDetail;
import com.bsptech.teachermanagement.dao.UserDataInter;
import com.bsptech.teachermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDataInter userDataInter;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDataInter.findByUsername(s);
        System.out.println(user.getName());

        List<GrantedAuthority> roles = user.getGroupId().getAuthGroupRoleList()
                .stream()
                .map(u -> new SimpleGrantedAuthority(u.getRoleId().getName()))
                .collect(Collectors.toList());

        System.out.println(user.getGroupId().getAuthGroupRoleList().size());

        UserDetails userDetails = new CustomUserDetail(
                user,
                user.getUsername(),
                user.getPassword(),
                roles
        );

        return userDetails;
    }
}
