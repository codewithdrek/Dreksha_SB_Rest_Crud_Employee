package com.luv2code.springboot.curddemo.dao;


import com.luv2code.springboot.curddemo.entity.EmployeeNew;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<EmployeeNew> findAll() {
        TypedQuery<EmployeeNew> employeeTypedQuery = entityManager.createQuery("FROM EmployeeNew", EmployeeNew.class);
        List<EmployeeNew> employeeNewList = employeeTypedQuery.getResultList();
      return employeeNewList;
    }

    @Override
    public EmployeeNew findById(int theId) {
       //get employee
        EmployeeNew employeeNew = entityManager.find(EmployeeNew.class,theId);
        //return employee
        return employeeNew;
    }

    @Override
    public EmployeeNew save(EmployeeNew employeeNew) {

        //save emp
        EmployeeNew dbEmployee = entityManager.merge(employeeNew);
        //return the DBEmployee
        return dbEmployee; //no need to use @transactional  at dao level will be handle by service layer
    }

    @Override
    public void deleteById(int theId) {

        //find emp by id
        EmployeeNew employeeNew =entityManager.find(EmployeeNew.class,theId);
        entityManager.remove(employeeNew);
    }
}
