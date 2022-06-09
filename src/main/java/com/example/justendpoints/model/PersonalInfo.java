package com.example.justendpoints.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Table
@Entity(name = "UserInfo")
public class PersonalInfo {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Long mobile;

    @Column
    private LocalDate dob;

    @Transient
    private Integer age;

    @Column
    private String address;

    @Column
    private String stateOfOrigin;

    @Column
    private String nationality;


    public PersonalInfo(Long id, String name, Long mobile, LocalDate dob, String address, String stateOfOrigin, String nationality) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.dob = dob;
        this.address = address;
        this.stateOfOrigin = stateOfOrigin;
        this.nationality = nationality;
    }

    public PersonalInfo() {

    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
