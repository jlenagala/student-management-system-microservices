package com.janani.sms.studentservice.controller;

import com.janani.sms.commons.model.student.Student;
import com.janani.sms.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Student fetch(@PathVariable(value = "id") int studentId) {
        return studentService.fetchById(studentId);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_operator')")
    public List<Student> fetch() {
        return studentService.fetchAllProfiles();
    }


    @RequestMapping(value = "/students", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('update_profile')")
    public Student updateProfile(@RequestBody Student student) {
        return studentService.save(student);
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable int studentId) {
        Student tempStudent = studentService.fetchById(studentId);
        studentService.deleteStudent(studentId);
    }
}
