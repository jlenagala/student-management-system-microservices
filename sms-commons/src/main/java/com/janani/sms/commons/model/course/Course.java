package com.janani.sms.commons.model.course;
import com.janani.sms.commons.model.employee.CurrentStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    private String name;
    private int duration;
    private String description;
    LocalDate regDate;

    @Enumerated(EnumType.STRING)
    private CurrentStatus currentStatus;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;


}
