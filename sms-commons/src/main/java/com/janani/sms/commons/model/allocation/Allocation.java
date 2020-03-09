package com.janani.sms.commons.model.allocation;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="allocation")
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int allocationId;
    int studentId;
    int courseId;
    int employeeId;
    LocalDate from;
    LocalDate to;
    }
