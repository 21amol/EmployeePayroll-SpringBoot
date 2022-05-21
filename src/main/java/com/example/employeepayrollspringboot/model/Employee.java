package com.example.employeepayrollspringboot.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Employee {

    @Id
    @GeneratedValue
    public int id;
    private String name;
    private int salary ;

    public Employee() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(Employee employee) {
        this.name = employee.getName();
        this.salary = employee.getSalary();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

}
