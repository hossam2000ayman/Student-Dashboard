package com.example.student.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "StudentName")
    private String name;

    @Column(name = "StudentAddress")
    private String address;

    @Column(name = "StudentPercentage")
    private Double percentage;




}
