package com.luv2code.springboot.curddemo.dao;

import com.luv2code.springboot.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReporisiotry extends JpaRepository<Employee,Integer> {
//no need to write any code

}
