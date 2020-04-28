package com.janani.sms.commons.model.student;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nic;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private LocalDate regDate;
    private String gender;
    private String currentStatus;
    private String telephones;

//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    @Enumerated(EnumType.STRING)
//    private CurrentStatus currentStatus;

//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    List<Telephone> telephones;

    @OneToOne(cascade = CascadeType.ALL)
    Address addresses;

}
