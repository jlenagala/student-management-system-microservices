package com.janani.sms.profileservice.repository;

import com.janani.sms.commons.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
