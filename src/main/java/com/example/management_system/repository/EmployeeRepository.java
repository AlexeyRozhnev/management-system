package com.example.management_system.repository;

import com.example.management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByCabinetId(Long cabinetId);
}
