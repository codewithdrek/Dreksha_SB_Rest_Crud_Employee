package com.luv2code.springboot.curddemo.rest;

import com.luv2code.springboot.curddemo.dao.EmployeeDao;
import com.luv2code.springboot.curddemo.entity.EmployeeNew;
import com.luv2code.springboot.curddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employee")
    public List<EmployeeNew> getAllEmployee() {
        return employeeService.findAll();
    }


    //add mapping for GET /employee/{empId}
    @GetMapping("/employee/{employeeId}")
    public EmployeeNew getEmployee(@PathVariable int employeeId) {
        EmployeeNew employeeNew = employeeService.findById(employeeId);
        if (employeeNew == null) {
            throw new RuntimeException("EXception is not found" + employeeId);

        }
        return employeeNew;
    }

    //add mapping for post /employee - add new EMP
    @PostMapping("/employee")
    public EmployeeNew addEmp(@RequestBody EmployeeNew thEmployeeNew) {
        thEmployeeNew.setId(0);
        EmployeeNew employeeNew = employeeService.save(thEmployeeNew);
        return employeeNew;
    }


    //put
    @PutMapping("/employee")
    public EmployeeNew updateEmp(@RequestBody EmployeeNew employeeNew) {
        EmployeeNew employeeNew1 = employeeService.save(employeeNew);
        return  employeeNew1;
    }

    //add delete
     @DeleteMapping("/employee/{empId}")
    public String deleteById(@PathVariable int empId) throws Exception {

       EmployeeNew employeeNew = employeeService.findById(empId);
       if(employeeNew ==null){
           throw  new Exception("NO DATA : "+empId);
       }
       employeeService.deleteById(empId);
       return "Deleted Employee Id : "+empId;
     }

}
