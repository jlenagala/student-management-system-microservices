package com.janani.sms.employeeservice.controller;

import com.janani.sms.commons.model.employee.Employee;
import com.janani.sms.employeeservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee fetch(@PathVariable(value = "id") int employeeId) {
        return employeeService.fetchById(employeeId);
    }
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Employee> fetch() {
        return employeeService.fetchAllProfiles();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('update_profile')")
    public Employee updateProfile(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.fetchById(employeeId);
        employeeService.deleteEmployee(employeeId);
    }



}
