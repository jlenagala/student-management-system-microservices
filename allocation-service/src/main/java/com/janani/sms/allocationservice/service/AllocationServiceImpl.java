package com.janani.sms.allocationservice.service;

import com.janani.sms.allocationservice.model.DetailResponse;
import com.janani.sms.allocationservice.repository.AllocationRepository;
import com.janani.sms.commons.model.allocation.Allocation;
import com.janani.sms.commons.model.course.Course;
import com.janani.sms.commons.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
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
            return new Allocation();
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
    public DetailResponse findDetailResponse(int allocationId,String token) {
        System.out.println("gggggg"+token);
        System.out.println("gggggg "+allocationId);
        Allocation allocation=fetchById(allocationId);

        Student student=getStudent(allocation.getStudentId(),token);

        Course course=getCourse(allocation.getCourseId(),token);

        return new DetailResponse(allocation,student,course);

    }

    private Student getStudent(int studentId,String token){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Student> response = restTemplate.exchange("http://localhost:8494/services/students/"+studentId, HttpMethod.GET, request, Student.class);
        Student student = response.getBody();

        //Student student=restTemplate.getForObject("http://localhost:8494/services/students/"+studentId,Student.class,entity);
                //getForObject("http://localhost:8494/services/students/"+studentId,entity,Student.class);

        return student;
    }
    private Course getCourse(int courseId,String token){


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Course> response = restTemplate.exchange("http://localhost:8585/services/courses/"+courseId, HttpMethod.GET, request, Course.class);
        Course course = response.getBody();
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        Course course=restTemplate.getForObject(,Course.class,entity);
        return course;
    }
}
