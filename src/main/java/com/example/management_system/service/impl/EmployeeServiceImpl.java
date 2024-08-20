package com.example.management_system.service.impl;

import com.example.management_system.dto.EmployeeDto;
import com.example.management_system.exception.ResourceNotFoundException;
import com.example.management_system.mapper.EmployeeMapper;
import com.example.management_system.model.Employee;
import com.example.management_system.repository.EmployeeRepository;
import com.example.management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
