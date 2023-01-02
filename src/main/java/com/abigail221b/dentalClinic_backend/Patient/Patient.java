package com.abigail221b.dentalClinic_backend.Patient;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private char sex;
    private Date dateOfBirth;
    private String phoneNumber;
    private String address;

}
