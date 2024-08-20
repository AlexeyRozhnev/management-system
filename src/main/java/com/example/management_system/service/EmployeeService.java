package com.example.management_system.service;

import com.example.management_system.dto.EmployeeDto;
import com.example.management_system.model.Employee;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
}
