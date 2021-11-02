package com.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.codegym.model.Employee;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
