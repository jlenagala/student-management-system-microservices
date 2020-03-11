package com.janani.sms.courseservice.repository;

import com.janani.sms.commons.model.course.Course;
import com.janani.sms.commons.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
