package com.janani.sms.employeeservice.services;

import com.janani.sms.commons.model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee fetchById(int profileId);

    List<Employee> fetchAllProfiles();

    void deleteEmployee(int employeeId);
}
