package com.example.management_system.mapper;

import com.example.management_system.dto.EmployeeDto;
import com.example.management_system.model.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFullName(),
                employee.getEmail(),
                employee.getPhone()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFullName(),
                employeeDto.getEmail(),
                employeeDto.getPhone()
        );
    }
}
