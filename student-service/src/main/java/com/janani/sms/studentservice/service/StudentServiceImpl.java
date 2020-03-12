package com.janani.sms.studentservice.service;

import com.janani.sms.commons.model.student.Student;
import com.janani.sms.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student fetchById(int profileId) {
        Optional<Student> student = studentRepository.findById(profileId);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Student> fetchAllProfiles() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
