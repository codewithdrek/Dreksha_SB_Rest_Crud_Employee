package com.luv2code.springboot.curddemo.service;

import com.luv2code.springboot.curddemo.dao.EmployeeDao;
import com.luv2code.springboot.curddemo.entity.EmployeeNew;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDao theEmployeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.theEmployeeDao = employeeDao;
    }

    @Override
    public List<EmployeeNew> findAll() {
        return theEmployeeDao.findAll();
    }

    @Override
    public EmployeeNew findById(int theId) {
        return theEmployeeDao.findById(theId);
    }

    @Override
    @Transactional
    public EmployeeNew save(EmployeeNew employeeNew) {
        return theEmployeeDao.save(employeeNew);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
       theEmployeeDao.deleteById(theId);
    }
}
