package com.janani.sms.employeeservice.repository;

import com.janani.sms.commons.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
