package com.janani.sms.commons.model.employee;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lane1;
    private String lane2;
    private String city;

}
