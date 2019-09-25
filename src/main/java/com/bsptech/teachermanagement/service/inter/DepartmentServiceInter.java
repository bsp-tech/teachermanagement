package com.bsptech.teachermanagement.service.inter;

import com.bsptech.teachermanagement.entity.Department;


import java.util.List;

public interface DepartmentServiceInter {

    List<Department> findAll();

    Department findById(Integer id);
}
