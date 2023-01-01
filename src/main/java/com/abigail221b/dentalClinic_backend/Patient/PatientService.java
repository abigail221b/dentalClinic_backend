package com.abigail221b.dentalClinic_backend.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    
    List<Patient> findAll();

    Optional<Patient> findById(Integer id);

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Integer id);

}
