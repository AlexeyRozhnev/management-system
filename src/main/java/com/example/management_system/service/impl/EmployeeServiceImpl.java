package com.example.management_system.service.impl;

import com.example.management_system.dto.EmployeeDto;
import com.example.management_system.exception.ResourceNotFoundException;
import com.example.management_system.mapper.EmployeeMapper;
import com.example.management_system.model.Cabinet;
import com.example.management_system.model.Employee;
import com.example.management_system.repository.CabinetRepository;
import com.example.management_system.repository.EmployeeRepository;
import com.example.management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private CabinetRepository cabinetRepository;

    @Override
    public EmployeeDto createEmployee(Long cabinetId,EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Cabinet cabinet = cabinetRepository.findById(cabinetId).orElseThrow(() -> new ResourceNotFoundException("Cabinet not found"));
        employee.setCabinet(cabinet);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
//        Long cabinetId = employee.getCabinet().getId();
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByCabinetId(Long cabinetId) {
        List<Employee> employees = employeeRepository.findByCabinetId(cabinetId);
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, Long cabinetId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        Cabinet cabinet = cabinetRepository.findById(cabinetId).orElseThrow(() -> new ResourceNotFoundException("Cabinet not found"));
        employee.setCabinet(cabinet);
        employee.setFullName(updatedEmployee.getFullName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPhone(updatedEmployee.getPhone());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employeeRepository.deleteById(id);
    }
}


