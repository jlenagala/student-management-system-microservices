package com.janani.sms.profileservice.controller;

import com.janani.sms.commons.model.Student;
import com.janani.sms.profileservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ProfileController {
    @Autowired
    StudentService studentService;
    public Student save(@RequestBody Student student){
        return studentService.save(student);

    }

}
