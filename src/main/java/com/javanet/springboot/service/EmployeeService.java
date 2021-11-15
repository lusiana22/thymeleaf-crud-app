package com.javanet.springboot.service;

import com.javanet.springboot.repository.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteById(long id);
}
