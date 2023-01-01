package com.abigail221b.dentalClinic_backend.Patient;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Patient> findById(int id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Patient save(Patient patient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
    }
    
}
