package com.janani.sms.studentservice.service;

import com.janani.sms.commons.model.student.Student;
import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student fetchById(int profileId);

    List<Student> fetchAllProfiles();
}
