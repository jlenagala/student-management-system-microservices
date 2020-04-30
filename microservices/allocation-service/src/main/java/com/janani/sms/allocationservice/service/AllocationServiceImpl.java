package com.janani.sms.allocationservice.service;

import com.janani.sms.allocationservice.model.DetailResponse;
import com.janani.sms.allocationservice.model.DetailResponseByStudent;
import com.janani.sms.allocationservice.model.Response;
import com.janani.sms.allocationservice.repository.AllocationRepository;
import com.janani.sms.commons.model.allocation.Allocation;
import com.janani.sms.commons.model.course.Course;
import com.janani.sms.commons.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    AllocationRepository allocationRepository;
    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

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
    public List<Allocation> fetchAll() {
        return allocationRepository.findAll();
    }


    @Override
    public void deleteAllocation(int allocationId) {
        allocationRepository.deleteById(allocationId);
    }


    @Override
    public DetailResponse findDetailResponse(int allocationId) {
        Allocation allocation = fetchById(allocationId);
        Student student = getStudent(allocation.getStudentId());
        Course course = getCourse(allocation.getCourseId());
        return new DetailResponse(allocation, student, course);

    }

    @Override
    public List<DetailResponse> findDetailResponseByStudent(int studentId) {
        List<DetailResponse> detailResponseList = new ArrayList<>();
        List<Allocation> allocationList = fetchAll();
        for (Allocation allocation : allocationList) {
            System.out.println(allocation);
            if (allocation.getStudentId() == studentId) {
                System.out.println("seeid" + studentId);
                detailResponseList.add(findDetailResponse(allocation.getAllocationId()));
            }
        }

        return detailResponseList;

    }

    @Override
    public List<DetailResponse> findDetailResponseByCourse(int courseId) {
        List<DetailResponse> detailResponseList = new ArrayList<>();
        List<Allocation> allocationList = fetchAll();
        for (Allocation allocation : allocationList) {
            System.out.println(allocation);
            if (allocation.getCourseId() == courseId) {
                System.out.println("cid" + courseId);
                detailResponseList.add(findDetailResponse(allocation.getAllocationId()));
            }
        }

        return detailResponseList;
    }

    private Student getStudent(int studentId) {
        Student student = restTemplate.getForObject("http://localhost:8494/services/students/" + studentId, Student.class);
        return student;
    }

    private Course getCourse(int courseId) {
        Course course = restTemplate.getForObject("http://localhost:8585/services/courses/" + courseId, Course.class);
        return course;
    }

}


