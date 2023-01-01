package com.abigail221b.dentalClinic_backend.Patient;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

    List<Patient> findByPhoneNumber(String phoneNumber);

    List<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    List<Patient> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);

    List<Patient> findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    List<Patient> findByFirstNameAndLastNameAndDateOfBirthAndPhoneNumber(String firstName, String lastName, Date dateOfBirth, String phoneNumber);

}
