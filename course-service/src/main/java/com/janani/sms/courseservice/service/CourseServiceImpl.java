package com.janani.sms.courseservice.service;

import com.janani.sms.commons.model.course.Course;
import com.janani.sms.commons.model.employee.Employee;
import com.janani.sms.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course save(Course course) {

        return courseRepository.save(course);
    }

    @Override
    public Course fetchById(int profileId) {
        Optional<Course> course = courseRepository.findById(profileId);
        if (course.isPresent()) {
            return course.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Course> fetchAllProfiles() {
        return courseRepository.findAll();
    }
}
