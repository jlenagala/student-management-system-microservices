package com.janani.sms.commons.model.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.janani.sms.commons.model.employee.Employee;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "telephone")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;

    @ManyToOne
    @JoinColumn()
    @JsonIgnore//not consider employe as a property inside a telephone class
    Student student;
}
