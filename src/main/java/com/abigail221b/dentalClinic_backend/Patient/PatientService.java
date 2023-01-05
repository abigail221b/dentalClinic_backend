package com.abigail221b.dentalClinic_backend.Patient;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    
    List<Patient> findAll();

    Optional<Patient> findById(Integer id);

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

    List<Patient> findByPhoneNumber(String phoneNumber);

    List<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    List<Patient> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);

    List<Patient> findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    List<Patient> findBySearchParams(String firstName, String lastName, Date dateOfBirth, String phoneNumber);

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Integer id);

}
