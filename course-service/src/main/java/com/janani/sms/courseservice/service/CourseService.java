package com.janani.sms.courseservice.service;

import com.janani.sms.commons.model.course.Course;
import com.janani.sms.commons.model.employee.Employee;

import java.util.List;

public interface CourseService {
    Course save(Course course);

    Course fetchById(int profileId);

    List<Course> fetchAllProfiles();
}
