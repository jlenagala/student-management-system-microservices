package com.janani.sms.commons.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "course")
public class Course {
    private int id;
    private String name;
    private int duration;
    private String description;
    //private LocalDate regDate;

}
