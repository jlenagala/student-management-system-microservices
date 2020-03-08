package com.janani.sms.commons.model;
import lombok.Data;

import javax.persistence.*;

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
    //LocalDate regDate;

}
