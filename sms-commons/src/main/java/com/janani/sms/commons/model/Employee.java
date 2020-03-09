package com.janani.sms.commons.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nic;
    private String firstName;
    private String lastName;
    private String dob;
    private int age;
    private String description;

}
