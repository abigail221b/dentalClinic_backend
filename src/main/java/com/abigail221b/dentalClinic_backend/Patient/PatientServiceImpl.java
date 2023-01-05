package com.abigail221b.dentalClinic_backend.Patient;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findByFirstName(String firstName) {
        return patientRepository.findByFirstName(firstName);
    }

    @Override
    public List<Patient> findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    @Override
    public List<Patient> findByPhoneNumber(String phoneNumber) {
        return patientRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Patient> findByFirstNameAndLastName(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Patient> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth) {
        return patientRepository.findByFirstNameAndLastNameAndDateOfBirth(firstName, lastName, dateOfBirth);
    }

    @Override
    public List<Patient> findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName,
            String phoneNumber) {
        return patientRepository.findByFirstNameAndLastNameAndPhoneNumber(firstName, lastName, phoneNumber);
    }

    @Override
    public List<Patient> findBySearchParams(String firstName, String lastName, Date dateOfBirth, String phoneNumber) {
        return patientRepository.findByFirstNameAndLastNameAndDateOfBirthAndPhoneNumber(firstName, lastName, dateOfBirth, phoneNumber);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Integer id) {
        patientRepository.deleteById(id);
    }

}
