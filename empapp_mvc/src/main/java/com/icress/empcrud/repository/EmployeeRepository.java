package com.icress.empcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icress.empcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}