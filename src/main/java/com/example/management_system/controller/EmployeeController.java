package com.example.management_system.controller;

import com.example.management_system.dto.EmployeeDto;
import com.example.management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/cabinet/{cabinetId}/create-employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long cabinetId) {
        return new ResponseEntity<>(employeeService.createEmployee(cabinetId, employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/cabinet/{cabinetId}/employees")
    public List<EmployeeDto> getEmployeeByCabinetId(@PathVariable Long cabinetId) {
        return employeeService.getEmployeesByCabinetId(cabinetId);
    }

    @PutMapping("/{id}/cabinet/{cabinetId}/update-employee")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @PathVariable Long cabinetId, @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(id, cabinetId, updatedEmployee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete-employee")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted");
    }
}
