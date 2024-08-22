package com.example.management_system.service;

import com.example.management_system.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(Long cabinetId, EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    List<EmployeeDto> getEmployeesByCabinetId(Long cabinetId);
    EmployeeDto updateEmployee(Long id, Long cabinetId, EmployeeDto updatedEmployee);
    void deleteEmployee(Long id);
}
