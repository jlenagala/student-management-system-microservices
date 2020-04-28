package com.janani.sms.studentservice.repository;

import com.janani.sms.commons.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
