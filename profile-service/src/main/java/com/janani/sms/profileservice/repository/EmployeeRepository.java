package com.janani.sms.profileservice.repository;

import com.janani.sms.commons.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
