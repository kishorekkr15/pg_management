package com.example.pg_manager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String district;
    private String state;
    private String pincode;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;
}