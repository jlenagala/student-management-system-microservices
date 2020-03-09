package com.janani.sms.profileservice.services;

import com.janani.sms.commons.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee student);

    Employee fetchById(int profileId);

    List<Employee> fetchAllProfiles();
}
