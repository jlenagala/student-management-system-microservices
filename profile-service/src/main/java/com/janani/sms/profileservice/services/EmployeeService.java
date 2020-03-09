package com.janani.sms.profileservice.services;

import com.janani.sms.commons.model.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student fetchById(int profileId);

    List<Student> fetchAllProfiles();
}
