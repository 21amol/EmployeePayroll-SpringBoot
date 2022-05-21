package com.example.employeepayrollspringboot.controller;
import com.example.employeepayrollspringboot.model.Employee;
import com.example.employeepayrollspringboot.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Hello")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello and Welcome !!!";
    }

    @PostMapping("/save")                                          // Adding Employee
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee newEmp;
        newEmp = employeeServices.add(employee);
        return newEmp;
    }

    @GetMapping("/show")                                   // Showing all Employee list
    public List<Employee> showAll() {
        List<Employee> response;
        response = employeeServices.showAll();
        return response;
    }

    @PutMapping("/edit/{id}")                              // Editing Employee attributes
    public Employee edit(@RequestBody Employee employee, @PathVariable int id) {
        Employee response;
        response = employeeServices.edit(id, employee);
        return response;
    }

    @DeleteMapping("/delete/{id}")                          // Deleting a Employee from Record
    public String delete(@PathVariable int id) {
        String response;
        response = employeeServices.delete(id);
        return response;
    }
}


