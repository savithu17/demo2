package com.example.demo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name="company_table")
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name="comapany name",nullable = false)
    private String companyName;

    @Column(name="register_number",nullable = false)
    private int registerNumber;

    @ManyToOne
    @JoinColumn (name = "organization_id",nullable = false)
    private Organization organization;

}
