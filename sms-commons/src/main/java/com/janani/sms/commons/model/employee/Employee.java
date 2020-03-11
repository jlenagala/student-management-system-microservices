package com.janani.sms.commons.model.employee;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer nic;
    private String name;
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    private CurrentStatus currentStatus;

//    @OneToOne(mappedBy = "employee")
//    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Telephone> telephones;

    @OneToOne(cascade = CascadeType.ALL)
    Address addresses;

}