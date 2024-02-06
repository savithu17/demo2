package com.example.demo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "User_table")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "First_name",nullable = false)
    private String firstName;

    @Column(name = "Last_name",nullable = false)
    private String lastName;

    @Column(name = "age",nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;


}
