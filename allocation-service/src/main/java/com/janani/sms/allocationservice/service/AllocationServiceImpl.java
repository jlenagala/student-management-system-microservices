package com.janani.sms.allocationservice.service;

import com.janani.sms.allocationservice.model.DetailResponse;
import com.janani.sms.allocationservice.repository.AllocationRepository;
import com.janani.sms.commons.model.allocation.Allocation;
import com.janani.sms.commons.model.course.Course;
import com.janani.sms.commons.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    AllocationRepository allocationRepository;
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Allocation save(Allocation allocation) {

        return allocationRepository.save(allocation);
    }

    @Override
    public Allocation fetchById(int profileId) {
        Optional<Allocation> allocation = allocationRepository.findById(profileId);
        if (allocation.isPresent()) {
            return allocation.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Allocation> fetchAllProfiles() {
        return allocationRepository.findAll();
    }

    @Override
    public void deleteAllocation(int allocationId) {
        allocationRepository.deleteById(allocationId);
    }

    @Override
    public DetailResponse findDetailResponse(int allocationId) {
        Allocation allocation=fetchById(allocationId);
        Student student=getStudent(allocation.getStudentId());
        Course course=getCourse(allocation.getCourseId());
        return new DetailResponse(allocation,student,course);

    }

    private Student getStudent(int studentId){
        Student student=restTemplate.getForObject("http://localhost:8494/services/students/"+studentId,Student.class);
        return student;
    }
    private Course getCourse(int courseId){
        Course course=restTemplate.getForObject("http://localhost:8585/services/courses/"+courseId,Course.class);
        return course;
    }
}
