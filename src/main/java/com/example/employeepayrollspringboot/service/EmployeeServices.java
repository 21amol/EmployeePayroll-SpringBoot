package com.example.employeepayrollspringboot.service;

import com.example.employeepayrollspringboot.model.Employee;
import com.example.employeepayrollspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee add(Employee employee) {
        Employee newEmp = new Employee(employee);
        employeeRepository.save(newEmp);
        return newEmp;
    }

    public List<Employee> showAll() {
        return employeeRepository.findAll();
    }


    public Employee edit(int id, Employee employee) {
    //    if (employeeRepository.findById(id).isPresent()) {
            Employee getEmp = employeeRepository.getReferenceById(id);
            getEmp.setName(employee.getName());
            getEmp.setSalary(employee.getSalary());

            Employee updateEmp;
            updateEmp = employeeRepository.save(getEmp);
            return updateEmp;
        }

//            Employee newEmp = new Employee(employee);
//            employeeRepository.save(newEmp);
//            return "Record Found and Edited";
//        } else{
//            return "Record not Found!!!";
//        }


    public String delete(int id) {
        Optional<Employee> newEmp = employeeRepository.findById(id);
        if (newEmp.isPresent()) {
            employeeRepository.delete(newEmp.get());
            return "Deleted record with id number: " + id;
        } else {
            return "Record not Found";
        }
    }
}
