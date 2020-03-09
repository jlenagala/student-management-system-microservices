package com.janani.sms.profileservice.services;

import com.janani.sms.commons.model.Employee;
import com.janani.sms.profileservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee student) {

        return employeeRepository.save(student);
    }

    @Override
    public Employee fetchById(int profileId) {
        Optional<Employee> student = employeeRepository.findById(profileId);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> fetchAllProfiles() {
        return employeeRepository.findAll();
    }
}
