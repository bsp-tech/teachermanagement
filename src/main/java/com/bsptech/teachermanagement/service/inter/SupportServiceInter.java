package com.bsptech.teachermanagement.service.inter;

import com.bsptech.teachermanagement.entity.Support;
import org.springframework.stereotype.Service;

@Service
public interface SupportServiceInter {

    public Support save(Support support);
}
