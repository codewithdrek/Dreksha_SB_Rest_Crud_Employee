package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.EmployeeNew;

import java.util.List;

public interface EmployeeDao {

   List<EmployeeNew> findAll();

   EmployeeNew findById(int theId);

   EmployeeNew save(EmployeeNew employeeNew);

   void deleteById(int theId);

}
