package com.javanet.springboot.service.impl;

import com.javanet.springboot.data.exception.NotFoundException;
import com.javanet.springboot.repository.entity.Employee;
import com.javanet.springboot.repository.EmployeeRepository;
import com.javanet.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No employee found with id: " + id)
        );
    }

    @Override
    public void deleteById(long id) {
//        Employee employee = employeeRepository.findById(id).orElseThrow(
//                () -> new NotFoundException("No employee found with id: " + id)
//        );
        this.employeeRepository.deleteById(id);
    }
}
