package com.janani.sms.profileservice.services;

import com.janani.sms.commons.model.Student;
import com.janani.sms.profileservice.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl  implements StudentService{
  @Autowired
  StudentRepository studentRepository;

    @Override
    public Student save(Student student) {

        return studentRepository.save(student);
    }
}
