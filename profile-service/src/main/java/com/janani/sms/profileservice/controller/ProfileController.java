package com.janani.sms.profileservice.controller;

import com.janani.sms.commons.model.employee.Employee;
import com.janani.sms.profileservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ProfileController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Employee fetch(@RequestParam int profileId) {
        return employeeService.fetchById(profileId);
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_operator')")
    public List<Employee> fetch() {
        return employeeService.fetchAllProfiles();
    }

}
