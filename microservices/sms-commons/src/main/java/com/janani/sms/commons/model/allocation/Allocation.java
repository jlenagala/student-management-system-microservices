package com.janani.sms.commons.model.allocation;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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
    LocalDate fromDate;
    LocalDate toDate;

}
