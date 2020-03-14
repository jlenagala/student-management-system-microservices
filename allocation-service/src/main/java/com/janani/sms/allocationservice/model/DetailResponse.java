package com.janani.sms.allocationservice.model;

import com.janani.sms.commons.model.allocation.Allocation;
import com.janani.sms.commons.model.course.Course;
import com.janani.sms.commons.model.student.Student;

public class DetailResponse implements Response{
    Allocation allocation;
    Student student;
    Course course;

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public DetailResponse(Allocation allocation, Student student, Course course) {
        this.allocation = allocation;
        this.student = student;
        this.course = course;
    }
}
