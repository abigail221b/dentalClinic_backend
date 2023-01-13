package com.abigail221b.dentalClinic_backend.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> findAll();

    Optional<Patient> findById(Integer id);

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

    List<Patient> findByPhoneNumber(String phoneNumber);

    List<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    List<Patient> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth);

    List<Patient> findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    List<Patient> findBySearchParams(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber);

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Integer id);

}
