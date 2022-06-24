package com.example.phoneVerification2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;
    private String name ;
    private String lastName ;
    private String phoneNumber ;
    private String email ;
    private String address ;
    private String countryCode ;
    private String countryName ;
    private String carrier;
    @Column(name = "valid" , nullable = false,columnDefinition = "boolean default false")
    private boolean valid;



}
