package com.abigail221b.dentalClinic_backend.Patient;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

    List<Patient> findByPhoneNumber(String phoneNumber);

    List<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    List<Patient> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);

    List<Patient> findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    @Query(
        value = "SELECT * FROM patient " +
                "WHERE (?1 IS NULL OR first_name = ?1) " +
                "AND (?2 IS NULL OR last_name = ?2) " +
                "AND (?3 IS NULL OR date_of_birth = ?3) " +
                "AND (?4 IS NULL OR phone_number = ?4);",
        nativeQuery = true
    )
    List<Patient> findBySearchParams(String firstName, String lastName, Date dateOfBirth, String phoneNumber);

}
