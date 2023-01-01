package com.abigail221b.dentalClinic_backend.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    
    List<Patient> findAll();

    Optional<Patient> findById(int id);

    Patient save(Patient patient);

    void delete(int id);

}
